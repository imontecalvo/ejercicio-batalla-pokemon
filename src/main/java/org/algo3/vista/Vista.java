package org.algo3.vista;

import org.algo3.Jugador;

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
//    private Batalla batalla;
    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

/*    public void mostrar(int indiceJugador){
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
    }*/

    public void iniciar() {
        System.out.printf("╔%s╗\n","═".repeat(75));
        System.out.printf("║%sBIENVENIDO A LA BATALLA POKEMON%s║\n"," ".repeat(22), " ".repeat(22));
        System.out.printf("╚%s╝\n\n\n","═".repeat(75));
    }

    public String solicitarJugador(int numero) {
        System.out.printf("=> Ingrese el nombre del jugador %d: ", numero);
        String nombre = scanner.next();
        return nombre;
    }
}
