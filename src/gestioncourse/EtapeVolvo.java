package gestioncourse;

import gestioninscription.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EtapeVolvo extends Etape {

	protected HashMap<Inscription, Float> mapInsEtapeVolvo;
	protected ArrayList<HashMap.Entry<Inscription, Float>> classementEtapeVolvo;
	protected HashMap<Coureur, Integer> mapPointsEtapeVolvo;
	protected String nomPort;
	protected ArrayList<HashMap.Entry<Coureur, Integer>> classementPointVolvo;

	public EtapeVolvo(int numEtape, int tempsLimiteH, int tempsLimiteM, float tempsLimiteS, String nomPort) {
		super(numEtape, tempsLimiteH, tempsLimiteM, tempsLimiteS);
		this.nomPort = nomPort;
		this.mapInsEtapeVolvo = new HashMap<Inscription, Float>();
		this.classementEtapeVolvo = new ArrayList<HashMap.Entry<Inscription, Float>>();
		this.mapPointsEtapeVolvo = new HashMap<Coureur, Integer>();
		this.classementPointVolvo = new ArrayList<HashMap.Entry<Coureur, Integer>>();

	}

	public HashMap<Inscription, Float> getMapInsEtapeVolvo() {
		return mapInsEtapeVolvo;
	}

	public ArrayList<HashMap.Entry<Inscription, Float>> getClassementEtapeVolvo() {
		return classementEtapeVolvo;
	}

	public HashMap<Coureur, Integer> getClassementPointsEtapeVolvo() {
		return mapPointsEtapeVolvo;
	}

	public void enregistreTemps(Inscription ins, float temps) {
		if (temps > this.tempsLimiteEtape) {
			mapInsEtapeVolvo.put(ins, null);
		} else {
			mapInsEtapeVolvo.put(ins, temps);
		}
	};

	public void classementTemps() {
		for (HashMap.Entry<Inscription, Float> entry : mapInsEtapeVolvo.entrySet()) {
			if (entry.getValue() != null) {
				float tempsverifie = entry.getValue();
				tempsverifie = (float) (tempsverifie * entry.getKey().getVehicule().calculerAvecCoef());
				entry.setValue(tempsverifie);
			} else {
				entry.setValue(-1f);
			}
		}

		Set<HashMap.Entry<Inscription, Float>> entrySet = mapInsEtapeVolvo.entrySet();
		classementEtapeVolvo = new ArrayList<HashMap.Entry<Inscription, Float>>(entrySet);
		Collections.sort(classementEtapeVolvo, new Comparator<HashMap.Entry<Inscription, Float>>() {
			// @Override
			public int compare(HashMap.Entry<Inscription, Float> c1, HashMap.Entry<Inscription, Float> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});

	}

	protected int corespPoint(int classement) {
		int point;
		switch (classement) {
		case 0:
			point = 7;
			break;
		case 1:
			point = 6;
			break;
		case 2:
			point = 5;
			break;
		case 3:
			point = 4;
			break;
		case 4:
			point = 3;
			break;
		case 5:
			point = 2;
			break;
		case 6:
			point = 1;
			break;
		default:
			point = 0;
			break;
		}
		return point;
	}

	public HashMap<Coureur, Integer> listePointsVolvo() {
		int total = this.classementEtapeVolvo.size();
		int nbr = Math.min(total, 9);
		for (int i = 0; i < nbr; i++) {
			int point;
			if (classementEtapeVolvo.get(i).getValue() == -1f) {
				point = 0;
			} else {
				point = corespPoint(i);
			}
			mapPointsEtapeVolvo.put(this.getClassementEtapeVolvo().get(i).getKey().getCoureur(), point);
		}

		return mapPointsEtapeVolvo;
	};

	public ArrayList<HashMap.Entry<Coureur, Integer>> classementPoint() {
		Set<HashMap.Entry<Coureur, Integer>> entrySet = mapPointsEtapeVolvo.entrySet();
		classementPointVolvo = new ArrayList<HashMap.Entry<Coureur, Integer>>(entrySet);
		Collections.sort(classementPointVolvo, new Comparator<HashMap.Entry<Coureur, Integer>>() {
			// @Override
			public int compare(HashMap.Entry<Coureur, Integer> c1, HashMap.Entry<Coureur, Integer> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
		return classementPointVolvo;
	}

	public ArrayList<String> affichierClassementPoint() {
		ArrayList<String> liste = new ArrayList<String>();
		for (int i = 0; i < classementPointVolvo.size(); i++) {
			liste.add(classementPointVolvo.get(i).getKey().getNomCoureur() + "-"
					+ classementPointVolvo.get(i).getValue());
		}
		Collections.reverse(liste);
		return liste;
	}

}
