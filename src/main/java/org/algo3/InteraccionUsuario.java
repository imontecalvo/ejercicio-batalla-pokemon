package org.algo3;

import org.algo3.Batalla;
import org.algo3.acciones.*;
import org.algo3.items.BoostAtaque;
import org.algo3.items.BoostDefensa;
import org.algo3.items.Item;
import org.algo3.items.PocionRestauradoraDeVida;

import java.util.ArrayList;
import java.util.Scanner;

public class InteraccionUsuario {

    public InteraccionUsuario(Batalla batalla) {
    }

    public int solicitarOpcion(String[] opciones, String keyword) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Seleccionar %s:\n", keyword);
        listarOpciones(opciones);
        System.out.print("--> Selección: ");
        int inputAccion = scanner.nextInt();
        while (!esValido(inputAccion, opciones.length)){
            System.out.println("\nERROR: Input inválido, por favor seleccione de nuevo.");
            System.out.print("--> Selección: ");
            inputAccion = scanner.nextInt();
        }

        return inputAccion;
    }

    private void listarOpciones(String[] opciones){
        int i = 1;
        for (String o : opciones){
            System.out.printf("%d. %s\n", i, o);
            i++;
        }
    }

    //TODO: Agregar validaciones
    private boolean esValido(int input, int cantOpciones){
        return true;
    }
}


/*
* TODO:
*  1. No poder usar items cuando cant = 0
*  2. Opcion ir para atras
*  3. Si no hay items en UsarItem o no hay pokemon en CambiarPokemon (array vacio) mostrar msj
*  4. Chequear input indice en rango
* */