package org.algo3;

import org.algo3.items.Item;

import java.util.List;

public abstract class generadorDeJugador {
    public static Jugador generar(String nombre, ConjuntoPokemones conjuntoPokemones){
        List<Pokemon> pokemones = conjuntoPokemones.obtenerRandom(6);
//        List<Item> items = ConjuntoItems.obtenerRandom(5);
        return new Jugador(nombre, pokemones, items);
    }
}
