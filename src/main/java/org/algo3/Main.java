package org.algo3;

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Pokemon> l1 = pokemonList(1);
        ArrayList<Pokemon> l2 = pokemonList(2);

        Jugador p1 = new Jugador("Jugador 1", l1, 0);
        Jugador p2 = new Jugador("Jugador 2", l2, 0);
        Jugador[] jugadores = {p1,p2};

        Batalla batalla = new Batalla(jugadores);

        JuegoController juego = new JuegoController(batalla);

        int contador = 0;

        do{
            //if (contador == 3) l2.get(0).matar();
            //if (contador == 5) l2.get(1).matar();
            //if (contador == 7) l2.get(2).matar();
            juego.jugarTurno();
            //if (contador >= 10) batalla.setGanador(p1);
            //contador++;
            System.out.println();
        }while (!batalla.estaTerminada());

        System.out.printf("Batalla terminada. Ganador: %s\n", batalla.getGanador());
        p1.info();

    }

    private static ArrayList<Pokemon> pokemonList(int n){
        if (n==1){
            Pokemon p1 = new Pokemon("Pikachu", 1, Tipo.ELECTRICO, ",,,", 100, 200, 30, 75);
            Pokemon p2 = new Pokemon("Charmander", 2, Tipo.FUEGO, ",,,", 200, 100, 100, 80);
            Pokemon p3 = new Pokemon("Bulbasour", 1, Tipo.TIERRA, ",,,", 300, 50, 300, 30);
            return new ArrayList<>(List.of(p1,p2,p3));
        }else{
            Pokemon p1 = new Pokemon("Squirtle", 1, Tipo.AGUA, ",,,", 120, 199, 40, 65);
            Pokemon p2 = new Pokemon("Duki", 3, Tipo.FANTASMA, ",,,", 150, 70, 120, 90);
            Pokemon p3 = new Pokemon("CR7", 7, Tipo.BICHO, ",,,", 200, 120, 90, 150);
            return new ArrayList<>(List.of(p1,p2,p3));
        }
    }
}