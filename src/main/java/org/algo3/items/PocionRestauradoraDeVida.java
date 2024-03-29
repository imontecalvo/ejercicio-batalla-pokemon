package org.algo3.items;

import org.algo3.Pokemon;

public class PocionRestauradoraDeVida extends Item {
    private final TipoPocion tipo;
    private final static String NOMBRE = "Pocion Restauradora";

    public PocionRestauradoraDeVida(TipoPocion tipo) {
        super(String.format("%s %s (+%.2f)", NOMBRE, tipo.name(), tipo.getCapacidad()));
        this.tipo = tipo;
    }

    @Override
    public void usar(Pokemon pokemon) {
        pokemon.restaurarVida(tipo.getCapacidad());
    }
}
