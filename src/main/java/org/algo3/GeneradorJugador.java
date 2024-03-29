package org.algo3;

import java.util.List;
import java.util.Map;

import org.algo3.items.Item;

public class GeneradorJugador {
    private static final int CANTIDAD_INICIAL_POKEMONES = 6;
    private static final int CANTIDAD_INICIAL_ITEMS = 5;
    private final ConjuntoPokemones conjuntoPokemones;
    private final ConjuntoItems conjuntoItems;

    public GeneradorJugador(ConjuntoPokemones conjuntoPokemones, ConjuntoItems conjuntoItems) {
        this.conjuntoPokemones = conjuntoPokemones;
        this.conjuntoItems = conjuntoItems;
    }

    public Jugador generar(int numero) {
        String nombre = InteraccionUsuario.solicitarJugador(numero);
        List<Pokemon> pokemones = conjuntoPokemones.obtenerRandom(CANTIDAD_INICIAL_POKEMONES);
        Map<Item, Integer> items = conjuntoItems.obtenerRandom(CANTIDAD_INICIAL_ITEMS);
        return new Jugador(nombre, pokemones, items);
    }
}
