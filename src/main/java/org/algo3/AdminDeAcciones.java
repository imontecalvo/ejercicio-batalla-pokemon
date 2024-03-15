package org.algo3;

import org.algo3.acciones.*;
import org.algo3.items.BoostAtaque;
import org.algo3.items.BoostDefensa;
import org.algo3.items.Item;
import org.algo3.items.PocionRestauradoraDeVida;
import org.algo3.vista.Vista;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AdminDeAcciones {
    private Batalla batalla;
    private int indiceJugador;
    private boolean ataqueRealizado;

    private HashSet<Item> itemsUsados;

    private Vista vista;
    private InteraccionUsuario interaccionUsuario;

    public AdminDeAcciones(Batalla batalla, int indiceJugador, Vista vista) {
        this.batalla = batalla;
        this.indiceJugador = indiceJugador;
        this.ataqueRealizado = false;
        this.vista = vista;
        this.interaccionUsuario = new InteraccionUsuario(batalla);
    }

    public void manejarAcciones(){
        while (!this.ataqueRealizado && !this.batalla.estaTerminada()){
            vista.mostrar(this.indiceJugador);
            Accion accion = solicitarAccion();
            accion.ejecutar();
        }
    }

    private Accion solicitarAccion(){
        String[] opciones = {"Rendirse","Cambiar pokemon","Usar item","Atacar"};
        int inputAccion = this.interaccionUsuario.solicitarOpcion(opciones, "accion");

        switch (inputAccion){
            case 1:
                return new Rendicion(this.batalla, this.indiceJugador);
            case 2:
                return manejarCambioDePokemon();
            case 3:
                return manejarUsoDeItem();
            case 4:
                return manejarAtaque();
            default:
                return null;
        }
    }

    //TODO: Validar seleccion, solo mostrar items con cantidad > 0
    private Accion manejarUsoDeItem() {
        Jugador jugador = this.batalla.getJugador(this.indiceJugador);
        ArrayList<Item> listaItems= jugador.getItems();
        String[] opcionesItems = listaItems.stream()
                .map(item -> String.format("%s x%d",item.getNombre(), item.getCantidad()))
                .toArray(String[]::new);

        int indiceItem = this.interaccionUsuario.solicitarOpcion(opcionesItems, "item")-1;
        Item itemSeleccionado= listaItems.get(indiceItem);

        if(itemSeleccionado instanceof BoostAtaque || itemSeleccionado instanceof BoostDefensa){
            return new UsoDeItem(batalla, indiceJugador, itemSeleccionado, jugador.getPokemonActual());

        }else if (itemSeleccionado instanceof PocionRestauradoraDeVida){
            Pokemon pokemonSeleccionado = solicitarPokemon(jugador.getPokemonesVivos());
            return new UsoDeItem(batalla, indiceJugador, itemSeleccionado, pokemonSeleccionado);

        }else{
            Pokemon pokemonSeleccionado = solicitarPokemon(jugador.getPokemonesMuertos());
            return new UsoDeItem(batalla, indiceJugador, itemSeleccionado, pokemonSeleccionado);
        }
    }

    private Pokemon solicitarPokemon(ArrayList<Pokemon> pokemones){
        String[] opcionesPokemon = pokemones.stream().map(Pokemon::getNombre).toArray(String[]::new);
        int indicePokemon = interaccionUsuario.solicitarOpcion(opcionesPokemon,"pokemon")-1;
        return pokemones.get(indicePokemon);
    }

    //TODO: Validar seleccion + astraer interaccion en Vista
    private Accion manejarCambioDePokemon(){
        Jugador jugador= this.batalla.getJugador(this.indiceJugador);
        ArrayList<Pokemon> pokemones = jugador.getPokemonesSeleccionables();
        String[] opciones = pokemones.stream().map(Pokemon::getNombre).toArray(String[]::new);

        int indicePokemon = this.interaccionUsuario.solicitarOpcion(opciones, "pokemon")-1;
        jugador.setPokemonActual(pokemones.get(indicePokemon));
        return new CambioDePokemon(batalla, indiceJugador, pokemones.get(indicePokemon));
    }

    private Accion manejarAtaque(){
        this.ataqueRealizado = true;
        return new Ataque(this.batalla, this.indiceJugador);
    }

}
