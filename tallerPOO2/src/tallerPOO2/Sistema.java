package tallerPOO2;
import java.util.ArrayList;

public class Sistema {
	private ArrayList<Pokedex> listaPokedex= new ArrayList();
	private ArrayList<AltosMandos> listaAltosMandos= new ArrayList(); 
	private ArrayList<Gimnasio> listaGimnasios = new ArrayList();  
	private ArrayList<String> listaHabitats= new ArrayList(); 
	private ArrayList<ArrayList<String>> Registros= new ArrayList();
	public Sistema(ArrayList<ArrayList<String>> listaPokedex,ArrayList<ArrayList<String>> listaAltosMandos, ArrayList<ArrayList<String>> listaGimnasios,
			ArrayList<String> listaHabitats, ArrayList<ArrayList<String>> registros) {
		super();
		Transformador t= new Transformador();
		this.listaPokedex = t.transP(listaPokedex);
		this.listaAltosMandos = t.transA(listaAltosMandos);
		this.listaGimnasios = t.transG(listaGimnasios);
		this.listaHabitats = listaHabitats;
		Registros = registros;
	} 
	
	
	
}
