package tallerPOO2;
//Nombre: Fernando Javier Lincopan Araya 
//Rut: 21.860.800-0
import java.util.*;
import java.io.*;
public class App {
	public static Scanner lector;
	public static void main(String[] args) {
		lector= new Scanner(java.lang.System.in);
	
		
		
		lector.close();
	}
	
	public static ArrayList<ArrayList<String>> lecturaArchivo(String titulo){
		ArrayList<ArrayList<String>> matriz= new ArrayList<>();
		File texto= new File(titulo);
		try {
			lector= new Scanner(texto);
			while(lector.hasNextLine()) {
				ArrayList<String> lista= new ArrayList();
				String linea= lector.nextLine();
				String[] partes= linea.split(";");
				for(String p: partes) {
				lista.add(p);	
				}
				matriz.add(lista);
			}
			
			
			
			
		}catch(FileNotFoundException e) {
			java.lang.System.out.println("Error no se a encontrado el archivo.");
		}
		return matriz;
	}
	
}
