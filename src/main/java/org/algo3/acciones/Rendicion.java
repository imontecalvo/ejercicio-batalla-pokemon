package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;

public class Rendicion extends Accion{
    public Rendicion(Batalla batalla, Jugador ejecutor) {
        super(batalla, ejecutor);
    }

    @Override
    public void ejecutar() {
//        int indiceOponente = (this.indiceJugador+1)%Batalla.CANTIDAD_JUGADORES;
//        this.batalla.setGanador(indiceOponente);
    }

}
