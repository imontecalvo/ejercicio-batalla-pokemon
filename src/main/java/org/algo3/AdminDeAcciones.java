package org.algo3;

//import org.algo3.acciones.*;
import org.algo3.acciones.*;
import org.algo3.items.*;
import org.algo3.vista.Vista;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AdminDeAcciones {
    private Batalla batalla;
    private int indiceJugador;
    private Jugador ejecutor;
    private boolean ataqueRealizado;
    private List<AccionFactory> acciones;
    private Vista vista;

    public AdminDeAcciones(Batalla batalla, int indiceJugador, Vista vista) {
        this.batalla = batalla;
        this.indiceJugador = indiceJugador;
        this.ejecutor = batalla.getJugador(indiceJugador);
        this.ataqueRealizado = false;
        this.vista = vista;

        acciones = new ArrayList<>();
        acciones.add(new AccionFactoryRendicion());
        acciones.add(new AccionFactoryAtaque());
        acciones.add(new AccionFactoryCambioDePokemon());
        acciones.add(new AccionFactoryUsoDeItem());
    }

    public void manejarAcciones() {
        chequearPokemonActivo();
        while (!this.ataqueRealizado && !this.batalla.estaTerminada()){
            vista.mostrar(ejecutor);
            Accion accion = solicitarAccion();
            if (accion==null) continue;
            accion.ejecutar();
        }
    }

    private void chequearPokemonActivo(){
/*        if (!ejecutor.pokemonActivoVivo()){
            vista.solicitarPokemon();
        }*/
    }

    private Accion solicitarAccion(){
        String[] opciones = {"Rendirse","Cambiar pokemon","Usar item","Atacar"};
        int inputAccion = InteraccionUsuario.solicitarOpcion(opciones, "accion");
        return acciones.get(inputAccion).crear(batalla, ejecutor);
    }
}
