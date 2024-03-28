package org.algo3;

import org.algo3.items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConjuntoItems {
    private final Random generador;
    private final List<Item> itemsExistentes;

    public ConjuntoItems() {
        this.generador = new Random();
        this.itemsExistentes = new ArrayList<>();

        itemsExistentes.add(new BoostAtaque(3));
        itemsExistentes.add(new BoostDefensa(5));
        itemsExistentes.add(new PocionRestauradora(2));
        itemsExistentes.add(new MegaPocionRestauradora(2));
        itemsExistentes.add(new Resurreccion(5));

    }
}
