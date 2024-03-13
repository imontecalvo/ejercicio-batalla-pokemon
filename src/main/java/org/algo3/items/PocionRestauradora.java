package org.algo3.items;

public class PocionRestauradora extends PocionRestauradoraDeVida{
    private static final float CAPACIDAD = 30f;
    private static final String NOMBRE = String.format("Pocion restauradora (+%.2f)", CAPACIDAD);
    public PocionRestauradora(int cantidad) {
        super(NOMBRE, CAPACIDAD, cantidad);
    }
}
