package gestioncourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

import gestioninscription.Coureur;
import gestioninscription.Inscription;

public class EditionRallye extends Edition {
	private String villeR;
	private String paysR;
	private ArrayList<EtapeRallye> listeEtape;
	private HashMap<Inscription, Float> mapInsEdition;
	private ArrayList<HashMap.Entry<Inscription, Float>> classementGeneral;
	private ArrayList<HashMap.Entry<Coureur, Integer>> points;
//	

	public void setListeEtapeR(ArrayList<EtapeRallye> listeEtape) {
		this.listeEtape = listeEtape;
	}

	public ArrayList<HashMap.Entry<Coureur, Integer>> getPoints() {
		return points;
	}

	public EditionRallye(int numEdition, String dateDeb, String dateFin, String annee, String villeR, String paysR) {
		super(numEdition, dateDeb, dateFin, annee);
		this.villeR = villeR;
		this.paysR = paysR;
		this.listeEtape = new ArrayList<EtapeRallye>();
		this.mapInsEdition = new HashMap<Inscription, Float>();
		// this.classementGeneral =new ArrayList<HashMap.Entry<Inscription,Float>>();
		this.setPoints(new ArrayList<HashMap.Entry<Coureur, Integer>>());
	}

	public EditionRallye(int numEdition, String dateDeb, String dateFin, String annee) {
		super(numEdition, dateDeb, dateFin, annee);
		this.mapInsEdition = new HashMap<Inscription, Float>();

		this.listeEtape = new ArrayList<EtapeRallye>();
		// this.classementGeneral =new ArrayList<HashMap.Entry<Inscription,Float>>();
		this.setPoints(new ArrayList<HashMap.Entry<Coureur, Integer>>());
	}

	public void ajouterEtape(EtapeRallye e) {
		this.listeEtape.add(e);
	}

	@Override
	public void ajouterInscrip(Inscription i) {
		this.listeInscrip.add(i);
	}

	public String getVilleR() {
		return villeR;
	}

	public void setVilleR(String villeR) {
		this.villeR = villeR;
	}

	public String getPaysR() {
		return paysR;
	}

	public void setPaysR(String paysR) {
		this.paysR = paysR;
	}

	public ArrayList<HashMap.Entry<Inscription, Float>> getClassementGeneralFloat() {
		classementEdition();
		return this.classementGeneral;
	}

	public void organiserEdition() {
		for (Inscription ins : listeInscrip) {
			this.mapInsEdition.put(ins, null);
		}
	}

	public void classementEdition() {
		for (Inscription ins : this.mapInsEdition.keySet()) {
			float tempsEdition = 0;
			for (int i = 0; i < listeEtape.size(); i++) {
				EtapeRallye e1 = (EtapeRallye) listeEtape.get(i);
				e1.classementEtape();
				tempsEdition += (e1.getMapInsEtape().get(ins));
			}
			this.mapInsEdition.put(ins, tempsEdition);
		}

		Set<HashMap.Entry<Inscription, Float>> entrySet = mapInsEdition.entrySet();
		classementGeneral = new ArrayList<HashMap.Entry<Inscription, Float>>(entrySet);
		Collections.sort(classementGeneral, new Comparator<HashMap.Entry<Inscription, Float>>() {
			// @Override
			public int compare(HashMap.Entry<Inscription, Float> c1, HashMap.Entry<Inscription, Float> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
		if ((this.etatEdition) == EtatEdition.insTerminee) {
			this.setTempsFinal();
		}
	}

	public void setTempsFinal() {
		for (int i = 0; i < classementGeneral.size(); i++) {
			float temps = classementGeneral.get(i).getValue();
			int position = i + 1;
			classementGeneral.get(i).getKey().setTempsFinal(temps);
			classementGeneral.get(i).getKey().setPosition(position);
			int point = 0;
			switch (position) {
			case 1:
				point = 10;
				break;
			case 2:
				point = 8;
				break;
			case 3:
				point = 6;
				break;
			case 4:
				point = 5;
				break;
			case 5:
				point = 4;
				break;
			case 6:
				point = 3;
				break;
			case 7:
				point = 2;
				break;
			case 8:
				point = 1;
				break;
			default:
				point = 0;
				break;
			}
			classementGeneral.get(i).getKey().setPoint(point);

		}

	}

	public String getAnnee() {
		return annee;
	}

	public EtatEdition getEtatEdition() {
		return etatEdition;
	}

	public ArrayList<Inscription> getListeInscrip() {
		return listeInscrip;
	}

	@Override
	public Etape getEtapeT(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public EtapeRallye getEtape(int i) {
		return listeEtape.get(i);
	}

	public ArrayList<EtapeRallye> getLstEtape() {
		return listeEtape;
	}

	public ArrayList<HashMap.Entry<Coureur, Integer>> arrayEditionPointCoureur() {
		return points;
	}

	public void setPoints(ArrayList<HashMap.Entry<Coureur, Integer>> points) {
		this.points = points;
	}

}
