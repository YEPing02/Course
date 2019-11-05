package gestioncourse;
import gestioninscription.*;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Etape {
	private int numEtape;
	private int tempsLimiteEtape;
	private HashMap<Inscription,Integer> mapInsEtape;
	private ArrayList<HashMap.Entry<Inscription,Integer>> classementEtape;
	
	
	public Etape (int numEtape, int tempsLimiteH, int tempsLimiteM,int tempsLimiteS) {
		this.tempsLimiteEtape=tempsLimiteH;
		this.numEtape = numEtape;
		this.mapInsEtape = new  HashMap<Inscription,Integer>();
		this.classementEtape = new ArrayList<HashMap.Entry<Inscription,Integer>>();
	}
	
	
	public int getNumEtape() {
		return this.numEtape;
	}
	
	
	public int getTempsLimiteEtape() {
		return tempsLimiteEtape;
	}


	public void setTempsLimiteEtape(int tempsLimiteEtape) {
		this.tempsLimiteEtape = tempsLimiteEtape;
	}


	public void setNumEtape(int numEtape) {
		this.numEtape = numEtape;
	}


	public void setMapInsEtape(HashMap<Inscription, Integer> mapInsEtape) {
		this.mapInsEtape = mapInsEtape;
	}


	public void setClassementEtape(ArrayList<HashMap.Entry<Inscription, Integer>> classementEtape) {
		this.classementEtape = classementEtape;
	}


	public void enregistreTemps(Inscription ins,int tempsE) {
		// si le temps de coureur superieur a tempsLimiteEtape, ce coureur n'a pas de classement
		if(tempsE > tempsLimiteEtape) {
			mapInsEtape.put(ins, null);
		}else {
		mapInsEtape.put(ins, tempsE);}
	}
	
	public HashMap<Inscription,Integer> getMapInsEtape(){
		return this.mapInsEtape;
	}
	
	public ArrayList<HashMap.Entry<Inscription,Integer>> getClassementEtape(){
		return this.classementEtape;
	}
	

	// methode pour calculer le classement de l'etape sans speciale
	public void classementEtape() {
		for(HashMap.Entry<Inscription,Integer> entry: mapInsEtape.entrySet()) {
			if(entry.getValue() != null) {
				int tempsverifie = entry.getValue();
				tempsverifie = (int)(tempsverifie*entry.getKey().getVehicule().calculerAvecCoef());
				entry.setValue(tempsverifie);
			}else {
				mapInsEtape.remove(entry.getKey());
			}
		}
		

		Set<HashMap.Entry<Inscription,Integer>> entrySet = mapInsEtape.entrySet();
		classementEtape = new ArrayList<HashMap.Entry<Inscription,Integer>>(entrySet);
		Collections.sort(classementEtape, new Comparator<HashMap.Entry<Inscription,Integer>>(){
			//@Override
			public int compare(HashMap.Entry<Inscription,Integer> c1,HashMap.Entry<Inscription,Integer> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
	}
	

	
	
	
	

}