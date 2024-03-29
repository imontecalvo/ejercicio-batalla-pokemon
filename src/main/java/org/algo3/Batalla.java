package org.algo3;

public class Batalla {
    public static final int CANTIDAD_JUGADORES = 2;
    private final Jugador[] jugadores;
    private Jugador ganador;

    public Batalla(Jugador jugador1, Jugador jugador2) {
        this.jugadores = new Jugador[]{jugador1, jugador2};
        this.ganador = null;
    }

    public String getGanador() {
        return ganador.nombre;
    }

    public Jugador getJugador(int indiceJugador) {

        return this.jugadores[indiceJugador];
    }

    public int jugadorConMaxVelocidad() {
        int idxJugador = 0;
        float maxVelocidad = 0f;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].maxVelocidad() > maxVelocidad) {
                idxJugador = i;
                maxVelocidad = jugadores[i].maxVelocidad();
            }
        }
        return idxJugador;
    }

    public boolean estaTerminada() {
        return ganador != null;
    }


    public void actualizarEstado() {
        if (ganador != null) return;

        if (!jugadores[0].tienePokemonesVivos()) {
            ganador = jugadores[1];
        } else if (!jugadores[1].tienePokemonesVivos()) {
            ganador = jugadores[0];
        }
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Jugador getOponente(Jugador jugador) {
        return jugadores[0] == jugador ? jugadores[1] : jugadores[0];
    }

    public void rendirse(Jugador jugador) {
        ganador = getOponente(jugador);
    }
}
