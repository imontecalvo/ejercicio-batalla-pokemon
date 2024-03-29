package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;
import org.algo3.Pokemon;

public class CambioDePokemon extends Accion{
    private Pokemon reemplazo;

    public CambioDePokemon(Batalla batalla, Jugador ejecutor, Pokemon reemplazo) {
        super(batalla, ejecutor);
        this.reemplazo = reemplazo;
    }

    @Override
    public void ejecutar() {
        ejecutor.setPokemonActual(reemplazo);
    }
}
