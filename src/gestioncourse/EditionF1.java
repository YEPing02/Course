package gestioncourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

import gestioninscription.Inscription;

public class EditionF1 extends Edition {

	public EditionF1(int numEdition, String dateDeb, String dateFin, String annee) {
		super(numEdition, dateDeb, dateFin, annee);
	}

	public EtapeF1 getEtapeT(int i) {
		return (EtapeF1) listeEtapeT.get(i);
	}

	@Override
	public void classementEdition() {
		for (Inscription ins : this.mapInsEdition.keySet()) {
//			System.out.println(ins.getCoureur().getNomCoureur());
			this.mapInsEdition.put(ins, 0);
		}

		Set<HashMap.Entry<Inscription, Integer>> entrySet = mapInsEdition.entrySet();
		classementGeneral = new ArrayList<HashMap.Entry<Inscription, Integer>>(entrySet);

//		System.out.println(classementGeneral.get(0).getKey().getCoureur().getNomCoureur());

		affecterPoint();
		Collections.sort(classementGeneral, new Comparator<HashMap.Entry<Inscription, Integer>>() {
			// @Override
			public int compare(HashMap.Entry<Inscription, Integer> c1, HashMap.Entry<Inscription, Integer> c2) {
				return c2.getValue().compareTo(c1.getValue());
			}
		});
	}

	public void affecterPoint() {
		for (Etape et : listeEtapeT) {
			EtapeF1 etf = (EtapeF1) et;
			etf.classementEtape();
		}
		for (HashMap.Entry<Inscription, Integer> e : classementGeneral) {
			for (Etape et : listeEtapeT) {
				EtapeF1 etf = (EtapeF1) et;
				e.setValue(e.getValue() + etf.mapInsPoint.get(e.getKey()));
//				System.out.println(e.getValue());
			}
		}

	}

}
