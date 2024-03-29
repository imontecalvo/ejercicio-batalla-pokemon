package org.algo3.acciones.factory;

import org.algo3.Batalla;
import org.algo3.Jugador;
import org.algo3.acciones.Accion;

public abstract class AccionFactory {
    public abstract Accion crear(Batalla batalla, Jugador ejecutor);
}
