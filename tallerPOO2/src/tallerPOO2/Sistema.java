package tallerPOO2;
import java.util.ArrayList;
import java.util.Random;
public class Sistema {
	// Las listas de clases y Strings se guardan en sistema para que estos archivos
	//para ser modificados unicamente por sistema a traves de las llamadas de la App.
	
	//Esta lista tiene todos los pokemones existentes en el juego. 
	private ArrayList<Pokedex> listaPokedex= new ArrayList();
	//Tiene todos los altos mandos que debes derrotar.
	private ArrayList<AltosMandos> listaAltosMandos= new ArrayList(); 
	//Tiene todos los lideres de gimnasio que debes derrotar.
	private ArrayList<Gimnasio> listaGimnasios = new ArrayList(); 
	//Son todas los habitads disponibles para explorar.
	private ArrayList<String> listaHabitats= new ArrayList(); 
	//Son los datos del jugador actual.
	private Jugador jugador = new Jugador();
	//Contiene la matriz de efectividad entre pokeones
	private TablaTipos tablaTipos= new TablaTipos();
	//El constructor pide las variables minimas para crear la clase sistema 
	public Sistema(ArrayList<ArrayList<String>> listaPokedex,ArrayList<ArrayList<String>> listaAltosMandos, ArrayList<ArrayList<String>> listaGimnasios,
			ArrayList<String> listaHabitats, ArrayList<ArrayList<String>> registros) {
		super();
		Transformador t= new Transformador();
		this.listaPokedex = t.transP(listaPokedex);
		this.listaAltosMandos = t.transA(listaAltosMandos,this.listaPokedex);
		this.listaGimnasios = t.transG(listaGimnasios,this.listaPokedex);
		this.listaHabitats = listaHabitats;
	}
	//Retorna la listaPokedex
	public ArrayList<Pokedex> getListaPokedex() {
		return listaPokedex;
	}
	//Retorna la listaAltosMandos
	public ArrayList<AltosMandos> getListaAltosMandos() {
		return listaAltosMandos;
	}
	//Retorna la listaGimnasios
	public ArrayList<Gimnasio> getListaGimnasios() {
		return listaGimnasios;
	}
	//Retorna la listaHabitats
	public ArrayList<String> getListaHabitats() {
		return listaHabitats;
	} 
	//Retorna la jugador
	public Jugador getJugador() {
		return jugador;
	}
	//Esta verificacion es para saber si el jugador ya tiene este pokemon o no, ya que no se pueden repetir los pokemones
	//en su Pc o equipo.
	public boolean verificarPokemon(Pokedex pokemon) {
		
		for(Pokedex poke: jugador.getPcJugador()) {
			if(poke.getPokemon().equals(pokemon.getPokemon())) {
				return true;
			}
		}
		return false;
	}
	//agrega un pokemon a los pokemones del jugador.
	public void agregarPokemon(Pokedex pokemon,String estado) {
		jugador.agregarPokemon(pokemon,estado);
	}
	//este devuelve el posible pokemon que puede aparecer en un habitad especifico.
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
	//Permite mover 2 pokemones del jugador de poscision.
	public void intercambioPokemones(int pokemon1, int pokemon2) {
		int indice=0;
		Pokedex aux= jugador.getPcJugador().get(pokemon1-1);
		String auxEstado= jugador.getEstadoPokemones().get(pokemon1-1);
		int indice2=0;
		Pokedex aux2= jugador.getPcJugador().get(pokemon2-1);
		String auxEstado2= jugador.getEstadoPokemones().get(pokemon2-1);
		for(int i=0;i<jugador.getPcJugador().size();i++) {
			if(i==(pokemon1-1)) {
				indice=i;
			}
			if(i==(pokemon2-1)) {
				indice2=i;
			}
		}
		jugador.intercambioPokemon(indice, aux, auxEstado, indice2, aux2, auxEstado2);
	}
	//Todos los pokemones del jugador trasforman su estado a Vivo.
	public void curarPokemones() {
		for(int i=0;i<jugador.getEstadoPokemones().size();i++) {
			jugador.curarPokemones(i);
		}
	}
	//Entrega la efectividad de el tipo1 contra el tipo2.
	public double tablaTipo(String tipo1, String tipo2) {
		 return tablaTipos.efectividadTipo(tipo1, tipo2);
	}
	public void setEstado(String estado, Gimnasio lider){
		for(int i=0;i<listaGimnasios.size();i++){
			if(listaGimnasios.get(i).equals(lider)) {
				listaGimnasios.get(i).setEstado(estado);
			}
		}
		
	}
	//setea el estado de un pokemon a Derrotado
	public void setEstadoP(int indice){
		jugador.setEstadoPokemon(indice);
		
	}
	// Agrega una objeto Gimnasio a la lista de lideresDerrotados.
	public void agregarLider(Gimnasio lider) {
		jugador.agregarLider(lider);
	}
	//En caso de querer continuar una partida se lee el archivo y se le entrega a este metodo una matriz 
	//para guardar los datos correspondiente.
	public String leerRegistro(ArrayList<ArrayList<String>> Registros) {
		
		String jugador="";
		for(int i=0;i<Registros.size();i++) {
			for(int j=0;j<Registros.get(i).size();j++) {
				if(i==0 && j==0) {
					jugador=Registros.get(i).get(j);
				}else if(i==0 && j!=0) {
					for(int k=0;k<listaGimnasios.size();k++) {
						if(listaGimnasios.get(k).getLider().equals(Registros.get(i).get(j))) {
							setEstado("Derrotado", listaGimnasios.get(k));
						}
					}
				}else if(j==0){
					for(Pokedex pokemon:listaPokedex) {
						if(pokemon.getPokemon().equals(Registros.get(i).get(j))) {
							agregarPokemon(pokemon, Registros.get(i).get(j+1));
						}
					}
					
				}
			}
		}
		return jugador;
		
	}
}
