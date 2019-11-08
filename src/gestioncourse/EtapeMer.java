package gestioncourse;

import java.util.HashMap;
import java.util.Map.Entry;

import gestioninscription.Coureur;
import gestioninscription.Inscription;

public class EtapeMer extends EtapeVolvo {

	private float distencemin;
	private int difficulte;

	public EtapeMer(int numEtape, int tempsLimiteH, int tempsLimiteM, float tempsLimiteS, String nomMer,
			float distancemin, int difficulte) {
		super(numEtape, tempsLimiteH, tempsLimiteM, tempsLimiteS, nomMer);
		this.distencemin = distancemin;
		this.difficulte = difficulte;
	}

	public void enregistreTempsMer(Inscription ins, float jour, float distance) {
		if (distance < this.distencemin) {
			mapInsEtapeVolvo.put(ins, null);
		} else {
			mapInsEtapeVolvo.put(ins, jour);
		}
	};

	public HashMap<Coureur, Integer> listePointsVolvoMer() {
		if (this.difficulte == 1) {
			return super.listePointsVolvo();
		} else {
			HashMap<Coureur, Integer> doublepoints = super.listePointsVolvo();
			for (Entry<Coureur, Integer> entry : doublepoints.entrySet()) {
				int pointplus = entry.getValue();
				doublepoints.put(entry.getKey(), pointplus * 2);
			}
			return doublepoints;
		}
	};

}
