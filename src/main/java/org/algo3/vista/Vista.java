package org.algo3.vista;

import org.algo3.Batalla;
import org.algo3.Jugador;

import java.util.ArrayList;

public class Vista {
    private Batalla batalla;

    public Vista(Batalla batalla) {
        this.batalla = batalla;
    }

    public void mostrar(int indiceJugador){
        Jugador[] jugadores = batalla.getJugadores();
        System.out.printf("\n\n============================== Turno de %s ==============================\n\n",
                jugadores[indiceJugador].getNombre());

        for (Jugador jugador : jugadores){
            VistaJugador.mostrar(jugador);
            System.out.println("\n---------------------------------");
        }
        System.out.printf("======================================================\n\n");
    }
}
