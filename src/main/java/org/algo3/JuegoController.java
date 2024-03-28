package org.algo3;

import org.algo3.vista.Vista;

import java.util.ArrayList;

public class JuegoController {
    private Batalla batalla;
    private int turno;
    private Vista vista;

    public JuegoController(ConjuntoPokemones conjuntoPokemones) {
        this.batalla = new Batalla(conjuntoPokemones);
        this.turno = primerTurno(batalla);
        this.vista = new Vista(batalla);
    }

    private  static int primerTurno(Batalla batalla){
        int indiceJugador = 0;
        float maxVelocidadTotal = 0;
        for (int i = 0; i < Batalla.CANTIDAD_JUGADORES; i++){
            //TODO: PoLK violado. Pedir a batalla jugador con max velocidad
            float velocidadActual = batalla.getJugador(i).maxVelocidad();
            if (velocidadActual > maxVelocidadTotal){
                maxVelocidadTotal = velocidadActual;
                indiceJugador = i;
            }
        }

        return indiceJugador;
    }

    public void jugarTurno(){
        Jugador jugadorActual = batalla.getJugador(this.turno);
        //TODO: PoLK violado
        jugadorActual.seleccionarPokemon();

        //TODO: No cumple Dependencias explicitas
        AdminDeAcciones adminDeAcciones = new AdminDeAcciones(this.batalla, this.turno, this.vista);
        adminDeAcciones.manejarAcciones();

        this.batalla.actualizarEstado();
        this.cambiarTurno();
    }

    private void cambiarTurno(){
        this.turno = (this.turno+1)%Batalla.CANTIDAD_JUGADORES;
    }
}
