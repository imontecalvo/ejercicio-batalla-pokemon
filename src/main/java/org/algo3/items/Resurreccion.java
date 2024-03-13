package org.algo3.items;

import org.algo3.Pokemon;

public class Resurreccion extends Item{

    private static final String NOMBRE = "Resurreccion";
    public Resurreccion(int cantidad) {
        super(NOMBRE, cantidad);
    }

    public void usar(Pokemon pokemon){
        super.usar(pokemon);
        pokemon.revivir();
    }
}
