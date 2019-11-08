package gestioncourse;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import gestioninscription.Coureur;
import gestioninscription.Inscription;

public class EditionVolvo extends Edition {
	private ArrayList<EtapeMer> listeEtapeMer;
	private HashMap<Coureur, Float> pointEditionVolvoMer;
	private HashMap<Coureur, Float> pointEditionVolvoPort;
	private ArrayList<HashMap.Entry<Coureur, Float>> classementPointFinal;

	public EditionVolvo(int numEdition, String dateDeb, String dateFin, String annee) {
		super(numEdition, dateDeb, dateFin, annee);
		this.pointEditionVolvoMer = new HashMap<Coureur, Float>();
		this.pointEditionVolvoPort = new HashMap<Coureur, Float>();
		this.listeEtapeMer = new ArrayList<EtapeMer>();
		this.classementPointFinal = new ArrayList<HashMap.Entry<Coureur, Float>>();
	}

	public ArrayList<Etape> getLstEtape() {
		return this.listeEtapeT;

	}

	public void ajouterEtape(EtapeVolvo e) {
		this.listeEtapeT.add(e);
	}

	@Override
	public void ajouterInscrip(Inscription i) {
		this.listeInscrip.add(i);
	}

	public void ajouterEtapeMer(EtapeMer eMer) {
		listeEtapeMer.add(eMer);
	}

	public void pointsEtapeMeretPort() {
		for (int i = 0; i < listeInscrip.size(); i++) {
			Coureur c = listeInscrip.get(i).getCoureur();
			float pointCoureurMer = 0;
			float pointCoureurPort = 0;
			for (int j = 0; j < listeEtapeMer.size(); j++) {
				EtapeMer eMer = (EtapeMer) listeEtapeMer.get(j);
				pointCoureurMer += eMer.listePointsVolvoMer().get(c);
			}
			for (int m = 0; m < listeEtapeT.size(); m++) {
				EtapeVolvo ePort = (EtapeVolvo) listeEtapeT.get(m);
				pointCoureurPort += ePort.listePointsVolvo().get(c);
			}
			pointEditionVolvoMer.put(c, pointCoureurMer);
			pointEditionVolvoPort.put(c, pointCoureurPort);
		}
	}

	public void pointEstMeme() {
		for (Entry<Coureur, Float> entry1 : pointEditionVolvoMer.entrySet()) {
			for (Entry<Coureur, Float> entry2 : pointEditionVolvoMer.entrySet()) {
				if (entry1.getKey() != entry2.getKey() && entry1.getValue() == entry2.getValue()) {
					float pointMer1 = entry1.getValue();
					float pointMer2 = entry2.getValue();
					float pointPort1 = pointEditionVolvoPort.get(entry1.getKey());
					float pointPort2 = pointEditionVolvoPort.get(entry2.getKey());
					if (pointPort1 > pointPort2) {
						pointMer1 = pointMer1 + 0.1f;
						pointEditionVolvoMer.replace(entry1.getKey(), pointMer1);
					} else {
						pointMer2 = pointMer2 + 0.1f;
						pointEditionVolvoMer.replace(entry2.getKey(), pointMer2);
					}
				}
			}
		}
	}

	public void classementVolvo() {
		Set<HashMap.Entry<Coureur, Float>> entrySet = pointEditionVolvoMer.entrySet();
		classementPointFinal = new ArrayList<HashMap.Entry<Coureur, Float>>(entrySet);
		Collections.sort(classementPointFinal, new Comparator<HashMap.Entry<Coureur, Float>>() {
			// @Override
			public int compare(HashMap.Entry<Coureur, Float> c1, HashMap.Entry<Coureur, Float> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
	}

	public ArrayList<String> afficherClassementEidtionVolvo() {
		ArrayList<String> liste = new ArrayList<String>();
		for (int i = 0; i < classementPointFinal.size(); i++) {
			liste.add(classementPointFinal.get(i).getKey().getNomCoureur() + "-"
					+ classementPointFinal.get(i).getValue());
		}
		Collections.reverse(liste);
		return liste;
	}

	@Override
	public void classementEdition() {
		// TODO Auto-generated method stub

	}

}
