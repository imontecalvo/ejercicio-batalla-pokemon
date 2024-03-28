package org.algo3;

import java.util.List;
import java.util.Map;

import org.algo3.vista.Vista;
import org.algo3.items.Item;

public class GeneradorJugador {
    private static final int CANTIDAD_INICIAL_POKEMONES = 6;
    private static final int CANTIDAD_INICIAL_ITEMS = 5;
    private Vista vista;
    private ConjuntoPokemones conjuntoPokemones;
    private ConjuntoItems conjuntoItems;

    public GeneradorJugador(Vista vista, ConjuntoPokemones conjuntoPokemones, ConjuntoItems conjuntoItems) {
        this.vista = vista;
        this.conjuntoPokemones = conjuntoPokemones;
        this.conjuntoItems = conjuntoItems;
    }

    public Jugador generar(int numero){
        String nombre = vista.solicitarJugador(numero);
        List<Pokemon> pokemones = conjuntoPokemones.obtenerRandom(CANTIDAD_INICIAL_POKEMONES);
        Map<Item, Integer> items = conjuntoItems.obtenerRandom(CANTIDAD_INICIAL_ITEMS);
        return new Jugador(nombre, pokemones, items);
    }
}
