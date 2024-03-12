package org.algo3.acciones;

import org.algo3.Batalla;

public class Rendicion extends Accion{
    public Rendicion(Batalla batalla, int indiceJugador) {
        super(batalla, indiceJugador);
    }

    @Override
    public void ejecutar() {
        int indiceOponente = (this.indiceJugador+1)%Batalla.CANTIDAD_JUGADORES;
        this.batalla.setGanador(indiceOponente);
    }

}
