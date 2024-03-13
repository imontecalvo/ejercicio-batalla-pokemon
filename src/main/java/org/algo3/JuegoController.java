package org.algo3;

import java.util.ArrayList;

public class JuegoController {
    private Batalla batalla;
    private int turno;

    public JuegoController(Batalla batalla) {
        this.batalla = batalla;
        this.turno = primerTurno(batalla);
    }

    private  static int primerTurno(Batalla batalla){
        int indiceJugador = 0;
        float maxVelocidadTotal = 0;
        for (int i = 0; i < Batalla.CANTIDAD_JUGADORES; i++){
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
        jugadorActual.seleccionarPokemon(); //TODO: Mostrar lista, abstraer en vista y validar (rangos y no elegir poke muertos)

        AdminDeAcciones adminDeAcciones = new AdminDeAcciones(this.batalla, this.turno);
        adminDeAcciones.manejarAcciones();

        this.batalla.actualizarEstado();
        this.cambiarTurno();
    }

    private void cambiarTurno(){
        this.turno = (this.turno+1)%Batalla.CANTIDAD_JUGADORES;
    }
}
