package tallerPOO2;

import java.util.ArrayList;

public class Jugador {
	private ArrayList<Pokedex> pcJugador= new ArrayList<>();
	private ArrayList<String> estadoPokemones= new ArrayList<>();
	
	public ArrayList<Pokedex> getPcJugador() {
		return pcJugador;
	}
	public void agregarPokemon(Pokedex pokemon) {
		pcJugador.add(pokemon);
		estadoPokemones.add("Vivo");
	}
	public ArrayList<String> getEstadoPokemones() {
		return estadoPokemones;
	}
	
}
