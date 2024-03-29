package org.algo3;

//import org.algo3.acciones.*;

import org.algo3.acciones.*;
import org.algo3.acciones.factory.*;
import org.algo3.vista.Vista;

import java.util.ArrayList;
import java.util.List;

public class AdminDeAcciones {
    private final Batalla batalla;
    private final Jugador ejecutor;
    private boolean ataqueRealizado;
    private final List<AccionFactory> acciones;
    private final Vista vista;

    public AdminDeAcciones(Batalla batalla, int indiceJugador, Vista vista) {
        this.batalla = batalla;
        this.ejecutor = batalla.getJugador(indiceJugador);
        this.ataqueRealizado = false;
        this.vista = vista;

        acciones = new ArrayList<>();
        acciones.add(new AccionFactoryRendicion());
        acciones.add(new AccionFactoryCambioDePokemon());
        acciones.add(new AccionFactoryUsoDeItem());
        acciones.add(new AccionFactoryAtaque());
    }

    public void manejarAcciones() {
        chequearPokemonActivo();
        while (!this.ataqueRealizado && !this.batalla.estaTerminada()) {
            vista.mostrar(ejecutor, batalla.getJugadores());
            Accion accion = solicitarAccion();
            if (accion == null) continue;
            ataqueRealizado = accion.esAtaque();
            accion.ejecutar();
        }
    }

    private void chequearPokemonActivo() {
        if (!ejecutor.pokemonActivoVivo()) {
            Pokemon seleccionado = InteraccionUsuario.solicitarPokemonActivo(ejecutor.getPokemonesVivos(), ejecutor.getNombre());
            ejecutor.setPokemonActual(seleccionado);
        }
    }

    private Accion solicitarAccion() {
        String[] opciones = {"Rendirse", "Cambiar pokemon", "Usar item", "Atacar"};
        int inputAccion = InteraccionUsuario.solicitarOpcion(opciones, "accion") - 1;
        System.out.println("Se eligio " + inputAccion);
        return acciones.get(inputAccion).crear(batalla, ejecutor);
    }
}
