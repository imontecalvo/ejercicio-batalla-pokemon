package org.algo3;

import org.algo3.Batalla;
import org.algo3.acciones.Accion;
import org.algo3.acciones.CambioDePokemon;
import org.algo3.acciones.Rendicion;
import org.algo3.vista.Vista;
import org.algo3.vista.VistaPokemon;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminDeAcciones {
    private Batalla batalla;
    private int indiceJugador;
    private boolean ataqueRealizado;

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
        System.out.print("Relaizar accion: ");
        int inputAccion = scanner.nextInt();
        //int inputAccion = 1;

        switch (inputAccion){
            case 1:
                return new Rendicion(this.batalla, this.indiceJugador);
            case 2:
                return manejarCambioDePokemon();
            default:
                return null;
        }
    }

    private Accion manejarCambioDePokemon(){
        Jugador jugador= this.batalla.getJugador(this.indiceJugador);
        ArrayList<Pokemon> pokemones = jugador.getPokemonesSeleccionables();
        int i = 0;
        for (Pokemon pokemon : pokemones){
            System.out.printf("\t%d. %s\n", i, pokemon.getNombre());
        }
        System.out.print("Seleccionar pokemon: ");
        Scanner scanner = new Scanner(System.in);
        int indicePokemon = scanner.nextInt();

        return new CambioDePokemon(batalla, indiceJugador, pokemones.get(indicePokemon));
    }

}
