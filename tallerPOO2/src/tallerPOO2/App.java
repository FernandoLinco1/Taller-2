package tallerPOO2;
//Nombre: Fernando Javier Lincopan Araya 
//Rut: 21.860.800-0
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class App {
	public static Scanner lector;
	public static Sistema sistema;
	public static void main(String[] args) {
		lector= new Scanner(System.in);
		sistema= new Sistema(lecturaArchivo("Pokedex.txt"),lecturaArchivo("Alto Mando.txt"),lecturaArchivo("Gimnasios.txt"),lectorLista("Habitats.txt"),lecturaArchivo("Registros.txt"));
		String decision="";
		System.out.println("Bienvenido a Pokemon");
		while(!decision.equals("3")) {
			System.out.println("\r\n"+ "1) Continuar.\r\n"+ "2) Nueva Partida.\r\n"+ "3) Salir.\r\n"+ "");
			System.out.print(">>> ");
			decision= lector.nextLine();
			switch(decision) {
			case "1":
			
				break;
			case "2":
				System.out.print("\r\n"+"Ingrese Apodo: ");
				String jugador= lector.nextLine();
				String decisionJugador="";
				System.out.println();
				System.out.println("Bienvenido "+jugador+"!!"+"\r\n");
				while(!decisionJugador.equals("8")) {
					System.out.println(jugador+", que deseas hacer?");
					System.out.println("\r\n"+ "1) Revisar equipo.\r\n"+ "2) Salir a capturar.\r\n"+ "3) Acceso al PC (cambiar Pokémon del equipo).\r\n"+ "4) Retar un gimnasio.\r\n"+ "5) Desafío al Alto Mando.\r\n"+ "6) Curar Pokémon.\r\n"+ "7) Guardar.\r\n"+ "8) Guardar y Salir.\r\n"+"");
					System.out.print("Ingrese Opcion: ");
					decisionJugador= lector.nextLine();
					switch(decisionJugador) {
					case "1":
						eleccionJugador1();
						break;
					case "2":
						eleccionJugador2();
						break;
					case "3":
						break;
					case "4":
						break;
					case "5":
						break;
					case "6":
						break;
					case "7":
						break;
					case "8":
						break;
					default:
						System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
						break;
					}
					
				}
				break;
			case "3":
				System.out.println("\r\n"+"Cerrando juego...");
				break;
			default:
				System.out.println("Error ingrese un valor valido.");
				break;
			}
		}
		
		lector.close();
	}
	
	public static ArrayList<ArrayList<String>> lecturaArchivo(String titulo){
		ArrayList<ArrayList<String>> matriz= new ArrayList<>();
		File texto= new File(titulo);
		try {
			Scanner lec= new Scanner(texto);
			while(lec.hasNextLine()) {
				ArrayList<String> lista= new ArrayList();
				String linea= lec.nextLine();
				String[] partes= linea.split(";");
				for(String p: partes) {
				lista.add(p);	
				}
				matriz.add(lista);
			}
			lec.close();
		}catch(FileNotFoundException e) {
			java.lang.System.out.println("Error no se a encontrado el archivo.");
		}
		
		return matriz;
	}
	public static  ArrayList<String> lectorLista(String titulo){
		ArrayList<String> lista= new ArrayList();
		File texto= new File(titulo);
		try {
			Scanner lector= new Scanner(texto);
			while(lector.hasNextLine()) {
				String palabra= lector.nextLine();
				lista.add(palabra);
			}
		lector.close();
		}catch(FileNotFoundException e) {
			java.lang.System.out.println("Error no se a encontrado el archivo.");
		}
		
		return lista;
	}
	public static void eleccionJugador1() {
		ArrayList<Pokedex> jugador= sistema.getJugador().getPcJugador();
		if(jugador == null || jugador.isEmpty()) {
			System.out.println("\r\n"+"No existe pokemones en tu equipo."+"\r\n");
		}else {
			System.out.println("\r\n"+"Equipo Actual:");
			int i=1;
			for(Pokedex poke: jugador) {
				System.out.println(i+") "+poke.getPokemon()+"|"+poke.getTipo()+"|Stats totales: "+(poke.getAtaque()+poke.getAtaqueEspecial()+poke.getDefensa()+poke.getDefensaEspecial()+poke.getVelocidad()+poke.getVida()));
				i++; 	
			}
			System.out.println();
		}
		
	}
	public static void eleccionJugador2() {
		System.out.println("\r\n"+"Donde deseas ir a explorar?"+"\r\n");
		System.out.println("Zonas disponibles:"+"\r\n");
		ArrayList<String> listaHabitats= sistema.getListaHabitats();
		for(int i=0;i<listaHabitats.size();i++) {
			System.out.println((i+1)+") "+listaHabitats.get(i));
		}System.out.println((listaHabitats.size()+1)+") Volver al menu.");
		System.out.print("\r\n"+"Ingrese Zona: ");
		try {
			int zona= Integer.parseInt(lector.nextLine());
			 if((listaHabitats.size()+1)!=zona) {
				Pokedex pokemon= sistema.pokemonesZona(zona);
				System.out.println("\r\n"+"Oh!! Ha aparecido un increible "+pokemon.getPokemon()+"!!\r\n"+ "\r\n"+ "Que deseas hacer?\r\n"+ "\r\n"+ "1) Capturar\r\n"+ "2) Huir");
				System.out.print("\r\n"+"Ingrese Opcion: ");
				String opcion= lector.nextLine();
				switch(opcion) {
				case "1":
					if(sistema.verificarPokemon(pokemon)) {
						System.out.println("");
					}else {
						sistema.agregarPokemon(pokemon);
						System.out.println("\r\n"+pokemon.getPokemon()+" capturado con exito!!"+"\r\n"+"\r\n"+pokemon.getPokemon()+" ha sido agregado a tu equipo!"+"\r\n");
					}
					break;
				case "2":
					System.out.println("\r\n"+"Has huido con exito!!"+"\r\n");
					break;
				default:
					System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
					break;
				}
			 }
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
