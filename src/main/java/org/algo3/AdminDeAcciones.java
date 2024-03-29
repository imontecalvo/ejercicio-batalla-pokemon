package org.algo3;

//import org.algo3.acciones.*;
import org.algo3.acciones.*;
import org.algo3.items.*;
import org.algo3.vista.Vista;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AdminDeAcciones {
    private Batalla batalla;
    private int indiceJugador;
    private Jugador ejecutor;
    private boolean ataqueRealizado;
    private List<AccionFactory> acciones;
    private Vista vista;

    public AdminDeAcciones(Batalla batalla, int indiceJugador, Vista vista) {
        this.batalla = batalla;
        this.indiceJugador = indiceJugador;
        this.ejecutor = batalla.getJugador(indiceJugador);
        this.ataqueRealizado = false;
        this.vista = vista;

        acciones = new ArrayList<>();
        acciones.add(new AccionFactoryRendicion());
        acciones.add(new AccionFactoryAtaque());
        acciones.add(new AccionFactoryCambioDePokemon());
        acciones.add(new AccionFactoryUsoDeItem());
    }

    public void manejarAcciones() {
        chequearPokemonActivo();
        while (!this.ataqueRealizado && !this.batalla.estaTerminada()){
            vista.mostrar(ejecutor);
            Accion accion = solicitarAccion();
            if (accion==null) continue;
            accion.ejecutar();
        }
    }

    private void chequearPokemonActivo(){
/*        if (!ejecutor.pokemonActivoVivo()){
            vista.solicitarPokemon();
        }*/
    }

    private Accion solicitarAccion(){
        String[] opciones = {"Rendirse","Cambiar pokemon","Usar item","Atacar"};
        int inputAccion = InteraccionUsuario.solicitarOpcion(opciones, "accion");
        return acciones.get(inputAccion).crear(batalla, ejecutor);
    }

/*    public void manejarAcciones(){
        while (!this.ataqueRealizado && !this.batalla.estaTerminada()){
            vista.mostrar(this.indiceJugador);
            Accion accion = solicitarAccion();
            if (accion==null) continue;
            accion.ejecutar();
        }
    }



    private Accion manejarUsoDeItem() {
        ArrayList<Item> listaItems= jugador.getItems();
        //TODO: PoLK en item.getNombre() y item.getCantidad()
        String[] opcionesItems = listaItems.stream()
                .map(item -> String.format("%s x%d",item.getNombre(), item.getCantidad()))
                .toArray(String[]::new);

        int indiceItem = this.interaccionUsuario.solicitarOpcion(opcionesItems, "item", true)-1;
        if (cancelarSeleccion(indiceItem, listaItems.size())) return null;
        Item itemSeleccionado= listaItems.get(indiceItem);

        Pokemon pokemonSeleccionado = jugador.getPokemonActual();

        //TODO: No es extensible
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

    private Accion manejarCambioDePokemon(){
        Pokemon pokemonSeleccionado = solicitarPokemon(jugador.getPokemonesSeleccionables());
        if (pokemonSeleccionado==null) return null;
        return new CambioDePokemon(batalla, indiceJugador, pokemonSeleccionado);
    }

    private Accion manejarAtaque(){
        this.ataqueRealizado = true;
        return new Ataque(this.batalla, this.indiceJugador);
    }*/
}
