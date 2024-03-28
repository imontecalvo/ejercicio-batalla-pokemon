package org.algo3.items;

import org.algo3.Pokemon;

public class Resurreccion extends Item{

    private static final String NOMBRE = "Resurreccion";
    public Resurreccion() {
        super(NOMBRE);
    }

    public void usar(Pokemon pokemon){
        pokemon.revivir();
    }
}
