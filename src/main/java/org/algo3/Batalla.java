package org.algo3;

import java.util.ArrayList;
import java.util.Optional;

public class Batalla {
    public static final int CANTIDAD_JUGADORES = 2;
    private Jugador[] jugadores;
    private Jugador ganador;

    public Batalla(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.ganador = null;
    }

    public boolean estaTerminada(){
        return this.ganador!=null;
    }

    public void setGanador(int indiceGanador) {
        this.ganador = this.jugadores[indiceGanador];
    }

    public String getGanador() {
        return ganador.nombre;
    }

    public Jugador getJugador(int indiceJugador){

        return this.jugadores[indiceJugador];
    }
    public Jugador getOponente(int indiceJugador){
        return this.jugadores[(indiceJugador+1)%CANTIDAD_JUGADORES];
    }


    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void actualizarEstado() {
        if (ganador != null) return;

        boolean hayJugadorSinVencer = false;
        for(Jugador jugador : this.jugadores){
            if (jugador.tienePokemonesVivos()){
                if (hayJugadorSinVencer){
                    this.ganador = null;
                    return;
                }
                hayJugadorSinVencer=true;
                this.ganador = jugador;
            }
        }
    }
}
