package org.algo3.items;

public class MegaPocionRestauradora extends PocionRestauradoraDeVida{
    private static final float CAPACIDAD = 50f;
    private static final String NOMBRE = String.format("Mega Pocion restauradora (+%.2f)", CAPACIDAD);
    public MegaPocionRestauradora() {
        super(NOMBRE, CAPACIDAD);
    }
}
