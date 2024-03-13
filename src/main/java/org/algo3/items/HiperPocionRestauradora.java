package org.algo3.items;

public class HiperPocionRestauradora extends PocionRestauradoraDeVida{
    private static final float CAPACIDAD = 100f;
    private static final String NOMBRE = String.format("Hiper Pocion restauradora (%.2f)", CAPACIDAD);
    public HiperPocionRestauradora(int cantidad) {
        super(NOMBRE, CAPACIDAD, cantidad);
    }
}
