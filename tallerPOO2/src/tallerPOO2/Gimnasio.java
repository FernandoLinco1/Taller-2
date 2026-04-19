package tallerPOO2;

public class Gimnasio {
	private int gymN;
	private String lider;
	private String estado;
	private int contPokemons;
	private Pokedex[] pokemons= new Pokedex[contPokemons];
	public Gimnasio(int gymN, String lider, String estado, int contPokemons, Pokedex[] pokemons) {
		super();
		this.gymN = gymN;
		this.lider = lider;
		this.estado = estado;
		this.contPokemons = contPokemons;
		this.pokemons = pokemons;
	}
	
}
