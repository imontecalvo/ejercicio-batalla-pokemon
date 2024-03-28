package org.algo3;

import java.util.Objects;

public class Pokemon implements Cloneable{
    private final static float BOOST_ATAQUE = 0.1f;
    private final static float BOOST_DEFENSA = 0.1f;
    public String nombre;
    private int nivel;
    private Tipo tipo;
    private String historia;
    public float vida;
    private float vidaMax;
    private float velocidad;
    private float defensa;
    private float ataque;

    public Pokemon(String nombre, int nivel, Tipo tipo, String historia, float vidaMax, float velocidad, float defensa, float ataque) {
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
    public Pokemon clone() {
        try {
            return (Pokemon) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return nivel == pokemon.nivel && vidaMax == pokemon.vidaMax && velocidad == pokemon.velocidad && defensa == pokemon.defensa && ataque == pokemon.ataque && Objects.equals(nombre, pokemon.nombre) && tipo == pokemon.tipo && Objects.equals(historia, pokemon.historia);
    }

    public float getVelocidad() {
        return this.velocidad;
    }

    public boolean estaVivo(){
        return this.vida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public float getVida() {
        return vida;
    }

    public float getVidaMax() {
        return vidaMax;
    }

    public float getDefensa() {
        return defensa;
    }

    public float getAtaque() {
        return ataque;
    }

    public void reducirVida(float ataque){
        this.vida = Math.max(0, this.vida - ataque);
    }

    public void matar(){
        this.vida = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void boostAtaque(){
        this.ataque+=this.ataque*BOOST_ATAQUE;
    }

    public void boostDefensa() {
        this.defensa+=this.defensa*BOOST_DEFENSA;
    }

    public void restaurarVida(float capacidad) {
        this.vida = Math.min(this.vida + capacidad, this.vidaMax);
    }

    public void revivir() {
        this.vida = this.vidaMax;
    }
}
