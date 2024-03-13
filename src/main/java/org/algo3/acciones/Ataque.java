package org.algo3.acciones;

import org.algo3.Batalla;

public class Ataque extends Accion{
    public Ataque(Batalla batalla, int indiceJugador) {
        super(batalla, indiceJugador);
    }

    @Override
    public void ejecutar() {
        System.out.println("ATACANDO!!!");
    }
}
