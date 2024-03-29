package org.algo3;

import org.algo3.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Jugador {
    public String nombre;
    public List<Pokemon> pokemones;
    private int indicePokemonActual;
    private final Map<Item, Integer> items;


    public Jugador(String nombre, List<Pokemon> pokemones, Map<Item, Integer> items) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.indicePokemonActual = 0;
    }

    public float maxVelocidad() {
        float max = 0;
        for (Pokemon pokemon : this.pokemones) {
            max = Math.max(max, pokemon.getVelocidad());
        }
        return max;
    }

    public boolean tienePokemonesVivos() {
        return pokemones.stream().anyMatch(p -> p.getVida() > 0);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemonesVivos() {
        return pokemones.stream().filter(Pokemon::estaVivo).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Pokemon> getPokemonesMuertos() {
        return pokemones.stream().filter(p -> !p.estaVivo()).toList();
    }


    public List<Pokemon> getPokemonesSeleccionables() {
        return pokemones.stream().filter(p -> p.estaVivo() && p != pokemones.get(indicePokemonActual)).toList();
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public Pokemon getPokemonActual() {
        return pokemones.get(indicePokemonActual);
    }

    public float getAtaqueTotal() {
        return getPokemonActual().getAtaque();
    }

    public void recibirAtaque(float ataque) {
        getPokemonActual().reducirVida(ataque);
    }

    public void setPokemonActual(Pokemon reemplazo) {
        indicePokemonActual = pokemones.indexOf(reemplazo);
    }

    public void gastarItem(Item item) {
        items.put(item, items.get(item) - 1);
        if (items.get(item) == 0) {
            items.remove(item);
        }
    }

    public boolean pokemonActivoVivo() {
        return pokemones.get(indicePokemonActual).estaVivo();
    }

    public List<Pokemon> getPokemonesRestantes() {
        Pokemon pokemonActual = pokemones.get(indicePokemonActual);
        return pokemones.stream().filter(p -> p != pokemonActual).toList();
    }
}
