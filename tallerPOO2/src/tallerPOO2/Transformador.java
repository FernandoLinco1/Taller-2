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
	
	public ArrayList<AltosMandos> transA(ArrayList<ArrayList<String>> matriz,ArrayList<Pokedex> listaPokedex){
		ArrayList<AltosMandos> lista= new ArrayList();
	
		for(ArrayList<String> l:matriz) {
			Pokedex[] pokemones= new Pokedex[6];
			for(Pokedex p: listaPokedex) {
				if(l.get(2).equals(p.getPokemon())){
					pokemones[0]= p;
				}
				if(l.get(3).equals(p.getPokemon())){
					pokemones[1]= p;
				}
				if(l.get(4).equals(p.getPokemon())){
					pokemones[2]= p;
				}
				if(l.get(5).equals(p.getPokemon())){
					pokemones[3]= p;
				}
				if(l.get(6).equals(p.getPokemon())){
					pokemones[4]= p;
				}
				if(l.get(7).equals(p.getPokemon())){
					pokemones[5]= p;
				}
				
			}
			lista.add(new AltosMandos(Integer.parseInt(l.get(0)),l.get(1),pokemones));
			
		}
		return lista;
	}
	
	public ArrayList<Gimnasio> transG(ArrayList<ArrayList<String>> matriz,  ArrayList<Pokedex> listaPokedex){
		ArrayList<Gimnasio> lista= new ArrayList();
		for(ArrayList<String> l:matriz) {
			Pokedex[] pokemones= new Pokedex[Integer.parseInt(l.get(3))];
			for(int i=0;i<pokemones.length;i++) {//sumarle +3 a la i a la hora de ocupar el nombre del pokemon dentro de la lista
				for(Pokedex k: listaPokedex) {
					if(l.get(i+3).equals(k.getPokemon())) {
						pokemones[i]= k;
					}
				}
			}
			lista.add(new Gimnasio(Integer.parseInt(l.get(0)),l.get(1),l.get(2),pokemones));
		}
		return lista;
	}
	
	
	
	
}
