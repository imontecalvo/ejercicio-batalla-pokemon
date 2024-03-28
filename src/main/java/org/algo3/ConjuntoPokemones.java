package org.algo3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ConjuntoPokemones {
    private final Random generador;
    private final List<Pokemon> pokemonesExistentes;

    public ConjuntoPokemones() {
        generador = new Random();
        pokemonesExistentes = new ArrayList<Pokemon>();

        this.pokemonesExistentes.add(new Pokemon("Bulbasaur", 1, Tipo.PLANTA, ",,,", 300, 30, 30, 30));
        this.pokemonesExistentes.add(new Pokemon("Ivysaur", 2, Tipo.PLANTA, ",,,", 400, 40, 50, 40));
        this.pokemonesExistentes.add(new Pokemon("Venusaur", 3, Tipo.PLANTA, ",,,", 500, 50, 80, 60));

        this.pokemonesExistentes.add(new Pokemon("Pikachu", 1, Tipo.ELECTRICO, ",,,", 200, 60, 30, 75));

        this.pokemonesExistentes.add(new Pokemon("Charmander", 1, Tipo.FUEGO, ",,,", 200, 40, 40, 40));
        this.pokemonesExistentes.add(new Pokemon("Charmeleon", 2, Tipo.FUEGO, ",,,", 300, 60, 50, 60));
        this.pokemonesExistentes.add(new Pokemon("Charizard", 3, Tipo.FUEGO, ",,,", 400, 80, 65, 80));

        this.pokemonesExistentes.add(new Pokemon("Squirtle", 1, Tipo.AGUA, ",,,", 250, 30, 50, 40));
        this.pokemonesExistentes.add(new Pokemon("Wartortle", 2, Tipo.AGUA, ",,,", 370, 40, 60, 55));
        this.pokemonesExistentes.add(new Pokemon("Blastoise", 3, Tipo.AGUA, ",,,", 460, 60, 70, 70));

        this.pokemonesExistentes.add(new Pokemon("Pidgey", 1, Tipo.NORMAL, ",,,", 210, 45, 40, 40));
        this.pokemonesExistentes.add(new Pokemon("Pidgeotto", 2, Tipo.NORMAL, ",,,", 320, 70, 60, 60));
        this.pokemonesExistentes.add(new Pokemon("Pidgeot", 3, Tipo.NORMAL, ",,,", 430, 40, 75, 80));

        this.pokemonesExistentes.add(new Pokemon("Caterpie", 1, Tipo.BICHO, ",,,", 150, 40, 30, 40));
        this.pokemonesExistentes.add(new Pokemon("Metapod", 2, Tipo.BICHO, ",,,", 250, 65, 40, 60));
        this.pokemonesExistentes.add(new Pokemon("Butterfree", 3, Tipo.BICHO, ",,,", 350, 80, 50, 70));

        this.pokemonesExistentes.add(new Pokemon("Nidoran", 1, Tipo.BICHO, ",,,", 200, 50, 40, 50));
        this.pokemonesExistentes.add(new Pokemon("Nidorino", 2, Tipo.BICHO, ",,,", 340, 60, 55, 65));
        this.pokemonesExistentes.add(new Pokemon("Nidoking", 3, Tipo.BICHO, ",,,", 450, 70, 70, 85));
    }

    public List<Pokemon> obtenerRandom(int cantidad) {
        if (cantidad > pokemonesExistentes.size()){
            throw new RuntimeException("Error: No hay suficientes pokemones");
        }

        HashSet<Pokemon> seleccion = new HashSet<>();
        while (seleccion.size() < cantidad){
            int idx = generador.nextInt(0,pokemonesExistentes.size());
            seleccion.add(pokemonesExistentes.get(idx).clone());
        }

        return new ArrayList<>(seleccion);
    }
}
