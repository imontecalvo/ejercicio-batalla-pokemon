package org.algo3;
import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    public String nombre;
    public ArrayList<Pokemon> pokemones;
    private int indicePokemonActual;
    //List<Item> items;


    public Jugador(String nombre, ArrayList<Pokemon> pokemones, int indicePokemonActual) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.indicePokemonActual = indicePokemonActual;
    }

    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }

    public int maxVelocidad(){
        int max = 0;
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
}
