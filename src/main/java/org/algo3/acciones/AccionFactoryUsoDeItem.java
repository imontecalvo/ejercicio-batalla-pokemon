package org.algo3.acciones;

import org.algo3.Batalla;
import org.algo3.InteraccionUsuario;
import org.algo3.Jugador;
import org.algo3.Pokemon;
import org.algo3.items.Item;
import org.algo3.items.PocionRestauradoraDeVida;
import org.algo3.items.Resurreccion;

import java.util.List;
import java.util.Map;

public class AccionFactoryUsoDeItem extends AccionFactory{
    @Override
    public Accion crear(Batalla batalla, Jugador ejecutor) {
        Map<Item,Integer> mapaItems= ejecutor.getItems();
        Item itemSeleccionado = InteraccionUsuario.solicitarItem(mapaItems);
        if (itemSeleccionado==null) return null;

        Pokemon pokemonSeleccionado = ejecutor.getPokemonActual();

        //TODO: No es extensible
        if (itemSeleccionado instanceof PocionRestauradoraDeVida){
            pokemonSeleccionado = InteraccionUsuario.solicitarPokemon(ejecutor.getPokemonesVivos());
        }else if (itemSeleccionado instanceof Resurreccion){
            pokemonSeleccionado = InteraccionUsuario.solicitarPokemon(ejecutor.getPokemonesMuertos());
        }

        if (pokemonSeleccionado==null) return null;

        return new UsoDeItem(batalla, ejecutor, itemSeleccionado, pokemonSeleccionado);
    }
}
