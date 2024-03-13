package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;

public class Ataque extends Accion{
    private Jugador atacante;
    private Jugador atacado;
    public Ataque(Batalla batalla, int indiceJugador) {
        super(batalla, indiceJugador);
        this.atacante = batalla.getJugador(indiceJugador);
        this.atacado = batalla.getOponente(indiceJugador);
    }

    @Override
    public void ejecutar() {
        final int ataque = this.atacante.getPokemonActual().getAtaque();
        this.atacado.getPokemonActual().reducirVida(ataque);
    }
}
