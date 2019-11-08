package gestioncourse;

import gestioninscription.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;

public abstract class Etape {
	protected int numEtape;
	protected float tempsLimiteEtape;
	protected HashMap<Inscription, Float> mapInsEtape;// liste inscri--temps
	protected ArrayList<HashMap.Entry<Inscription, Float>> classementEtape;
	protected ArrayList<Speciale> listeSpeciale;

	public Etape(int numEtape, int tempsLimiteH, int tempsLimiteM, float tempsLimiteS) {
		setTempsLimite(tempsLimiteH, tempsLimiteM, tempsLimiteS);
		this.numEtape = numEtape;
		this.mapInsEtape = new HashMap<Inscription, Float>();
		this.classementEtape = new ArrayList<HashMap.Entry<Inscription, Float>>();
		listeSpeciale = new ArrayList<Speciale>();
	}

	public int getNumEtapeT() {
		return this.numEtape;
	}

	public void setTempsLimite(int tempsLimiteH, int tempsLimiteM, float tempsLimiteS) {
		this.tempsLimiteEtape = tempsLimiteH * 3600 + tempsLimiteM * 60 + tempsLimiteS;
	}

	public float tempsToFloat(int tempsLimiteH, int tempsLimiteM, float tempsLimiteS) {
		return tempsLimiteH * 3600 + tempsLimiteM * 60 + tempsLimiteS;
	}

	public String getStringTempsLimite(float temps) {
		String s = new String();
		s += (int) (temps / 3600) + "H " + (int) (temps % 3600 / 60) + "'";
		s += (float) (Math.round(temps % 3600 % 60 * 100)) / 100;
		return s;
	}

	public String getStringTempsLimite() {
		String s = new String();
		s += (int) (tempsLimiteEtape / 3600) + "H " + (int) (tempsLimiteEtape % 3600 / 60) + "'";
		s += (float) (Math.round(tempsLimiteEtape % 3600 % 60 * 100)) / 100;
		return s;
	}

	//
	public int getHeure() {
		return (int) (tempsLimiteEtape / 3600);
	}

	public int getMinute() {
		return (int) (tempsLimiteEtape % 3600 / 60);
	}

	public float getSeconde() {
		return (float) (Math.round(tempsLimiteEtape % 3600 % 60 * 100)) / 100;
	}

	//

	public float getTempsLimiteEtape() {
		return tempsLimiteEtape;
	}

	public void setTempsLimiteEtape(int tempsLimiteEtape) {
		this.tempsLimiteEtape = tempsLimiteEtape;
	}

	public void setNumEtape(int numEtape) {
		this.numEtape = numEtape;
	}

	public void setMapInsEtape(HashMap<Inscription, Float> mapInsEtape) {
		this.mapInsEtape = mapInsEtape;
	}

	public void setClassementEtape(ArrayList<HashMap.Entry<Inscription, Float>> classementEtape) {
		this.classementEtape = classementEtape;
	}

	public void enregistreTemps(Inscription ins, int h, int m, float s) {
		float tempsE = tempsToFloat(h, m, s);
		// si le temps de coureur superieur a tempsLimiteEtape, ce coureur n'a pas de
		// classement
		if (tempsE > tempsLimiteEtape) {
			mapInsEtape.put(ins, null);
		} else {
			mapInsEtape.put(ins, tempsE);
		}
	}

	public HashMap<Inscription, Float> getMapInsEtape() {

		return this.mapInsEtape;
	}

//	// methode pour calculer le classement de l'etape sans speciale
//	public abstract ArrayList<Entry<Inscription, Integer>> classementpointEtape();
//	public abstract ArrayList<Entry<Inscription, Float>> classementEtape(); 
//	

}
