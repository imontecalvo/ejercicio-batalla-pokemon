package org.algo3.vista;

import org.algo3.Pokemon;

public abstract class VistaPokemon {

    public static void mostrar(Pokemon pokemon){
        System.out.printf("%s - Vida: %d / %d\n", pokemon.getNombre(), pokemon.getVida(), pokemon.getVidaMax());
    }

    public static void mostrarEnDetalle(Pokemon pokemon){
        System.out.printf("%s\n\tVida: %d / %d\n\tAtaque: %d\n\tDefensa: %d\n\tVelocidad: %d\n",
                pokemon.getNombre(),
                pokemon.getVida(),
                pokemon.getVidaMax(),
                pokemon.getAtaque(),
                pokemon.getDefensa(),
                pokemon.getVelocidad());
    }
}
