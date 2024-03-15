package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Pokemon;

public class CambioDePokemon extends Accion{
    private Pokemon reemplazo;

    public CambioDePokemon(Batalla batalla, int indiceJugador, Pokemon reemplazo) {
        super(batalla, indiceJugador);
        this.reemplazo = reemplazo;
    }

    @Override
    public void ejecutar() {
        batalla.getJugador(indiceJugador).setPokemonActual(reemplazo);
    }
}
