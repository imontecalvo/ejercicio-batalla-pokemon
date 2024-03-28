package org.algo3;

import org.algo3.items.*;

import java.util.*;

public class ConjuntoItems {
    private final Random generador;
    private final List<Item> itemsExistentes;

    public ConjuntoItems() {
        this.generador = new Random();
        this.itemsExistentes = new ArrayList<>();

        itemsExistentes.add(new BoostAtaque());
        itemsExistentes.add(new BoostDefensa());
        itemsExistentes.add(new Resurreccion());

        itemsExistentes.add(new PocionRestauradoraDeVida(TipoPocion.NORMAL));
        itemsExistentes.add(new PocionRestauradoraDeVida(TipoPocion.MEGA));
        itemsExistentes.add(new PocionRestauradoraDeVida(TipoPocion.HIPER));
    }

    public HashMap<Item, Integer> obtenerRandom(int cantidad) {
        HashMap<Item, Integer> seleccion = new HashMap<>();
        for (int i=0; i<cantidad; i++){
            int idx = generador.nextInt(0, itemsExistentes.size());
            Item item = itemsExistentes.get(idx);
            seleccion.put(item, seleccion.getOrDefault(item,0)+1);
        }

        return seleccion;
    }
}
