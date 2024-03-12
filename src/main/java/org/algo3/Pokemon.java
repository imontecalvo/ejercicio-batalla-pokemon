package org.algo3;

import java.util.Objects;

public class Pokemon {
    public String nombre;
    private int nivel;
    private Tipo tipo;
    private String historia;
    public int vida;
    private int vidaMax;
    private int velocidad;
    private int defensa;
    private int ataque;

    public Pokemon(String nombre, int nivel, Tipo tipo, String historia, int vidaMax, int velocidad, int defensa, int ataque) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.historia = historia;
        this.vida = vidaMax;
        this.vidaMax = vidaMax;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return nivel == pokemon.nivel && vidaMax == pokemon.vidaMax && velocidad == pokemon.velocidad && defensa == pokemon.defensa && ataque == pokemon.ataque && Objects.equals(nombre, pokemon.nombre) && tipo == pokemon.tipo && Objects.equals(historia, pokemon.historia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nivel, tipo, historia, vidaMax, velocidad, defensa, ataque);
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public boolean estaVivo(){
        return this.vida > 0;
    }

    public void matar(){
        this.vida = 0;
    }
}
