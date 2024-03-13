package org.algo3;

import org.algo3.acciones.*;
import org.algo3.items.BoostAtaque;
import org.algo3.items.Item;
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

    public AdminDeAcciones(Batalla batalla, int indiceJugador) {
        this.batalla = batalla;
        this.indiceJugador = indiceJugador;
        this.ataqueRealizado = false;
        this.vista = new Vista(batalla);
    }

    public void manejarAcciones(){
        while (!this.ataqueRealizado && !this.batalla.estaTerminada()){
            vista.mostrar(this.indiceJugador);
            Accion accion = solicitarAccion();
            accion.ejecutar();
        }
    }

    private Accion solicitarAccion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccionar accion:\n\t1. Rendirse\n\t2. Cambiar pokemon\n\t3. Usar item\n\t4. Atacar");
        System.out.print("Realizar accion: ");
        int inputAccion = scanner.nextInt();
        //int inputAccion = 1;

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

    private Accion manejarUsoDeItem() {
        Scanner scanner = new Scanner(System.in);
        Jugador jugador = this.batalla.getJugador(this.indiceJugador);
        ArrayList<Item> listaItems= jugador.getItems();
        int i = 1;
        for (Item item : listaItems){
            System.out.printf("%d. %s x%d\n", i, item.getNombre(), item.getCantidad());
            i++;
        }
        System.out.print("Seleccionar item: ");
        int indiceItem = scanner.nextInt()-1;
        Item itemSeleccionado= listaItems.get(indiceItem);

        if(itemSeleccionado instanceof BoostAtaque){
            return new UsoDeItem(batalla, indiceJugador, itemSeleccionado, jugador.getPokemonActual());
        }
        System.out.println("¿A cuál pokemon lo deseas aplicar?");
        return new UsoDeItem(batalla, indiceJugador, itemSeleccionado, jugador.getPokemonActual());
        //return new UsoDeItem(itemSeleccionado);
    }

    //TODO: Validar seleccion + astraer interaccion en Vista + mostrar listado pokemones
    private Accion manejarCambioDePokemon(){
        Jugador jugador= this.batalla.getJugador(this.indiceJugador);
        ArrayList<Pokemon> pokemones = jugador.getPokemonesSeleccionables();
        int i = 1;
        for (Pokemon pokemon : pokemones){
            System.out.printf("\t%d. %s\n", i, pokemon.getNombre());
            i++;
        }
        System.out.print("Seleccionar pokemon: ");
        Scanner scanner = new Scanner(System.in);
        int indicePokemon = scanner.nextInt()-1;

        jugador.setPokemonActual(pokemones.get(indicePokemon));
        return new CambioDePokemon(batalla, indiceJugador, pokemones.get(indicePokemon));
    }

    private Accion manejarAtaque(){
        this.ataqueRealizado = true;
        return new Ataque(this.batalla, this.indiceJugador);
    }

}
