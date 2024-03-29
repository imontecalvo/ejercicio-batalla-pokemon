package org.algo3;
import org.algo3.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jugador {
    public String nombre;
    public List<Pokemon> pokemones;
    private int indicePokemonActual;
    private Map<Item,Integer> items;


    public Jugador(String nombre, List<Pokemon> pokemones, Map<Item, Integer> items) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.items = items;
        this.indicePokemonActual = 0;
    }

    public void mostrar(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Poke actual: "+indicePokemonActual);
        System.out.println("Pokemones:");
        for (Pokemon p : pokemones){
            System.out.printf("\t- %s ; %.2f ; %.2f/%.2f\n", p.getNombre(), p.getVelocidad(), p.getVida(), p.getVidaMax());
        }

        System.out.println("\nItems:");
        for ( Map.Entry<Item, Integer> entry: items.entrySet()){
            System.out.printf("\t- %s : %d\n", entry.getKey().getNombre(), entry.getValue() );
        }
    }

    public float maxVelocidad(){
        float max = 0;
        for (Pokemon pokemon : this.pokemones){
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
        return pokemones.stream().filter(Pokemon::estaVivo).toList();
    }

    public List<Pokemon> getPokemonesMuertos() {
        return pokemones.stream().filter(p -> !p.estaVivo()).toList();
    }


    public List<Pokemon> getPokemonesSeleccionables(){
        List<Pokemon> seleccionables = this.getPokemonesVivos();
        Pokemon pokemonActual = pokemones.get(indicePokemonActual);
        seleccionables.remove(pokemonActual);
        return seleccionables;
    }

    public Map<Item,Integer> getItems() {
        return items;
    }

    public Pokemon getPokemonActual() {
        return pokemones.get(indicePokemonActual);
    }



  /*  public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }



    //TODO: Agregar validacion y extraer interaccion con usuario
    public void seleccionarPokemon(){
        Pokemon pokemonActual = pokemones.get(indicePokemonActual);
        if (!pokemonActual.estaVivo()){
            ArrayList<Pokemon> seleccionables = getPokemonesSeleccionables();
            int i = 1;
            System.out.println("Elegí un nuevo pokemon: ");
            for(Pokemon pokemon : seleccionables){
                System.out.printf("%d. %s\n", i, pokemon.getNombre());
                i++;
            }
            System.out.print("Seleccionar pokemon: ");
            Scanner scanner = new Scanner(System.in);
            this.indicePokemonActual = this.pokemones.indexOf(seleccionables.get(scanner.nextInt()-1));
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

    *//*
     * Devuelve todos los pokemones vivos.
     *//*
    public ArrayList<Pokemon> getPokemonesVivos() {
        ArrayList<Pokemon> vivos = new ArrayList<>();
        for (Pokemon pokemon : this.pokemones){
            if (pokemon.estaVivo()){vivos.add(pokemon);}
        }
        return vivos;
    }

    *//*
    * Devuelve los posibles pokemones por los que se puede intercambiar el actual.
    * Esto es, aquellos que estan vivos y son distintos del actual.
    *//*
    public ArrayList<Pokemon> getPokemonesSeleccionables(){
        ArrayList<Pokemon> seleccionables = this.getPokemonesVivos();
        Pokemon pokemonActual = pokemones.get(indicePokemonActual);
        seleccionables.remove(pokemonActual);
        return seleccionables;
    }

    *//*
     * Devuelve todos los pokemones menos el actual.
     *//*
    public ArrayList<Pokemon> getPokemonesRestantes(){
        ArrayList<Pokemon> restantes = (ArrayList<Pokemon>) this.pokemones.clone();
        Pokemon pokemonActual = pokemones.get(indicePokemonActual);
        restantes.remove(pokemonActual);
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

    public void eliminarItem(Item item) {
        items.remove(item);
    }*/
}
