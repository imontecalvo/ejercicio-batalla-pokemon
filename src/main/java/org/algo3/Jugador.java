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

    /*
     * Devuelve todos los pokemones vivos.
     */
    public ArrayList<Pokemon> getPokemonesVivos() {
        ArrayList<Pokemon> vivos = new ArrayList<>();
        for (Pokemon pokemon : this.pokemones){
            if (pokemon.estaVivo()){vivos.add(pokemon);}
        }
        return vivos;
    }

    /*
    * Devuelve los posibles pokemones por los que se puede intercambiar el actual.
    * Esto es, aquellos que estan vivos y son distintos del actual.
    */
    public ArrayList<Pokemon> getPokemonesSeleccionables(){
        ArrayList<Pokemon> seleccionables = this.getPokemonesVivos();
        seleccionables.remove(indicePokemonActual);
        return seleccionables;
    }

    /*
     * Devuelve todos los pokemones menos el actual.
     */
    public ArrayList<Pokemon> getPokemonesRestantes(){
        ArrayList<Pokemon> restantes = (ArrayList<Pokemon>) this.pokemones.clone();
        restantes.remove(this.indicePokemonActual);
        return restantes;
    }

    public void setPokemonActual(Pokemon pokemon){
        this.indicePokemonActual = this.pokemones.indexOf(pokemon);
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public ArrayList<Pokemon> getPokemonesMuertos() {
        ArrayList<Pokemon> muertos = new ArrayList<>();
        for (Pokemon pokemon : this.pokemones){
            if (!pokemon.estaVivo()){muertos.add(pokemon);}
        }
        return muertos;
    }
}
