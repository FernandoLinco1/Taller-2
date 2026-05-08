package tallerPOO2;
//Nombre: Fernando Javier Lincopan Araya 
//Rut: 21.860.800-0
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class App {
	//Se inician estas variables staticas ya que se necesita un acceso directo a ellas desde diferentes metodos.
	
	//Con el Scanner el usuario podra elegir entre las opciones.
	public static Scanner lector;
	//El sistema se encarga de la mayoria del trabajo logico para que la App solo haga comparaciones e impresiones.
	public static Sistema sistema;
	//
	//este es el nombre del usuario
	public static String jugador;
	//El usuario va a interactuar con todo el sistema desde este menu.s
	public static void main(String[] args) {
		lector= new Scanner(System.in);
		//La clase app se va a comunicar solo con Sistema, las clases y listas van a ser dadas por el sistema.
		sistema= new Sistema(lecturaArchivo("Pokedex.txt"),lecturaArchivo("Alto Mando.txt"),lecturaArchivo("Gimnasios.txt"),lectorLista("Habitats.txt"),lecturaArchivo("Registros.txt"));
		String decision="";
		System.out.println("Bienvenido a Pokemon");
		//El ciclo infinito del menu que solo se detendra si el usuario elige la decision "3".
		while(!decision.equals("3")) {
			System.out.println("\r\n"+ "1) Continuar.\r\n"+ "2) Nueva Partida.\r\n"+ "3) Salir.\r\n"+ "");
			System.out.print(">>> ");
			decision= lector.nextLine();
			String decisionJugador="";
			//Con este switch respecto de decision, podemos saber que hara el usuario segun su respuesta
			// ademas de tener un default para cualquier valor que no sea las opciones que nosotros validamos.
			
			switch(decision) {
			// En el caso "1": el usuario va a continuar su partida pasada (en caaso de que tenga una partida pasada).
			case "1":
				if(lecturaArchivo("Registros.txt").size()!=0) {
				//Una vez corroborado que si tenia una partoda guardada se guerdan todos los valores de la partida pasada
				//como lo es: su nombre, los lideres de gimnasio que derroto, sus pokemones y su estado (Vivo o Derrotado).
				jugador=sistema.leerRegistro(lecturaArchivo("Registros.txt"));
				decisionJugador="";
				System.out.println();
				System.out.println("Bienvenido "+jugador+"!!"+"\r\n");
				//Este es el menu de juego como tal y donde se desarrollara gran parte de este
				//hasta que el usuario decida guardar su partida y salir, eligiendo la decisionJugador "8".
				while(!decisionJugador.equals("8")) {
					System.out.println(jugador+", que deseas hacer?");
					System.out.println("\r\n"+ "1) Revisar equipo.\r\n"+ "2) Salir a capturar.\r\n"+ "3) Acceso al PC (cambiar Pokémon del equipo).\r\n"+ "4) Retar un gimnasio.\r\n"+ "5) Desafío al Alto Mando.\r\n"+ "6) Curar Pokémon.\r\n"+ "7) Guardar.\r\n"+ "8) Guardar y Salir.\r\n"+"");
					System.out.print("Ingrese Opcion: ");
					decisionJugador= lector.nextLine();
					switch(decisionJugador) {
					case "1":
						// Se hacen estos metodos para tener todo mas organizado en el menu.
						eleccionJugador1();
						break;
					case "2":
						eleccionJugador2();
						break;
					case "3":
						eleccionJugador3();
						break;
					case "4":
						eleccionJugador4();
						break;
					case "5":
						eleccionJugador5();
						break;
					case "6":
						eleccionJugador6();
						break;
					case "7":
						eleccionJugador7();
						System.out.println("\r\n"+"Progreso guardado exitosamente");
						break;
					case "8":
						eleccionJugador7();
						System.out.println("\r\n"+"Nos vemos entrenador...");
						break;
					default:
						System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
						break;
					}
					
				}
				}else {
					System.out.println("\r\n"+"Error no hay partida guardada."+"\r\n");
				}
				break;
			case "2":
				//este es el caso en que el usuario desea inicia una partida y borrar cualquier dato que estuviese en el registro 
				System.out.print("\r\n"+"Ingrese Apodo: ");
				jugador= lector.nextLine();
				decisionJugador="";
				System.out.println();
				System.out.println("Bienvenido "+jugador+"!!"+"\r\n");
				//Este es el menu de juego como tal y donde se desarrollara gran parte de este
				//hasta que el usuario decida guardar su partida y salir, eligiendo la decisionJugador "8".
				while(!decisionJugador.equals("8")) {
					System.out.println(jugador+", que deseas hacer?");
					System.out.println("\r\n"+ "1) Revisar equipo.\r\n"+ "2) Salir a capturar.\r\n"+ "3) Acceso al PC (cambiar Pokémon del equipo).\r\n"+ "4) Retar un gimnasio.\r\n"+ "5) Desafío al Alto Mando.\r\n"+ "6) Curar Pokémon.\r\n"+ "7) Guardar.\r\n"+ "8) Guardar y Salir.\r\n"+"");
					System.out.print("Ingrese Opcion: ");
					decisionJugador= lector.nextLine();
					switch(decisionJugador) {
					case "1":
					//Tiene el mismo proposito que en el caso anterior.
						eleccionJugador1();
						break;
					case "2":
						eleccionJugador2();
						break;
					case "3":
						eleccionJugador3();
						break;
					case "4":
						eleccionJugador4();
						break;
					case "5":
						eleccionJugador5();
						break;
					case "6":
						eleccionJugador6();
						break;
					case "7":
						eleccionJugador7();
						System.out.println("\r\n"+"Progreso guardado exitosamente");
						break;
					case "8":
						eleccionJugador7();
						System.out.println("\r\n"+"Nos vemos entrenador...");
						break;
					default:
						//control de errores de valores no deseados.
						System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
						break;
					}
					
				}
				break;
			case "3":
				// Este es el caso en el que el usuario quiera cerrar el programa completo.
				System.out.println("\r\n"+"Cerrando juego...");
				break;
			default:
				//control de errores de valores no deseados.
				System.out.println("Error ingrese un valor valido.");
				break;
			}
		}
		//Cerramos el lector debido a que ya se va a finalizar el programa.
		lector.close();
	}
	//Este metodo lee archivos con separador ";", retornando una matriz tipo ArrayList<ArrayList<String>>.
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
			System.out.println("Error no se a encontrado el archivo.");
		}
		
		return matriz;
	}
	//Este metodo lee archivos con separador ";", retornando una lista tipo ArrayList<String>.
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
			System.out.println("Error no se a encontrado el archivo.");
		}
		
		return lista;
	}
	//Este metodo imprimira el equipo del jugador.
	public static void eleccionJugador1() {
		ArrayList<Pokedex> pokemonesJugador= sistema.getJugador().getPcJugador();
		if(pokemonesJugador == null || pokemonesJugador.isEmpty()) {
			System.out.println("\r\n"+"No existe pokemones en tu equipo."+"\r\n");
		}else {
			System.out.println("\r\n"+"Equipo Actual:");
			int i=1;
			for(Pokedex poke: pokemonesJugador) {
				if(i<=6) {
				System.out.println(i+") "+poke.getPokemon()+"|"+poke.getTipo()+"|Stats totales: "+(poke.getAtaque()+poke.getAtaqueEspecial()+poke.getDefensa()+poke.getDefensaEspecial()+poke.getVelocidad()+poke.getVida()));
				i++; 	
				}
			}
			System.out.println();
		}
		
	}
	//Metodo para que el jugador agregue un pokemon dependiendo de la zona en la que el jugador quiera buscar
	// en la zonas cada pokemon tiene una probabilidad de aparecer.
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
						System.out.println("\r\n"+pokemon.getPokemon()+" a escapado..."+"\r\n");
					}else {
						sistema.agregarPokemon(pokemon,"Vivo");
						
						if((sistema.getJugador().getPcJugador().size())>6) {
							System.out.println("\r\n"+pokemon.getPokemon()+" capturado con exito!!"+"\r\n"+"\r\n"+pokemon.getPokemon()+" ha sido agregado a tu PC!"+"\r\n");
						}else {
							System.out.println("\r\n"+pokemon.getPokemon()+" capturado con exito!!"+"\r\n"+"\r\n"+pokemon.getPokemon()+" ha sido agregado a tu equipo!"+"\r\n");	
						}
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
	//Se imprimen todos los pokemones que tenga el jugador incluyendo el su equipo y se le da la opcion de 
	//cambiar de poscision a los pokemones permitiendo que puedas mover pokemones del la PC a el equipo
	//y viceversa.
	public static void eleccionJugador3() {
		ArrayList<Pokedex> pokemonesJugador= sistema.getJugador().getPcJugador();
		if(pokemonesJugador == null || pokemonesJugador.isEmpty()) {
			System.out.println("\r\n"+"No existe pokemones en tu PC."+"\r\n");
		}else {
			System.out.println("\r\n"+"PC "+jugador+":");
			int i=1;
			for(Pokedex poke: pokemonesJugador) {
				System.out.println(i+") "+poke.getPokemon()+"|"+poke.getTipo()+"|Stats totales: "+(poke.getAtaque()+poke.getAtaqueEspecial()+poke.getDefensa()+poke.getDefensaEspecial()+poke.getVelocidad()+poke.getVida()));
				i++; 	
			}
			System.out.println();
			System.out.println("1) Cambiar Pokémon."+"\r\n"+"2) Salir. ");
			System.out.print("\r\n"+"Ingrese Opcion: ");
			String decision= lector.nextLine();
			switch(decision) {
			case "1":
				try {
					System.out.print("Seleccione pokemon 1 (por su enumeracion en la lista): ");
					int pokemon1= Integer.parseInt(lector.nextLine());
					System.out.print("Seleccione pokemon 2 (por su enumeracion en la lista): ");
					int pokemon2= Integer.parseInt(lector.nextLine());
					if(pokemon1==pokemon2 && pokemon1<=pokemonesJugador.size() && pokemon2<=pokemonesJugador.size()) {
						System.out.println("\r\n"+"Error los valores ingresado son iguales."+"\r\n");
					}if(pokemon1!=pokemon2 && pokemon1<=pokemonesJugador.size() && pokemon2<=pokemonesJugador.size() ) {
						sistema.intercambioPokemones(pokemon1, pokemon2);
						System.out.println("Se han cambiado con exito!!"+"\r\n");
					}else {
						System.out.println("\r\n"+"Error ingrese valores valido."+"\r\n");
					}
					
				}catch(NumberFormatException e) {
					System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
				}
				break;
			case "2":
				System.out.println();
				break;
			default:
				System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
				break;
			}
		}
	}
	//Se le da a elegir al jugador que lider de gimnasio enfrentar  con la condicion de que debe haber 
	//derrotado al lider anterior (a escepcion del el primero que no tiene condicion), tampoco se puede
	//pelear con lideres que ya han sido derrotados.
	public static void eleccionJugador4() {
		ArrayList<Gimnasio> gimnasio= sistema.getListaGimnasios();
		ArrayList<Gimnasio> lideresDerrotados= sistema.getJugador().getLideresDerrotados();
		int i=1;
		System.out.println("\r\n"+"A cual Lider deseas retar??"+"\r\n");
		for(Gimnasio gym: gimnasio) {
			System.out.println(i+") "+gym.getLider()+" - Estado: "+gym.getEstado());
			i++;
		}
		System.out.println(i+") Volver al menu.");
		try {
			System.out.print("\r\n"+"Ingrese Opcion: ");
			int indice= Integer.valueOf(lector.nextLine());
			if(indice>i || i<1) {
				System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
			}else if(indice==9) {
				System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
			}else if(sistema.getJugador().getPcJugador().size()==0) {
				System.out.println("\r\n"+"Error no tienes pokemones en tu equipo."+"\r\n");
			}else if(indice>(gimnasio.size()+1) || indice<1) {
				System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
			}else if(indice!=1 && !gimnasio.get(indice-2).getEstado().equals("Derrotado")) {
					System.out.println("\r\n"+"Calmao Entrenador!!! No puedes retar a "+gimnasio.get(indice-1).getLider()+" sin haber derrotado a los lideres anteriores!!"+"\r\n");
				}else if(gimnasio.get(indice-1).getEstado().equals("Derrotado")) {
					System.out.println("\r\n"+"Calmao Entrenador!!! "+gimnasio.get(indice-1).getLider()+" ya a sido derrotado..."+"\r\n");
				}else if(indice!=1) {
					if(gimnasio.get(indice-2).getEstado().equals("Derrotado") || indice==1){
					peleaGimnasio(indice);
					}
				}else {
					peleaGimnasio(indice);
				}
			
		}catch(NumberFormatException e) {
			System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
		}
	}
	//El jugador tiene 3 opciones de combate 1) pelear, 2)cambiar de pokemon y 3) rendirse.
	//1): se comparan la suma de las estadisticas de los pokemones del jugador y del lider 
	// multiplicadas con sus efectividades respectivas, en caso de que pierda el jugador su pokemon
	//debilitara y pelearas con el siguiente pokemon de su equipo, si ya no le quedan pokemones en su equipo
	//se dara la lucha por perdida volviendo al menu con sus pokemones debilitados.
	//en caso de que pierda el lider peleara con el siguiente pokemon, en caso de no tener mas pokemones
	//abras ganado el combate marcando a este lider como Derrotado.
	//2):puedes cambair tu pokemon que esta peleando por cualquiera de los pokemones del equipo
	//(los primeros 6 pokemones del jugador son su equipo ) no existe limite de veces para cambiar de pokemon.
	//3) dejar el combate salvando a los pokemones que no esten Debilidados.
	public static void peleaGimnasio(int indice) {
		ArrayList<Gimnasio> gimnasio= sistema.getListaGimnasios();
		Gimnasio lider= gimnasio.get(indice-1);
		ArrayList<Pokedex> equipoJugador= sistema.getJugador().getPcJugador();
		System.out.println("\r\n"+"Desafiando a "+lider.getLider()+"!!");
		String decision="";
		String derrota="";
		int indiceJugador=0;
		int indiceLider=0;
		while(!decision.equals("3")) {
			equipoJugador= sistema.getJugador().getPcJugador();
			gimnasio= sistema.getListaGimnasios();
			lider= gimnasio.get(indice-1);
			equipoJugador= sistema.getJugador().getPcJugador();
			if(!sistema.getJugador().getEstadoPokemones().get(indiceJugador).equals("Derrotado")) {
			System.out.println("\r\n"+lider.getLider()+" saca a "+lider.getPokemons()[indiceLider].getPokemon()+"!"+"\r\n"+jugador+" saca a "+equipoJugador.get(indiceJugador).getPokemon()+"!"+"\r\n");
			System.out.println("Que deseas hacer?\r\n"+ "1) Atacar\r\n"+ "2) Cambiar de pokemon\r\n"+ "3) Rendirse");
			System.out.print("\r\n"+"Ingrese Opcion: ");
			decision=lector.nextLine();
			switch(decision) {
			case "1":
				int poderLider= lider.getPokemons()[indiceLider].getAtaque()+lider.getPokemons()[indiceLider].getAtaqueEspecial()+lider.getPokemons()[indiceLider].getDefensa()+lider.getPokemons()[indiceLider].getDefensaEspecial()+lider.getPokemons()[indiceLider].getVelocidad()+lider.getPokemons()[indiceLider].getVida();
				int poderJugador= equipoJugador.get(indiceJugador).getAtaque()+equipoJugador.get(indiceJugador).getAtaqueEspecial()+equipoJugador.get(indiceJugador).getDefensa()+equipoJugador.get(indiceJugador).getDefensaEspecial()+equipoJugador.get(indiceJugador).getVelocidad()+equipoJugador.get(indiceJugador).getVida();
				System.out.println("\r\n"+equipoJugador.get(indiceJugador).getPokemon()+" -> "+poderJugador+" puntos"+"\r\n"+lider.getPokemons()[indiceLider].getPokemon()+" -> "+poderLider+" puntos"+"\r\n");
				double efectividadJugador= sistema.tablaTipo(equipoJugador.get(indiceJugador).getTipo(), lider.getPokemons()[indiceLider].getTipo());
				double efectividadLider= sistema.tablaTipo(lider.getPokemons()[indiceLider].getTipo(), equipoJugador.get(indiceJugador).getTipo());
				
				if(efectividadJugador==0.5) {
					System.out.println("\r\n"+equipoJugador.get(indiceJugador).getPokemon()+" no es efectivo contra "+lider.getPokemons()[indiceLider].getPokemon()+"!");
					if(efectividadLider==0.5) {
						System.out.println(lider.getPokemons()[indiceLider].getPokemon()+" no es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon()+"!");
						
					}else if(efectividadLider==2.0) {
						System.out.println(lider.getPokemons()[indiceLider].getPokemon()  +" es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon() +"!");
						
					}
					System.out.println("Nuevo puntaje:");
					System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" -> "+Math.round(poderJugador*efectividadJugador)+" puntos"+"\r\n"+lider.getPokemons()[indiceLider].getPokemon()+" -> "+Math.round(poderLider*efectividadLider)+" puntos"+"\r\n");
					if(Math.round(poderJugador*efectividadJugador)>Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+lider.getPokemons()[indiceLider].getPokemon()+" ha sido derrotado...");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
						}
						 
					}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+lider.getPokemons()[indiceLider].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado...");
						sistema.setEstadoP(indiceJugador);
						indiceJugador++;
						if(indiceJugador>=6) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}else if(indiceJugador>=equipoJugador.size()) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}
						
					}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderLider*efectividadLider)) {
						System.out.println("Empate unanime!!"+"\r\n");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
							sistema.setEstadoP(indiceJugador);
							indiceJugador++;
							if(indiceJugador>=6) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}else if(indiceJugador>=equipoJugador.size()) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}
						}
						
					}
				}else if(efectividadJugador==2.0) {
					System.out.println("\r\n"+equipoJugador.get(indiceJugador).getPokemon()+" es efectivo contra "+lider.getPokemons()[indiceLider].getPokemon()+"!");
					if(efectividadLider==0.5) {
						System.out.println(lider.getPokemons()[indiceLider].getPokemon()+" no es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon()+"!");
						
					}else if(efectividadLider==2.0) {
						System.out.println(lider.getPokemons()[indiceLider].getPokemon()  +" es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon() +"!");
						
					}
					System.out.println("Nuevo puntaje:");
					System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" -> "+Math.round(poderJugador*efectividadJugador)+" puntos"+"\r\n"+lider.getPokemons()[indiceLider].getPokemon()+" -> "+Math.round(poderLider*efectividadLider)+" puntos"+"\r\n");
					if(Math.round(poderJugador*efectividadJugador)>Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+lider.getPokemons()[indiceLider].getPokemon()+" ha sido derrotado...");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
						}
						 
					}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+lider.getPokemons()[indiceLider].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado...");
						sistema.setEstadoP(indiceJugador);
						indiceJugador++;
						if(indiceJugador>=6) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}else if(indiceJugador>=equipoJugador.size()) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}
						
					}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderLider*efectividadLider)) {
						System.out.println("Empate unanime!!"+"\r\n");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
							sistema.setEstadoP(indiceJugador);
							indiceJugador++;
							if(indiceJugador>=6) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}else if(indiceJugador>=equipoJugador.size()) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}
						}
						
					}
				}else if(efectividadLider==0.5) {
					System.out.println("\r\n"+lider.getPokemons()[indiceLider].getPokemon()+" no es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon()+"!");
					System.out.println("Nuevo puntaje:");
					System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" -> "+Math.round(poderJugador*efectividadJugador)+" puntos"+"\r\n"+lider.getPokemons()[indiceLider].getPokemon()+" -> "+Math.round(poderLider*efectividadLider)+" puntos"+"\r\n");
					if(Math.round(poderJugador*efectividadJugador)>Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+lider.getPokemons()[indiceLider].getPokemon()+" ha sido derrotado...");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
						}
						 
					}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+lider.getPokemons()[indiceLider].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado...");
						sistema.setEstadoP(indiceJugador);
						indiceJugador++;
						if(indiceJugador>=6) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}else if(indiceJugador>=equipoJugador.size()) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}
						
					}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderLider*efectividadLider)) {
						System.out.println("Empate unanime!!"+"\r\n");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
							sistema.setEstadoP(indiceJugador);
							indiceJugador++;
							if(indiceJugador>=6) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}else if(indiceJugador>=equipoJugador.size()) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}
						}
						
					}
				}else if(efectividadLider==2.0) {
					System.out.println("\r\n"+lider.getPokemons()[indiceLider].getPokemon()  +" es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon() +"!");
					System.out.println("Nuevo puntaje:");
					System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" -> "+Math.round(poderJugador*efectividadJugador)+" puntos"+"\r\n"+lider.getPokemons()[indiceLider].getPokemon()+" -> "+Math.round(poderLider*efectividadLider)+" puntos"+"\r\n");
					if(Math.round(poderJugador*efectividadJugador)>Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+lider.getPokemons()[indiceLider].getPokemon()+" ha sido derrotado...");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
						}
						 
					}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+lider.getPokemons()[indiceLider].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado...");
						sistema.setEstadoP(indiceJugador);
						indiceJugador++;
						if(indiceJugador>=6) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}else if(indiceJugador>=equipoJugador.size()) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}
						
					}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderLider*efectividadLider)) {
						System.out.println("Empate unanime!!"+"\r\n");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
							sistema.setEstadoP(indiceJugador);
							indiceJugador++;
							if(indiceJugador>=6) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}else if(indiceJugador>=equipoJugador.size()) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}
						}
						
					}
				}else {
					if(Math.round(poderJugador*efectividadJugador)>Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+lider.getPokemons()[indiceLider].getPokemon()+" ha sido derrotado...");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
						}
						 
					}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderLider*efectividadLider)) {
						System.out.println("Ha ganado "+lider.getPokemons()[indiceLider].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado...");
						sistema.setEstadoP(indiceJugador);
						indiceJugador++;
						if(indiceJugador>=6) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}else if(indiceJugador>=equipoJugador.size()) {
							System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
						}
						
					}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderLider*efectividadLider)) {
						System.out.println("Empate unanime!!"+"\r\n");
						if(indiceLider==lider.getPokemons().length-1) {
							sistema.setEstado("Derrotado", lider);
							sistema.agregarLider(lider);
							System.out.println("\r\n"+"Felicidades has derrotado a "+lider.getLider());
							System.out.println("\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
						}else {
							indiceLider++;
							sistema.setEstadoP(indiceJugador);
							indiceJugador++;
							if(indiceJugador>=6) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}else if(indiceJugador>=equipoJugador.size()) {
								System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
								derrota="1";
							}
						}
						
					}
					
				}
				break;
			case "2":
				System.out.println("\r\n"+"Que pokemon deseas ocupar?:");
				for(int j=2;j<6;j++) {
					if(equipoJugador.size()>j && !sistema.getJugador().getEstadoPokemones().get(j).equals("Derrotado")) {
						System.out.println(j+") "+equipoJugador.get(j).getPokemon()+"|"+equipoJugador.get(j).getTipo()+"|Stats totales: "+(equipoJugador.get(j).getAtaque()+equipoJugador.get(j).getAtaqueEspecial()+equipoJugador.get(j).getDefensa()+equipoJugador.get(j).getDefensaEspecial()+equipoJugador.get(j).getVelocidad()+equipoJugador.get(j).getVida()));
						}				
					}
				System.out.print("\r\n"+"Ingrese Opcion: ");
				try {
					int cambio=Integer.valueOf(lector.nextLine());
					if(cambio>=1 && cambio<equipoJugador.size()) {
						sistema.intercambioPokemones(indiceJugador, cambio);
					}else {
						System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
					}
				}catch(NumberFormatException e) {
					System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
				}
				
				break;
			case "3":
				System.out.println("\r\n"+"Te has rendido..."+"\r\n"+"Volviendo al menu..."+"\r\n");
				break;
			default:
				System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
				break;
			}
			}else {
				indiceJugador++;
				if(indiceJugador>=5) {
					System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
					derrota="1";
				}else if(indiceJugador>=equipoJugador.size()) {
					System.out.println("\r\n"+"Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
					derrota="1";
				}
			}
			
			if(derrota.equals("1")) {
				break;
			}
			
		}
	}
	//Se inica un combate con el alto mando si y solo si a derrotado a todos los lideres de gimnasio,
	// una vez dentro se tiene que derrotar a todos los altos mandos para ganar, si pierdes o te rindes
	//no se guarda progreso y se tiene que empezar todo de nuevo.
	//El jugador tiene 3 opciones de combate 1) pelear, 2)cambiar de pokemon y 3) rendirse.
	//1): se comparan la suma de las estadisticas de los pokemones del jugador y del alto mando 
	// multiplicadas con sus efectividades respectivas, en caso de que pierda el jugador su pokemon	
	//debilitara y pelearas con el siguiente pokemon de su equipo, si ya no le quedan pokemones en su equipo
	//se dara por perdida la lucha, volviendo al menu con sus pokemones debilitados.
	//en caso de que pierda el alto mando peleara con el siguiente pokemon, en caso de no tener mas pokemones
	//pelearas con el siguiente alto mando y cuando no queden altos mandos ganaras el edsafio.
	//2):puedes cambair tu pokemon que esta peleando por cualquiera de los pokemones del equipo
	//(los primeros 6 pokemones del jugador son su equipo ) no existe limite de veces para cambiar de pokemon.
	//3) dejar el combate salvando a los pokemones que no esten Debilidados.
	public static void eleccionJugador5( ){
		if(!sistema.getListaGimnasios().get((sistema.getListaGimnasios().size()-1)).getEstado().equals("Derrotado")) {
			System.out.println("\r\n"+"Calmao Entrenador!!! No puedes retar al Alto Mando sin haber derrotado a todos los lideres de Gimnasio!!"+"\r\n");
		}else if(sistema.getJugador().getPcJugador().size()==0){
			System.out.println("\r\n"+"Error no tienes pokemones en tu equipo."+"\r\n");
		}else {
			int indice=0;
			int indiceJugador=0;
			System.out.println("\r\n"+"Has retado al Alto Mando");
			String derrotaMandos="";
			while(!derrotaMandos.equals("1")){
				AltosMandos mando= sistema.getListaAltosMandos().get(indice);
				ArrayList<Pokedex> equipoJugador= sistema.getJugador().getPcJugador();
				int indiceMando=0;
				String decision="";
				String derrota="";
				System.out.println("\r\n"+"Desafiando a "+mando.getNombreAltoMando()+"!!"+"\r\n");
				while(!decision.equals("3")) {
					 mando= sistema.getListaAltosMandos().get(indice);
					 equipoJugador= sistema.getJugador().getPcJugador();
					if(!sistema.getJugador().getEstadoPokemones().get(indiceJugador).equals("Derrotado")) {
					System.out.println(mando.getNombreAltoMando()+" saca a "+mando.getPokemons()[indiceMando].getPokemon()+"! "+"\r\n"+jugador+" saca a "+equipoJugador.get(indiceJugador).getPokemon()+"!"+"\r\n");
					System.out.println("Que deseas hacer?\r\n"+ "1) Atacar\r\n"+ "2) Cambiar de pokemon\r\n"+ "3) Rendirse");
					System.out.print("\r\n"+"Ingrese Opcion: ");
					try {
						decision=lector.nextLine();
						switch(decision) {
						case "1":
							int poderJugador= equipoJugador.get(indiceJugador).getAtaque()+equipoJugador.get(indiceJugador).getAtaqueEspecial()+equipoJugador.get(indiceJugador).getDefensa()+equipoJugador.get(indiceJugador).getDefensaEspecial()+equipoJugador.get(indiceJugador).getVelocidad()+equipoJugador.get(indiceJugador).getVida();
							int poderMando= mando.getPokemons()[indiceMando].getAtaque()+mando.getPokemons()[indiceMando].getAtaqueEspecial()+mando.getPokemons()[indiceMando].getDefensa()+mando.getPokemons()[indiceMando].getDefensaEspecial()+mando.getPokemons()[indiceMando].getVelocidad()+mando.getPokemons()[indiceMando].getVida();
					
							System.out.println("\r\n"+equipoJugador.get(indiceJugador).getPokemon()+" -> "+poderJugador+" puntos"+"\r\n"+mando.getPokemons()[indiceMando].getPokemon()+" -> "+poderMando+" puntos"+"\r\n");
							double efectividadJugador= sistema.tablaTipo(equipoJugador.get(indiceJugador).getTipo(), mando.getPokemons()[indiceMando].getTipo());
							double efectividadMando= sistema.tablaTipo(mando.getPokemons()[indiceMando].getTipo(), equipoJugador.get(indiceJugador).getTipo());
							if(efectividadJugador==0.5) {
								System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" no es efectivo contra "+mando.getPokemons()[indiceMando].getPokemon()+"!");
								if(efectividadMando==0.5) {
									System.out.println(mando.getPokemons()[indiceMando].getPokemon()+" no es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon()+"!");
									
								}else if(efectividadMando==2.0) {
									System.out.println(mando.getPokemons()[indiceMando].getPokemon()  +" es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon() +"!");
									
								}
								System.out.println("Nuevo puntaje:");
								System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" -> "+Math.round(poderJugador*efectividadJugador)+" puntos"+"\r\n"+mando.getPokemons()[indiceMando].getPokemon()+" -> "+Math.round(poderMando*efectividadMando)+" puntos"+"\r\n");
								if(Math.round(poderJugador*efectividadJugador)>Math.round(poderMando*efectividadMando)) {
									System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+mando.getPokemons()[indiceMando].getPokemon()+" ha sido derrotado..."+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
									}
									 
								}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderMando*efectividadMando)){
									System.out.println("Ha ganado "+mando.getPokemons()[indiceMando].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado..."+"\r\n");
									sistema.setEstadoP(indiceJugador);
									indiceJugador++;
									if(indiceJugador>=5) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}else if(indiceJugador>=equipoJugador.size()) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}
									
								}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderMando*efectividadMando)){
									System.out.println("Empate unanime!!"+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
										sistema.setEstadoP(indiceJugador);
										indiceJugador++;
										if(indiceJugador>=5) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}else if(indiceJugador>=equipoJugador.size()) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}
									}
									
									 
								}
							}else if(efectividadJugador==2.0) {
								System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" es efectivo contra "+mando.getPokemons()[indiceMando].getPokemon()+"!");
								if(efectividadMando==0.5) {
									System.out.println(mando.getPokemons()[indiceMando].getPokemon()+" no es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon()+"!");
									
								}else if(efectividadMando==2.0) {
									System.out.println(mando.getPokemons()[indiceMando].getPokemon()  +" es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon() +"!");
									
								}
								System.out.println("Nuevo puntaje:");
								System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" -> "+Math.round(poderJugador*efectividadJugador)+" puntos"+"\r\n"+mando.getPokemons()[indiceMando].getPokemon()+" -> "+Math.round(poderMando*efectividadMando)+" puntos"+"\r\n");
								if(Math.round(poderJugador*efectividadJugador)>Math.round(poderMando*efectividadMando)) {
									System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+mando.getPokemons()[indiceMando].getPokemon()+" ha sido derrotado..."+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
									}
									 
								}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderMando*efectividadMando)){
									System.out.println("Ha ganado "+mando.getPokemons()[indiceMando].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado..."+"\r\n");
									sistema.setEstadoP(indiceJugador);
									indiceJugador++;
									if(indiceJugador>=5) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}else if(indiceJugador>=equipoJugador.size()) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}
									
								}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderMando*efectividadMando)){
									System.out.println("Empate unanime!!"+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
										sistema.setEstadoP(indiceJugador);
										indiceJugador++;
										if(indiceJugador>=5) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}else if(indiceJugador>=equipoJugador.size()) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}
									}
									
									 
								}
							}else if(efectividadMando==0.5) {
								System.out.println(mando.getPokemons()[indiceMando].getPokemon()+" no es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon()+"!");
								System.out.println("Nuevo puntaje:");
								System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" -> "+Math.round(poderJugador*efectividadJugador)+" puntos"+"\r\n"+mando.getPokemons()[indiceMando].getPokemon()+" -> "+Math.round(poderMando*efectividadMando)+" puntos"+"\r\n");
								if(Math.round(poderJugador*efectividadJugador)>Math.round(poderMando*efectividadMando)) {
									System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+mando.getPokemons()[indiceMando].getPokemon()+" ha sido derrotado..."+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
									}
									 
								}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderMando*efectividadMando)){
									System.out.println("Ha ganado "+mando.getPokemons()[indiceMando].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado..."+"\r\n");
									sistema.setEstadoP(indiceJugador);
									indiceJugador++;
									if(indiceJugador>=5) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}else if(indiceJugador>=equipoJugador.size()) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}
									
								}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderMando*efectividadMando)){
									System.out.println("Empate unanime!!"+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
										sistema.setEstadoP(indiceJugador);
										indiceJugador++;
										if(indiceJugador>=5) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}else if(indiceJugador>=equipoJugador.size()) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}
									}
									
									 
								}
							}else if(efectividadMando==2.0) {
								System.out.println(mando.getPokemons()[indiceMando].getPokemon()  +" es efectivo contra "+equipoJugador.get(indiceJugador).getPokemon() +"!");
								System.out.println("Nuevo puntaje:");
								System.out.println(equipoJugador.get(indiceJugador).getPokemon()+" -> "+Math.round(poderJugador*efectividadJugador)+" puntos"+"\r\n"+mando.getPokemons()[indiceMando].getPokemon()+" -> "+Math.round(poderMando*efectividadMando)+" puntos"+"\r\n");
								if(Math.round(poderJugador*efectividadJugador)>Math.round(poderMando*efectividadMando)) {
									System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+mando.getPokemons()[indiceMando].getPokemon()+" ha sido derrotado..."+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
									}
									 
								}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderMando*efectividadMando)){
									System.out.println("Ha ganado "+mando.getPokemons()[indiceMando].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado..."+"\r\n");
									sistema.setEstadoP(indiceJugador);
									indiceJugador++;
									if(indiceJugador>=5) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}else if(indiceJugador>=equipoJugador.size()) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}
									
								}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderMando*efectividadMando)){
									System.out.println("Empate unanime!!"+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
										sistema.setEstadoP(indiceJugador);
										indiceJugador++;
										if(indiceJugador>=5) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}else if(indiceJugador>=equipoJugador.size()) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}
									}
									
									 
								}
							}else {
								if(Math.round(poderJugador*efectividadJugador)>Math.round(poderMando*efectividadMando)) {
									System.out.println("Ha ganado "+equipoJugador.get(indiceJugador).getPokemon()+"! "+mando.getPokemons()[indiceMando].getPokemon()+" ha sido derrotado..."+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
									}
									 
								}else if(Math.round(poderJugador*efectividadJugador)<Math.round(poderMando*efectividadMando)){
									System.out.println("Ha ganado "+mando.getPokemons()[indiceMando].getPokemon()+"! "+equipoJugador.get(indiceJugador).getPokemon()+" ha sido derrotado..."+"\r\n");
									sistema.setEstadoP(indiceJugador);
									indiceJugador++;
									if(indiceJugador>=5) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}else if(indiceJugador>=equipoJugador.size()) {
										System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
										derrota="1";
										derrotaMandos="1";
									}
									
								}else if(Math.round(poderJugador*efectividadJugador)==Math.round(poderMando*efectividadMando)){
									System.out.println("Empate unanime!!"+"\r\n");
									if(indiceMando==mando.getPokemons().length-1) {
										indice++;
										System.out.println("Felicidades has derrotado a "+mando.getNombreAltoMando());
										derrota="1";
									}else {
										indiceMando++;
										sistema.setEstadoP(indiceJugador);
										indiceJugador++;
										if(indiceJugador>=5) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}else if(indiceJugador>=equipoJugador.size()) {
											System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
											derrota="1";
											derrotaMandos="1";
										}
									}
									
									 
								}
								
							}
							
							
							
							break;
						case "2":
							System.out.println("\r\n"+"Que pokemon deseas ocupar?:");
							for(int j=2;j<6;j++) {
								if(equipoJugador.size()>j && !sistema.getJugador().getEstadoPokemones().get(j).equals("Derrotado")) {
								System.out.println(j+") "+equipoJugador.get(j).getPokemon()+"|"+equipoJugador.get(j).getTipo()+"|Stats totales: "+(equipoJugador.get(j).getAtaque()+equipoJugador.get(j).getAtaqueEspecial()+equipoJugador.get(j).getDefensa()+equipoJugador.get(j).getDefensaEspecial()+equipoJugador.get(j).getVelocidad()+equipoJugador.get(j).getVida()));
								}
							}
							System.out.print("\r\n"+"Ingrese Opcion: ");
							try {
								int cambio=Integer.valueOf(lector.nextLine());
								if(cambio>=1 && cambio<equipoJugador.size()) {
									sistema.intercambioPokemones(indiceJugador, cambio+1);
								}else {
									System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
								}
							}catch(NumberFormatException e) {
								System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
							}
							
							break;
						case "3":
							System.out.println("\r\n"+"Te has rendido..."+"\r\n"+"Volviendo al menu..."+"\r\n");
							derrota="1";
							break;
						default:
							System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
							break;
						}
						
					}catch(NumberFormatException e) {
						System.out.println("\r\n"+"Error ingrese un valor valido."+"\r\n");
					}
					}else {
						indiceJugador++;
						if(indiceJugador>=5) {
							System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
							derrotaMandos="1";
						}else if(indiceJugador>=equipoJugador.size()) {
							System.out.println("Te has quedado sin pokemons en tu equipo!"+"\r\n"+ "Volviendo al menu..."+"\r\n");
							derrota="1";
							derrotaMandos="1";
						}
					}
					if(derrota.equals("1")) {
						break;
					}
				}
				if(indice>=(sistema.getListaAltosMandos().size()) && derrotaMandos==""){
					derrotaMandos="1";
					System.out.println("\r\n"+"Felicidades "+jugador+" te has coronado como el Campeon de la liga pokemon!!"+"\r\n");
				}
				
			}
		}
	}
	//Cambias el estado de todos los pokemon a Vivo logrando volver a pelear.
	public static void eleccionJugador6() {
		sistema.curarPokemones();
		System.out.println("\r\n"+"Tu equipo se ha recuperado!"+"\r\n");
	}
	//Reescribe en el archivo txt Registros.txt el nombre del jugador, todos los jefes que derroto en la partida
	//y los pokemones del jugador y sus estados (vivo o Debilitado)
	public static void eleccionJugador7() {
		try {
			String archivo="Registros.txt";
			BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(archivo));
			if(sistema.getJugador().getLideresDerrotados().size()==0) {
				writer.write(jugador+";none");
			}else {
				writer.write(jugador);
				for(Gimnasio gym:sistema.getJugador().getLideresDerrotados()) {
					writer.write(";"+gym.getLider());
				}
				
			}
			int i=0;
			for(Pokedex pokemon:sistema.getJugador().getPcJugador()) {
				writer.newLine(); 
				writer.write(pokemon.getPokemon()+";"+sistema.getJugador().getEstadoPokemones().get(i));
				i++;
				
			}
			writer.close();
		}catch (IOException e) {
			System.out.println("Error no se a encontrado el archivo.");
	    }
	}
	
}
