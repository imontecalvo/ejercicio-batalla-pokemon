package org.algo3.items;

import org.algo3.Pokemon;

public abstract class PocionRestauradoraDeVida extends Item {
    private float capacidad;
    public PocionRestauradoraDeVida(String nombre, float capacidad, int cantidad) {
        super(nombre, cantidad);
        this.capacidad = capacidad;
    }

    public void usar(Pokemon pokemon){
        super.usar(pokemon);
        pokemon.restaurarVida(capacidad);
    }
}
