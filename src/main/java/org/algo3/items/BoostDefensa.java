package org.algo3.items;

import org.algo3.Pokemon;

public class BoostDefensa extends Item{
    private final static String NOMBRE = "Boost Defensa";

    public BoostDefensa(int cantidad) {
        super(NOMBRE, cantidad);
    }

    public void usar(Pokemon pokemon){
        super.usar(pokemon);
        pokemon.boostDefensa();
    }
}
