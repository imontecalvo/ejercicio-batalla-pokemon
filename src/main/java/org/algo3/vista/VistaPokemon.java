package org.algo3.vista;

import org.algo3.Pokemon;

public abstract class VistaPokemon {

    public static void mostrar(Pokemon pokemon){
        System.out.printf("%s - Vida: %.2f / %.2f\n", pokemon.getNombre(), pokemon.getVida(), pokemon.getVidaMax());
    }

    public static void mostrarEnDetalle(Pokemon pokemon){
        System.out.printf("%s\n\tVida: %.2f / %.2f\n\tAtaque: %.2f\n\tDefensa: %.2f\n\tVelocidad: %.2f\n",
                pokemon.getNombre(),
                pokemon.getVida(),
                pokemon.getVidaMax(),
                pokemon.getAtaque(),
                pokemon.getDefensa(),
                pokemon.getVelocidad());
    }
}
