package tallerPOO2;

public class Gimnasio {
	private int gymN;
	private String lider;
	private String estado;
	private Pokedex[] pokemons;
	public Gimnasio(int gymN, String lider, String estado, Pokedex[] pokemons) {
		super();
		this.gymN = gymN;
		this.lider = lider;
		this.estado = estado;
		this.pokemons = pokemons;
	}
	public int getGymN() {
		return gymN;
	}
	public String getLider() {
		return lider;
	}
	public String getEstado() {
		return estado;
	}
	public Pokedex[] getPokemons() {
		return pokemons;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
