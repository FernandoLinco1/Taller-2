package tallerPOO2;

import java.util.ArrayList;

public class Jugador {
	private ArrayList<Pokedex> pcJugador= new ArrayList<>();
	private ArrayList<String> estadoPokemones= new ArrayList<>();
	private ArrayList<Gimnasio> lideresDerrotados= new ArrayList<>();
	public ArrayList<Pokedex> getPcJugador() {
		return pcJugador;
	}
	public void agregarLider(Gimnasio lider) {
		lideresDerrotados.add(lider);
	}
	public void agregarPokemon(Pokedex pokemon) {
		pcJugador.add(pokemon);
		estadoPokemones.add("Vivo");
	}
	public ArrayList<String> getEstadoPokemones() {
		return estadoPokemones;
	}
	public ArrayList<Gimnasio> getLideresDerrotados() {
		return lideresDerrotados;
	}
	public void setEstadoPokemon(int indiceEstado) {
		estadoPokemones.set(indiceEstado, "Derrotado");
	}
	public void curarPokemones(int i) {
		estadoPokemones.set(i, "Vivo");
	}
}
