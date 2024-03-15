package org.algo3;

import org.algo3.acciones.*;
import org.algo3.items.*;
import org.algo3.vista.Vista;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AdminDeAcciones {
    private Batalla batalla;
    private int indiceJugador;
    private Jugador jugador;
    private boolean ataqueRealizado;

    private HashSet<Item> itemsUsados;

    private Vista vista;
    private InteraccionUsuario interaccionUsuario;

    public AdminDeAcciones(Batalla batalla, int indiceJugador, Vista vista) {
        this.batalla = batalla;
        this.indiceJugador = indiceJugador;
        this.jugador = batalla.getJugador(indiceJugador);
;        this.ataqueRealizado = false;
        this.vista = vista;
        this.interaccionUsuario = new InteraccionUsuario(batalla);
    }

    public void manejarAcciones(){
        while (!this.ataqueRealizado && !this.batalla.estaTerminada()){
            vista.mostrar(this.indiceJugador);
            Accion accion = solicitarAccion();
            if (accion==null) continue;
            accion.ejecutar();
        }
    }

    private Accion solicitarAccion(){
        String[] opciones = {"Rendirse","Cambiar pokemon","Usar item","Atacar"};
        int inputAccion = this.interaccionUsuario.solicitarOpcion(opciones, "accion");

        return switch (inputAccion) {
            case 1 -> new Rendicion(this.batalla, this.indiceJugador);
            case 2 -> manejarCambioDePokemon();
            case 3 -> manejarUsoDeItem();
            case 4 -> manejarAtaque();
            default -> null;
        };
    }

    //TODO: Validar seleccion, solo mostrar items con cantidad > 0
    private Accion manejarUsoDeItem() {
        ArrayList<Item> listaItems= jugador.getItems();
        String[] opcionesItems = listaItems.stream()
                .map(item -> String.format("%s x%d",item.getNombre(), item.getCantidad()))
                .toArray(String[]::new);

        int indiceItem = this.interaccionUsuario.solicitarOpcion(opcionesItems, "item", true)-1;
        if (cancelarSeleccion(indiceItem, listaItems.size())) return null;
        Item itemSeleccionado= listaItems.get(indiceItem);

        Pokemon pokemonSeleccionado = jugador.getPokemonActual();

        if (itemSeleccionado instanceof PocionRestauradoraDeVida){
            pokemonSeleccionado = solicitarPokemon(jugador.getPokemonesVivos());
        }else if (itemSeleccionado instanceof Resurreccion){
            pokemonSeleccionado = solicitarPokemon(jugador.getPokemonesMuertos());
        }

        if (pokemonSeleccionado==null) return null;
        return new UsoDeItem(batalla, indiceJugador, itemSeleccionado, pokemonSeleccionado);
    }

    private Pokemon solicitarPokemon(ArrayList<Pokemon> pokemones){
        String[] opcionesPokemon = pokemones.stream().map(Pokemon::getNombre).toArray(String[]::new);
        int indicePokemon = interaccionUsuario.solicitarOpcion(opcionesPokemon,"pokemon", true)-1;
        if (cancelarSeleccion(indicePokemon, pokemones.size())) return null;
        return pokemones.get(indicePokemon);
    }

    private boolean cancelarSeleccion(int opcion, int cantidadOpciones){
        return opcion == cantidadOpciones;
    }

    //TODO: Validar seleccion + astraer interaccion en Vista
    private Accion manejarCambioDePokemon(){
        Pokemon pokemonSeleccionado = solicitarPokemon(jugador.getPokemonesSeleccionables());
        if (pokemonSeleccionado==null) return null;
        return new CambioDePokemon(batalla, indiceJugador, pokemonSeleccionado);
    }

    private Accion manejarAtaque(){
        this.ataqueRealizado = true;
        return new Ataque(this.batalla, this.indiceJugador);
    }
}
