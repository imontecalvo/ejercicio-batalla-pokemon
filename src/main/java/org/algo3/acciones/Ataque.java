package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;

public class Ataque extends Accion{
    private Jugador atacado;
    public Ataque(Batalla batalla, Jugador ejecutor) {
        super(batalla, ejecutor);
        this.atacado = batalla.getOponente(ejecutor);
    }

    //TODO: Calcular ataque con todas las variables y su respectiva formula
    @Override
    public void ejecutar() {
        //final float ataque = this.ejecutor.getPokemonActual().getAtaque();
        //this.atacado.getPokemonActual().reducirVida(ataque);
    }
}
