package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Pokemon;
import org.algo3.items.Item;

public class UsoDeItem extends Accion{
    private Item item;
    private Pokemon pokemonAfectado;

    public UsoDeItem(Batalla batalla, int indiceJugador, Item item, Pokemon pokemonAfectado) {
        super(batalla, indiceJugador);
        this.item = item;
        this.pokemonAfectado = pokemonAfectado;
    }

    @Override
    public void ejecutar(){
        this.item.usar(this.pokemonAfectado);
    }
}
