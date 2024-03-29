package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.Jugador;

public class AccionFactoryRendicion extends AccionFactory{
    @Override
    public Accion crear(Batalla batalla, Jugador ejecutor) {
        return new Rendicion(batalla, ejecutor);
    }
}
