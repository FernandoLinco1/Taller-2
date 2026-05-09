package tallerPOO2;

public class AltosMandos {
	private int altoMandoN;
	private String nombreAltoMando;
	Pokedex[] pokemons= new Pokedex[6];
	public AltosMandos(int altoMandoN, String nombreAltoMando, Pokedex[] pokemons) {
		super();
		this.altoMandoN = altoMandoN;
		this.nombreAltoMando = nombreAltoMando;
		this.pokemons = pokemons;
	}
	
	public int getAltoMandoN() {
		return altoMandoN;
	}
	public String getNombreAltoMando() {
		return nombreAltoMando;
	}
	public Pokedex[] getPokemons() {
		return pokemons;
	}
	
}
