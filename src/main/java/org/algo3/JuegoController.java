package org.algo3;

import org.algo3.vista.Vista;

public class JuegoController {
    private final Batalla batalla;
    private int turnoActual;
    private final Vista vista;

    public JuegoController(Batalla batalla, Vista vista) {
        this.batalla = batalla;
        this.vista = vista;
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
