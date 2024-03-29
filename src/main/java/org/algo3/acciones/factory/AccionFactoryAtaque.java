package org.algo3.acciones.factory;

import org.algo3.Batalla;
import org.algo3.Jugador;
import org.algo3.acciones.Accion;
import org.algo3.acciones.Ataque;

public class AccionFactoryAtaque extends AccionFactory {
    @Override
    public Accion crear(Batalla batalla, Jugador ejecutor) {
        return new Ataque(batalla, ejecutor);
    }
}
