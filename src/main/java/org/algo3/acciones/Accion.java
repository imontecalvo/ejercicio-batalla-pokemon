package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;

public abstract class Accion {
    protected Batalla batalla;
    protected Jugador ejecutor;

    public Accion(Batalla batalla, Jugador ejecutor) {
        this.batalla = batalla;
        this.ejecutor = ejecutor;
    }

    public abstract void ejecutar();

    public boolean esAtaque() {
        return false;
    }
}
