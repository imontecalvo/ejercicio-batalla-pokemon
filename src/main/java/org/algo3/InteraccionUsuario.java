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
        boolean inputValido = false;
        int inputAccion = 0;

        while (!inputValido){
            if (scanner.hasNextInt()){
                inputAccion = scanner.nextInt();
                int cantidadOpciones = opciones.length + (cancelarSeleccion ? 1 : 0);
                inputValido = esValido(inputAccion, cantidadOpciones);
            }else{
                scanner.next();
            }

            if (!inputValido){
                System.out.println("\nERROR: Input inválido, por favor seleccione de nuevo.");
                System.out.print("--> Selección: ");
            }
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
        return (input >= 1) && (input <= cantOpciones);
    }
}


/*
* TODO:
*  3. Si no hay items en UsarItem o no hay pokemon en CambiarPokemon (array vacio) mostrar msj
* */