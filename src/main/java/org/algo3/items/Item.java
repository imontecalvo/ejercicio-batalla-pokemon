package org.algo3.items;

import org.algo3.Pokemon;

public abstract class Item {
    private String nombre;
    protected int cantidad;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void usar(Pokemon pokemon){
        this.cantidad--;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
}
