package org.algo3;

import org.algo3.vista.Vista;

public class JuegoController {
    private final Batalla batalla;
    private int turnoActual;
    private final Vista vista;

    public JuegoController(ConjuntoPokemones conjuntoPokemones, ConjuntoItems conjuntoItems) {
        vista = new Vista();
        vista.iniciar();

        GeneradorJugador generadorJugador = new GeneradorJugador(conjuntoPokemones, conjuntoItems);
        Jugador jugador1 = generadorJugador.generar(1);
        Jugador jugador2 = generadorJugador.generar(2);

        this.batalla = new Batalla(jugador1, jugador2);
        this.turnoActual = batalla.jugadorConMaxVelocidad();
    }

    public void iniciar() {
        while (!batalla.estaTerminada()) {
            AdminDeAcciones adminDeAcciones = new AdminDeAcciones(batalla, turnoActual, vista);
            adminDeAcciones.manejarAcciones();
            batalla.actualizarEstado();
            cambiarTurno();
        }
        System.out.println("Ganador: " + batalla.getGanador());
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual + 1) % Batalla.CANTIDAD_JUGADORES;
    }
}
