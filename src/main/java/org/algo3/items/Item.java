package org.algo3.items;

import org.algo3.Pokemon;

public abstract class Item {
    private String nombre;

    public Item(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void usar(Pokemon pokemonAfectado);

}
