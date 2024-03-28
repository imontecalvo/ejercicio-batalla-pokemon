package org.algo3;

import org.algo3.vista.Vista;

public class JuegoController {
    private  Batalla batalla;
    private int turnoActual;
    private Vista vista;

    //admindeacciones

    public JuegoController(ConjuntoPokemones conjuntoPokemones, ConjuntoItems conjuntoItems, Vista vista) {
        this.vista = vista;
        vista.iniciar();
        GeneradorJugador generadorJugador = new GeneradorJugador(vista, conjuntoPokemones, conjuntoItems);
        Jugador jugador1 = generadorJugador.generar(1);
        Jugador jugador2 = generadorJugador.generar(2);

        //jugador1.mostrar();
        //jugador2.mostrar();

        this.batalla = new Batalla(jugador1, jugador2);
        this.turnoActual = batalla.jugadorConMaxVelocidad();
    }

    public void iniciar() {

        while (!batalla.estaTerminada()) {
            //admindeacciones.manejarturno()
            batalla.actualizarEstado();
            cambiarTurno();
        }
        System.out.println("Ganador: "+batalla.getGanador());
    }

    private void cambiarTurno() {
        turnoActual=(turnoActual+1)% Batalla.CANTIDAD_JUGADORES;
    }
/*
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
    }*/
}
