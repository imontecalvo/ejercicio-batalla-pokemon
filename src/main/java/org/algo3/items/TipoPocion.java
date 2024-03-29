package org.algo3.items;

public enum TipoPocion {
    NORMAL(30f),
    MEGA(50f),
    HIPER(100f);

    private final float capacidad;

    TipoPocion(float capacidad) {
        this.capacidad = capacidad;
    }

    public float getCapacidad() {
        return this.capacidad;
    }
}
