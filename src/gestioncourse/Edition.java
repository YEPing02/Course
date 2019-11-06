package gestioncourse;

import gestioninscription.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public abstract class Edition {
	private int numEdition;
	private String dateFin;
	private String annee;
	private String dateDeb;
	private EtatEdition etatEdition;
	private ArrayList<Etape> listeEtape;
	private ArrayList<Inscription> listeInscrip;
	private HashMap<Inscription, Integer> mapInsEdition;
	private ArrayList<HashMap.Entry<Inscription, Integer>> classementGeneral;

	public Edition(int numEdition, String dateDeb, String dateFin, String annee) {
		this.numEdition = numEdition;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.annee = annee;
		this.etatEdition = EtatEdition.insOuverte;
		this.listeEtape = new ArrayList<Etape>();
		this.listeInscrip = new ArrayList<Inscription>();
		this.mapInsEdition = new HashMap<Inscription, Integer>();
		this.classementGeneral = new ArrayList<HashMap.Entry<Inscription, Integer>>();
	}

	public int getNumEdition() {
		return numEdition;
	}

	public void setNumEdition(int numEdition) {
		this.numEdition = numEdition;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(String dateDeb) {
		this.dateDeb = dateDeb;
	}

	public EtatEdition getEtatEdition() {
		return etatEdition;
	}

	public void setEtatEdition(EtatEdition etatEdition) {
		this.etatEdition = etatEdition;
	}

	public ArrayList<Etape> getListeEtape() {
		return listeEtape;
	}

	public Etape getEtape(int i) {
		return listeEtape.get(i);
	}

	public void setListeEtape(ArrayList<Etape> listeEtape) {
		this.listeEtape = listeEtape;
	}

	public ArrayList<Inscription> getListeInscrip() {
		return listeInscrip;
	}

	public void setListeInscrip(ArrayList<Inscription> listeInscrip) {
		this.listeInscrip = listeInscrip;
	}

	public HashMap<Inscription, Integer> getMapInsEdition() {
		return mapInsEdition;
	}

	public void setMapInsEdition(HashMap<Inscription, Integer> mapInsEdition) {
		this.mapInsEdition = mapInsEdition;
	}

	public ArrayList<HashMap.Entry<Inscription, Integer>> getClassementGeneral() {
		return classementGeneral;
	}

	public void setClassementGeneral(ArrayList<HashMap.Entry<Inscription, Integer>> classementGeneral) {
		this.classementGeneral = classementGeneral;
	}

	public void ajouterEtape(Etape e) {
		this.listeEtape.add(e);
	}

	public void ajouterInscrip(Inscription i) {
		this.listeInscrip.add(i);
	}

	public void organiserEdition() {
		for (Inscription ins : listeInscrip) {
			this.mapInsEdition.put(ins, null);
		}
	}

	public void classementEdition() {
		for (Inscription ins : this.mapInsEdition.keySet()) {
			int tempsEdition = 0;
			for (int i = 0; i < listeEtape.size(); i++) {
				listeEtape.get(i).classementEtape();
				tempsEdition += (listeEtape.get(i).getMapInsEtape().get(ins));
			}
			this.mapInsEdition.put(ins, tempsEdition);
		}

		Set<HashMap.Entry<Inscription, Integer>> entrySet = mapInsEdition.entrySet();
		classementGeneral = new ArrayList<HashMap.Entry<Inscription, Integer>>(entrySet);
		Collections.sort(classementGeneral, new Comparator<HashMap.Entry<Inscription, Integer>>() {
			// @Override
			public int compare(HashMap.Entry<Inscription, Integer> c1, HashMap.Entry<Inscription, Integer> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
	}

}
