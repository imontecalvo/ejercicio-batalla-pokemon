package org.algo3.items;

import org.algo3.Pokemon;

public class BoostDefensa extends Item{
    private final static String NOMBRE = "Boost Defensa";

    public BoostDefensa() {
        super(NOMBRE);
    }

    public void usar(Pokemon pokemon){
        pokemon.boostDefensa();
    }
}
