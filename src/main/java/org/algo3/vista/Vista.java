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
        clearConsole();
        Jugador[] jugadores = batalla.getJugadores();
        System.out.printf("\n\n============================== Turno de %s ==============================\n\n",
                jugadores[indiceJugador].getNombre());

        for (Jugador jugador : jugadores){
            VistaJugador.mostrar(jugador);
            System.out.println("\n---------------------------------");
        }
        System.out.print("\n\n=========================================================================\n\n");
    }

    private static void clearConsole(){
        final String os = System.getProperty("os.name");
        try{
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }else{
                Runtime.getRuntime().exec("clear");
            }

        }catch (final Exception e){
            System.err.println(e);
        }
    }
}
