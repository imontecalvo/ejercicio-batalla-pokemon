package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.InteraccionUsuario;
import org.algo3.Jugador;
import org.algo3.Pokemon;

public class AccionFactoryCambioDePokemon extends AccionFactory{
    @Override
    public Accion crear(Batalla batalla, Jugador ejecutor) {
        Pokemon pokemonSeleccionado = InteraccionUsuario.solicitarPokemon(ejecutor.getPokemonesSeleccionables());
        if (pokemonSeleccionado==null) return null;
        return new CambioDePokemon(batalla, ejecutor, pokemonSeleccionado);
    }
}