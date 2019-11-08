package gestioncourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import gestioninscription.Inscription;

public class EtapeF1 extends Etape {
	private String ville;
	private String pays;

	public EtapeF1(int numEtape, int tempsLimiteH, int tempsLimiteM, float tempsLimiteS, String ville, String pays) {
		super(numEtape, tempsLimiteH, tempsLimiteM, tempsLimiteS);
		this.ville = ville;
		this.pays = pays;
		this.mapInsPoint = new HashMap<Inscription, Integer>();
	}

	public int getNumEtape() {
		return this.numEtape;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public ArrayList<HashMap.Entry<Inscription, Float>> getClassementEtape() {
		this.classementEtape();

		return classementEtape;
	}

	public ArrayList<HashMap.Entry<Inscription, Float>> classementEtape() {
		for (HashMap.Entry<Inscription, Float> entry : mapInsEtape.entrySet()) {
			if (entry.getValue() != null) {
				float tempsverifie = entry.getValue();
				tempsverifie = tempsverifie * entry.getKey().getVehicule().calculerAvecCoef();

				entry.setValue(tempsverifie);
			} else {
				mapInsEtape.remove(entry.getKey());
			}
		}
		Set<HashMap.Entry<Inscription, Float>> entrySet = mapInsEtape.entrySet();
		this.classementEtape = new ArrayList<HashMap.Entry<Inscription, Float>>(entrySet);
		Collections.sort(classementEtape, new Comparator<HashMap.Entry<Inscription, Float>>() {
			// @Override
			public int compare(HashMap.Entry<Inscription, Float> c1, HashMap.Entry<Inscription, Float> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
		setPoint(classementEtape);
		return classementEtape;
	}

	public void setPoint(ArrayList<HashMap.Entry<Inscription, Float>> classementEtape) {
		for (int i = 0; i < classementEtape.size(); i++) {
			int pointAjoute;
			switch (i) {
			case 0:
				pointAjoute = 24;
				break;
			case 1:
				pointAjoute = 18;
				break;
			case 2:
				pointAjoute = 15;
				break;
			case 3:
				pointAjoute = 12;
				break;
			case 4:
				pointAjoute = 10;
				break;
			case 5:
				pointAjoute = 8;
				break;
			case 6:
				pointAjoute = 6;
				break;
			case 7:
				pointAjoute = 4;
				break;
			case 8:
				pointAjoute = 2;
				break;
			case 9:
				pointAjoute = 1;
				break;
			default:
				pointAjoute = 0;
				break;
			}

			this.mapInsPoint.put(classementEtape.get(i).getKey(),
					mapInsPoint.get(classementEtape.get(i).getKey()) + pointAjoute);

		}

	}

	protected HashMap<Inscription, Integer> mapInsPoint; // liste des point

	@Override
	public void enregistreTemps(Inscription ins, int h, int m, float s) {
		float tempsE = tempsToFloat(h, m, s);
		// si le temps de coureur superieur a tempsLimiteEtape, ce coureur n'a pas de
		// classement
		if (tempsE > tempsLimiteEtape) {
			mapInsEtape.put(ins, null);
		} else {
			mapInsEtape.put(ins, tempsE);
			this.mapInsPoint.put(ins, 0);
		}
	}

	public ArrayList<HashMap.Entry<Inscription, Integer>> getlistInsPoint() {
		return new ArrayList<HashMap.Entry<Inscription, Integer>>(mapInsPoint.entrySet());
	}

	public void setMapInsPoint(HashMap<Inscription, Integer> mapInsPoint) {
		this.mapInsPoint = mapInsPoint;
	}

}
