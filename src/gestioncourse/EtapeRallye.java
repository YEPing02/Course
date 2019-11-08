package gestioncourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import gestioninscription.Inscription;

public class EtapeRallye extends Etape {

	public EtapeRallye(int numEtape) {
		super(numEtape, 9999, 9999, 9999);
	}

	public int getNumEtape() {
		return numEtape;
	}

	public void setListeSeciale(ArrayList<Speciale> listeSeciale) {
		this.listeSpeciale = listeSeciale;
	}

	public Speciale getSpeciale(int i) {
		return listeSpeciale.get(i);
	}

	public void enregistreTemps(Inscription ins) {
		this.mapInsEtape.put(ins, 99999999999f);
	}

	public ArrayList<HashMap.Entry<Inscription, Float>> getClassementEtape() {
		this.classementEtape();
		return this.classementEtape;
	}

	public ArrayList<Entry<Inscription, Float>> classementEtape() {
		for (Inscription ins : this.mapInsEtape.keySet()) {
			float tempsEtapeS = 0;
			for (int i = 0; i < listeSpeciale.size(); i++) {
				listeSpeciale.get(i).classementSpeciale();
				tempsEtapeS += (listeSpeciale.get(i).getMapInsSpeciale().get(ins));
				System.out.println(tempsEtapeS);
			}
			this.mapInsEtape.put(ins, tempsEtapeS);
		}
		Set<HashMap.Entry<Inscription, Float>> entrySet = mapInsEtape.entrySet();
		classementEtape = new ArrayList<HashMap.Entry<Inscription, Float>>(entrySet);
		Collections.sort(classementEtape, new Comparator<HashMap.Entry<Inscription, Float>>() {
			// @Override
			public int compare(HashMap.Entry<Inscription, Float> c1, HashMap.Entry<Inscription, Float> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
		return classementEtape;
	}

	public EtapeRallye(int numEtape, int tempsLimiteH, int tempsLimiteM, Float float1) {
		super(numEtape, tempsLimiteH, tempsLimiteM, float1);

		this.listeSpeciale = new ArrayList<Speciale>();
	}

	public ArrayList<Speciale> getListeSpeciale() {
		return listeSpeciale;
	}

	public void ajouterSpeciale(Speciale s) {
		this.listeSpeciale.add(s);
	}

}
