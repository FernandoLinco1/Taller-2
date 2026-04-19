package tallerPOO2;

import java.util.ArrayList;

public class Transformador {
  
	public ArrayList<Pokedex> transP(ArrayList<ArrayList<String>> matriz){
		ArrayList<Pokedex> lista= new ArrayList();
		for(ArrayList<String> l:matriz) {
			Pokedex poke= new Pokedex(l.get(0),l.get(1),Double.parseDouble(l.get(2)),Integer.parseInt(l.get(3)),Integer.parseInt(l.get(4)),Integer.parseInt(l.get(5)),Integer.parseInt(l.get(6)),Integer.parseInt(l.get(7)),Integer.parseInt(l.get(8)), l.get(9));
			lista.add(poke);
		}
		return lista;
	}
	
	public ArrayList<AltosMandos> transA(ArrayList<ArrayList<String>> matriz){
		ArrayList<AltosMandos> lista= new ArrayList();
		
		return lista;
	}
	
	public ArrayList<Gimnasio> transG(ArrayList<ArrayList<String>> matriz){
		ArrayList<Gimnasio> lista= new ArrayList();
		
		return lista;
	}
	
	
	
	
}
