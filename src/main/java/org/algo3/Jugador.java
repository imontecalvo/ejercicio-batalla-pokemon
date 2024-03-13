package org.algo3;
import org.algo3.items.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    public String nombre;
    public ArrayList<Pokemon> pokemones;
    private int indicePokemonActual;
    private ArrayList<Item> items;


    public Jugador(String nombre, ArrayList<Pokemon> pokemones, int indicePokemonActual, ArrayList<Item> items) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.indicePokemonActual = indicePokemonActual;
        this.items = items;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }

    public float maxVelocidad(){
        float max = 0;
        for (Pokemon pokemon : this.pokemones){
            max = Math.max(max, pokemon.getVelocidad());
        }
        return max;
    }

    //TODO: Agregar validacion y extraer interaccion con usuario
    public void seleccionarPokemon(){
        Pokemon pokemonActual = pokemones.get(indicePokemonActual);
        if (!pokemonActual.estaVivo()){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Elegí un nuevo pokemon: ");
            this.indicePokemonActual = scanner.nextInt();
        }
    }

    public boolean tienePokemonesVivos(){
        for (Pokemon pokemon : pokemones){
            if (pokemon.estaVivo()){
                return true;
            }
        }
        return false;
    }

    public void info(){
        for (Pokemon p: pokemones){
            System.out.printf("Nombre: %s , Vida: %d\n", p.nombre, p.vida);
        }
    }


    public Pokemon getPokemonActual(){
        return this.pokemones.get(this.indicePokemonActual);
    }

    public ArrayList<Pokemon> getPokemonesSeleccionables(){
        ArrayList<Pokemon> seleccionables = new ArrayList<>();
        for (Pokemon pokemon : this.pokemones){
            if (pokemon.estaVivo() && pokemon != this.pokemones.get(this.indicePokemonActual)){
                seleccionables.add(pokemon);
            }
        }

        return seleccionables;
    }

    public ArrayList<Pokemon> getPokemonesRestantes(){
        ArrayList<Pokemon> restantes = new ArrayList<>();
        for (Pokemon pokemon : this.pokemones){
            if (pokemon != this.pokemones.get(this.indicePokemonActual)){
                restantes.add(pokemon);
            }
        }

        return restantes;
    }

    public void setPokemonActual(Pokemon pokemon){
        this.indicePokemonActual = this.pokemones.indexOf(pokemon);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
