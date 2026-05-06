package tallerPOO2;
import java.util.ArrayList;
import java.util.Random;
public class Sistema {
	private ArrayList<Pokedex> listaPokedex= new ArrayList();
	private ArrayList<AltosMandos> listaAltosMandos= new ArrayList(); 
	private ArrayList<Gimnasio> listaGimnasios = new ArrayList();  
	private ArrayList<String> listaHabitats= new ArrayList(); 
	private ArrayList<ArrayList<String>> Registros= new ArrayList();
	private Jugador jugador = new Jugador();
	public Sistema(ArrayList<ArrayList<String>> listaPokedex,ArrayList<ArrayList<String>> listaAltosMandos, ArrayList<ArrayList<String>> listaGimnasios,
			ArrayList<String> listaHabitats, ArrayList<ArrayList<String>> registros) {
		super();
		Transformador t= new Transformador();
		this.listaPokedex = t.transP(listaPokedex);
		this.listaAltosMandos = t.transA(listaAltosMandos,this.listaPokedex);
		this.listaGimnasios = t.transG(listaGimnasios,this.listaPokedex);
		this.listaHabitats = listaHabitats;
		Registros = registros;
	}
	public ArrayList<Pokedex> getListaPokedex() {
		return listaPokedex;
	}
	public ArrayList<AltosMandos> getListaAltosMandos() {
		return listaAltosMandos;
	}
	public ArrayList<Gimnasio> getListaGimnasios() {
		return listaGimnasios;
	}
	public ArrayList<String> getListaHabitats() {
		return listaHabitats;
	} 
	public Jugador getJugador() {
		return jugador;
	}
	public boolean verificarPokemon(Pokedex pokemon) {
		
		for(Pokedex poke: jugador.getPcJugador()) {
			if(poke.getPokemon().equals(pokemon.getPokemon())) {
				return true;
			}
		}
		return false;
	}
	public void agregarPokemon(Pokedex pokemon) {
		jugador.agregarPokemon(pokemon);
	}
	public Pokedex pokemonesZona(int indiceZona){
		ArrayList<Pokedex> pokemones= new ArrayList<>();
		String zona="";
		for(int i=0;i<listaHabitats.size();i++) {
			if(i==(indiceZona-1)) {
				zona= listaHabitats.get(i);
			}
		}
		for(Pokedex poke: listaPokedex) {
			if(zona.equals(poke.getHabitad())) {
				pokemones.add(poke);
			}
		}
		int j=0;
		Pokedex[] pokeProbabilidad= new Pokedex[100];
		for(Pokedex poke:pokemones) {
			for(int i=0;i<Math.round(poke.getPorcentajeAparicion()*100);i++) {
				pokeProbabilidad[j]=poke;
				j++;
			}
		}
		Random random= new Random();
		 int indiceAleatorio = random.nextInt(pokeProbabilidad.length);
		return pokeProbabilidad[indiceAleatorio];
	}
	public void intercambioPokemones(int pokemon1, int pokemon2) {
		Pokedex aux= jugador.getPcJugador().get(pokemon1-1);
		String auxEstado= jugador.getEstadoPokemones().get(pokemon1-1);
		for(int i=0;i<jugador.getPcJugador().size();i++) {
			if(i==(pokemon1-1)) {
				jugador.getPcJugador().set(i, jugador.getPcJugador().get(pokemon2-1));
				jugador.getEstadoPokemones().set(i, jugador.getEstadoPokemones().get(pokemon2-1));
			}
			if(i==(pokemon2-1)) {
				jugador.getPcJugador().set(i,aux);
				jugador.getEstadoPokemones().set(i,auxEstado);
			}
		}
	}
	public void curarPokemones() {
		for(String estado:jugador.getEstadoPokemones()) {
			estado="Vivo";
		}
	}
}
