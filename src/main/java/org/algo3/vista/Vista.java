package org.algo3.vista;
import org.algo3.Jugador;

public class Vista {
    public void mostrar(Jugador jugadorActual, Jugador[] jugadores) {
        System.out.printf("\n\n============================== Turno de %s ==============================\n\n",
                jugadorActual.getNombre());

        for (Jugador jugador : jugadores) {
            VistaJugador.mostrar(jugador);
            System.out.println("\n---------------------------------");
        }
        System.out.print("\n\n=========================================================================\n\n");
    }

    public void iniciar() {
        System.out.printf("╔%s╗\n", "═".repeat(75));
        System.out.printf("║%sBIENVENIDO A LA BATALLA POKEMON%s║\n", " ".repeat(22), " ".repeat(22));
        System.out.printf("╚%s╝\n\n\n", "═".repeat(75));
    }

}
