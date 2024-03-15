package org.algo3;
import java.util.Scanner;

public class InteraccionUsuario {

    public InteraccionUsuario(Batalla batalla) {
    }

    public int solicitarOpcion(String[] opciones, String keyword) {
        return solicitarOpcion(opciones, keyword, false);
    }

    public int solicitarOpcion(String[] opciones, String keyword, boolean cancelarSeleccion) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\nSeleccionar %s:\n", keyword);
        listarOpciones(opciones, cancelarSeleccion);
        System.out.print("--> Selección: ");
        int inputAccion = scanner.nextInt();

        while (!esValido(inputAccion, opciones.length)){
            System.out.println("\nERROR: Input inválido, por favor seleccione de nuevo.");
            System.out.print("--> Selección: ");
            inputAccion = scanner.nextInt();
        }

        return inputAccion;
    }

    private void listarOpciones(String[] opciones, boolean cancelarSeleccion){
        int i = 1;
        for (String o : opciones){
            System.out.printf("\t%d. %s\n", i, o);
            i++;
        }
        if (cancelarSeleccion){
            System.out.printf("\n\t%d. Volver atrás\n",i);
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
*  4. Chequear input indice en rango y que sea entero
* */