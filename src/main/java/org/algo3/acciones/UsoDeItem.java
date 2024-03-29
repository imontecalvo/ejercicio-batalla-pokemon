package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;
import org.algo3.Pokemon;
import org.algo3.items.Item;

public class UsoDeItem extends Accion {
    private final Item item;
    private final Pokemon pokemonAfectado;

    public UsoDeItem(Batalla batalla, Jugador ejecutor, Item item, Pokemon pokemonAfectado) {
        super(batalla, ejecutor);
        this.item = item;
        this.pokemonAfectado = pokemonAfectado;
    }

    @Override
    public void ejecutar() {
        item.usar(pokemonAfectado);
        ejecutor.gastarItem(item);
    }
}
