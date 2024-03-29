package org.algo3.vista;

import org.algo3.Jugador;
import org.algo3.Pokemon;

import java.util.List;

public abstract class VistaJugador {

    public static void mostrar(Jugador jugador) {
        System.out.printf(">> Jugador: %s <<\n\n", jugador.getNombre());
        System.out.println(">> Pokemon Actual <<");
        VistaPokemon.mostrarEnDetalle(jugador.getPokemonActual());
        System.out.println("\n>> Pokemones restantes <<");
        List<Pokemon> pokemonesRestantes = jugador.getPokemonesRestantes();
        for (Pokemon pokemon : pokemonesRestantes) {
            VistaPokemon.mostrar(pokemon);
        }
    }
}
