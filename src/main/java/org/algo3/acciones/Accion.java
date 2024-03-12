package org.algo3.acciones;

import org.algo3.Batalla;

public abstract class Accion {
    protected Batalla batalla;
    protected int indiceJugador;

    public Accion(Batalla batalla, int indiceJugador) {
        this.batalla = batalla;
        this.indiceJugador = indiceJugador;
    }

    public abstract void ejecutar();
}
