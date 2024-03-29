package org.algo3;

import java.util.*;
import org.algo3.items.*;
import org.algo3.vista.Vista;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JuegoController juego = getJuegoController();
        juego.iniciar();
    }

    private static JuegoController getJuegoController() {
        Vista vista = new Vista();
        vista.iniciar();
        ConjuntoPokemones conjuntoPokemones = new ConjuntoPokemones();
        ConjuntoItems conjuntoItems = new ConjuntoItems();
        GeneradorJugador generadorJugador = new GeneradorJugador(conjuntoPokemones, conjuntoItems);
        Jugador jugador1 = generadorJugador.generar(1);
        Jugador jugador2 = generadorJugador.generar(2);

        //jugador1.mostrar();
        //jugador2.mostrar();

        Batalla batalla = new Batalla(jugador1, jugador2);
        return new JuegoController(batalla, vista);
    }
}