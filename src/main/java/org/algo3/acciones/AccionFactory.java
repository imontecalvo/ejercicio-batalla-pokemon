package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;

public abstract class AccionFactory {
    public abstract Accion crear(Batalla batalla, Jugador ejecutor);
}
