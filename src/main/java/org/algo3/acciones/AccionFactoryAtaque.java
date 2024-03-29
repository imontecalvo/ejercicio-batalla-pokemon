package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;

public class AccionFactoryAtaque extends AccionFactory{
    @Override
    public Accion crear(Batalla batalla, Jugador ejecutor) {
        return new Ataque(batalla, ejecutor);
    }
}
