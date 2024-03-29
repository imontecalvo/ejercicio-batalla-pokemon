package org.algo3;
import org.algo3.items.Item;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class InteraccionUsuario {

    public static String solicitarJugador(int numero) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("=> Ingrese el nombre del jugador %d: ", numero);
        String nombre = scanner.next();
        return nombre;
    }

    /*
    * Recibe una lista de pokemones. Solicita al usuario un pokemon.
    * Devuelve el pokemon elegido en caso de elegir un pokemon.
    * Devuelve null en caso de cancelar la accion.
    * */
    public static Pokemon solicitarPokemon(List<Pokemon> pokemones){
        String[] opcionesPokemon = pokemones.stream().map(Pokemon::getNombre).toArray(String[]::new);
        int indicePokemon = solicitarOpcion(opcionesPokemon,"pokemon", true)-1;
        if (cancelarSeleccion(indicePokemon, pokemones.size())) return null;
        return pokemones.get(indicePokemon);
    }

    public static Pokemon solicitarPokemonActivo(List<Pokemon> pokemones, String usuario) {
        System.out.printf("\n\n%s, tu pokemon activo fue derrotado. Debés seleccionar otro.\n", usuario);
        String[] opcionesPokemon = pokemones.stream().map(Pokemon::getNombre).toArray(String[]::new);
        int indicePokemon = solicitarOpcion(opcionesPokemon,"pokemon")-1;
        if (cancelarSeleccion(indicePokemon, pokemones.size())) return null;
        return pokemones.get(indicePokemon);
    }

    /*
     * Recibe un mapa de items. Solicita al usuario un item.
     * Devuelve el item elegido en caso de elegir un item.
     * Devuelve null en caso de cancelar la accion.
     * */
    public static Item solicitarItem(Map<Item, Integer> mapaItems) {
        String[] opcionesItems = new String[mapaItems.size()];
        Item[] listaItems = mapaItems.keySet().toArray(Item[]::new);

        for (int i=0; i<listaItems.length; i++){
            Item item = listaItems[i];
            opcionesItems[i]=String.format("%s x%d",item.getNombre(), mapaItems.get(item));
        }

        int indiceItem = solicitarOpcion(opcionesItems, "item", true)-1;
        if (cancelarSeleccion(indiceItem, listaItems.length)) return null;
        return listaItems[indiceItem];
    }

    /*
    * Recibe el numero de la opcion elegida y la cantidad de opciones disponibles
    * Si el numero de la opcion elegida coincide con la cantidad de opciones, entonces
    * se eligió la última opcion que es cancelar, por lo que se devuelve True
    * De lo contrario, devuelve False.
    * */
    private static boolean cancelarSeleccion(int opcion, int cantidadOpciones){
        return opcion == cantidadOpciones;
    }

    public static int solicitarOpcion(String[] opciones, String keyword) {
        return solicitarOpcion(opciones, keyword, false);
    }

    public static int solicitarOpcion(String[] opciones, String keyword, boolean cancelarSeleccion) {
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

    private static void listarOpciones(String[] opciones, boolean cancelarSeleccion){
        int i = 1;
        if (opciones.length == 0){
            System.out.println("\tNo hay opciones disponibles!");
        }
        for (String o : opciones){
            System.out.printf("\t%d. %s\n", i, o);
            i++;
        }
        if (cancelarSeleccion){
            System.out.printf("\n\t%d. Volver atrás\n",i);
        }
    }

    private static boolean esValido(int input, int cantOpciones){
        return (input >= 1) && (input <= cantOpciones);
    }



}