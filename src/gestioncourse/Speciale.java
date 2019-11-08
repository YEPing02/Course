package gestioncourse;

import gestioninscription.*;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Speciale {
	private int numSpeciale;
	private float tempsLimiteSpeciale;
	private HashMap<Inscription, Float> mapInsSpeciale;
	private ArrayList<HashMap.Entry<Inscription, Float>> classementSpeciale;

	public Speciale(int numSpeciale, int tempsLimiteH, int tempsLimiteM, float tempsLimiteS) {
		this.setNumSpeciale(numSpeciale);
		this.tempsLimiteSpeciale = (float) (tempsLimiteH * 3600 + tempsLimiteM * 60 + tempsLimiteS);
		this.mapInsSpeciale = new HashMap<Inscription, Float>();
		this.classementSpeciale = new ArrayList<HashMap.Entry<Inscription, Float>>();
	}

	public String getStringTempsLimite() {
		String s = new String();
		s += (int) (tempsLimiteSpeciale / 3600) + "H " + (int) (tempsLimiteSpeciale % 3600 / 60) + "'";
		s += (float) (Math.round(tempsLimiteSpeciale % 3600 % 60 * 100)) / 100;
		return s;
	}

	public HashMap<Inscription, Float> getMapInsSpeciale() {
		return this.mapInsSpeciale;
	}

	public ArrayList<HashMap.Entry<Inscription, Float>> getClassementSpeciale() {
		return this.classementSpeciale;
	}

	public void enregistrerTempsLimite(int tempsLimiteH, int tempsLimiteM, float tempsLimiteS) {
		this.tempsLimiteSpeciale = tempsLimiteH * 3600 + tempsLimiteM * 60 + tempsLimiteS;
	}

	public void enregistreTemps(Inscription ins, float tempsS) {
		// si le temps de coureur superieur a tempsLimiteSpeciale, ce coureur n'a pas de
		// classement
		if (tempsS > tempsLimiteSpeciale) {
			mapInsSpeciale.put(ins, null);
		} else {
			mapInsSpeciale.put(ins, tempsS);
		}
	}

	// methode pour calculer le classement de l'etape sans speciale
	public void classementSpeciale() {
		for (HashMap.Entry<Inscription, Float> entry : mapInsSpeciale.entrySet()) {
			if (entry.getValue() != null) {
				float tempsverifie = entry.getValue();
				tempsverifie = (float) (tempsverifie * entry.getKey().getVehicule().calculerAvecCoef());
				entry.setValue(tempsverifie);
			} else {
				mapInsSpeciale.remove(entry.getKey());
			}
		}

		Set<HashMap.Entry<Inscription, Float>> entrySet = mapInsSpeciale.entrySet();
		classementSpeciale = new ArrayList<HashMap.Entry<Inscription, Float>>(entrySet);
		Collections.sort(classementSpeciale, new Comparator<HashMap.Entry<Inscription, Float>>() {
			// @Override
			public int compare(HashMap.Entry<Inscription, Float> c1, HashMap.Entry<Inscription, Float> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
	}

	public int getNumSpeciale() {
		return numSpeciale;
	}

	public void setNumSpeciale(int numSpeciale) {
		this.numSpeciale = numSpeciale;
	}

	public int getHeure() {
		return (int) (tempsLimiteSpeciale / 3600);
	}

	public int getMinute() {
		return (int) (tempsLimiteSpeciale % 3600 / 60);
	}

	public float getSeconde() {
		return (float) (Math.round(tempsLimiteSpeciale % 3600 % 60 * 100)) / 100;
	}

}
