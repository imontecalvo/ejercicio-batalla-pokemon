package org.algo3;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConjuntoPokemones conjuntoPokemones = new ConjuntoPokemones();
        ConjuntoItems conjuntoItems = new ConjuntoItems();

        JuegoController juego = new JuegoController(conjuntoPokemones, conjuntoItems);
        juego.iniciar();
    }
}