package tallerPOO2;

public class Pokedex {
	private String pokemon;
	private String habitad;
	private double porcentajeAparicion;
	private int vida;
	private int ataque;
	private int defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private String tipo;
	public Pokedex(String pokemon, String habitad, double porcentajeAparicion, int vida, int ataque, int defensa,
			int ataqueEspecial, int defensaEspecial, int velocidad, String tipo) {
		super();
		this.pokemon = pokemon;
		this.habitad = habitad;
		this.porcentajeAparicion = porcentajeAparicion;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.tipo = tipo;
	}
	public String getPokemon() {
		return pokemon;
	}
	public String getHabitad() {
		return habitad;
	}
	public double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}
	public int getVida() {
		return vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}
	public int getDefensaEspecial() {
		return defensaEspecial;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public String getTipo() {
		return tipo;
	}
	
	
}
