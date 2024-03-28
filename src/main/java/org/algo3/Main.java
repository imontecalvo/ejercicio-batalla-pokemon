package org.algo3;

import java.util.*;
import org.algo3.items.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConjuntoPokemones conjuntoPokemones = new ConjuntoPokemones();
        ConjuntoItems conjuntoItems = new ConjuntoItems();
        


        //Juego juego = new JuegoController(conjuntoPokemones);
        //juego.iniciar();
/*        ArrayList<Pokemon> l1 = pokemonList(1);
        ArrayList<Pokemon> l2 = pokemonList(2);

        ArrayList<Item> i1 = itemList(1);
        ArrayList<Item> i2 = itemList(2);

        Jugador p1 = new Jugador("Jugador 1", l1, 0, i1);
        Jugador p2 = new Jugador("Jugador 2", l2, 0, i2);
        Jugador[] jugadores = {p1,p2};

        Batalla batalla = new Batalla(jugadores);

        JuegoController juego = new JuegoController(batalla);

        do{
            juego.jugarTurno();
            System.out.println();
        }while (!batalla.estaTerminada());

        System.out.printf("Batalla terminada. Ganador: %s\n", batalla.getGanador());*/
    }

/*    private static ArrayList<Pokemon> pokemonList(int n){
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

    private static ArrayList<Item> itemList(int n){
        if (n==1){
            Item i1 = new BoostAtaque(3);
            Item i2 = new BoostDefensa(5);
            Item i3 = new PocionRestauradora(2);
            Item i4 = new MegaPocionRestauradora(2);
            Item i5 = new Resurreccion(5);
            return new ArrayList<>(List.of(i1, i2, i3, i4, i5));
        }else{
            Item i1 = new BoostAtaque(1);
            Item i2 = new HiperPocionRestauradora(2);
            return new ArrayList<>(List.of(i1, i2));
        }
    }*/
}