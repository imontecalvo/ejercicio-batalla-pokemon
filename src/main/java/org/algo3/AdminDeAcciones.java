package org.algo3;

import org.algo3.Batalla;
import org.algo3.acciones.Accion;
import org.algo3.acciones.Rendicion;

import javax.swing.*;
import java.util.Scanner;

public class AdminDeAcciones {
    private Batalla batalla;
    private int indiceJugador;
    private boolean ataqueRealizado;

    public AdminDeAcciones(Batalla batalla, int indiceJugador) {
        this.batalla = batalla;
        this.indiceJugador = indiceJugador;
        this.ataqueRealizado = false;
    }

    public void manejarAcciones(){
        while (!this.ataqueRealizado && !this.batalla.estaTerminada()){
            Accion accion = solicitarAccion();
            accion.ejecutar();
        }
    }

    private Accion solicitarAccion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccionar accion:\n\t1. Rendirse\n\t2. Cambiar pokemon\n\t3. Usar item\n\t4. Atacar");
        System.out.print("Relaizar accion: ");
        int inputAccion = scanner.nextInt();
        //int inputAccion = 1;

        switch (inputAccion){
            case 1:
                return new Rendicion(this.batalla, this.indiceJugador);
            default:
                return null;
        }
    }

}
