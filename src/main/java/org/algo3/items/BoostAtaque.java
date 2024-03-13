package org.algo3.items;

import org.algo3.Pokemon;

public class BoostAtaque extends Item{

    private final static String NOMBRE = "Boost Ataque";

    public BoostAtaque(int cantidad) {
        super(NOMBRE, cantidad);
    }

    public void usar(Pokemon pokemon){
        super.usar(pokemon);
        pokemon.boostAtaque();
    }
}
