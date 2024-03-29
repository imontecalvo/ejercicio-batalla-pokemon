package org.algo3.items;

import org.algo3.Pokemon;

public class BoostAtaque extends Item{

    private final static String NOMBRE = "Boost Ataque";

    public BoostAtaque() {
        super(NOMBRE);
    }

    @Override
    public void usar(Pokemon pokemon){
        pokemon.boostAtaque();
    }
}
