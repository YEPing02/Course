package gestioncourse;

import gestioninscription.*;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Edition {
	protected int numEdition;
	protected String dateFin;
	protected String annee;
	protected String dateDeb;
	protected EtatEdition etatEdition;
	protected ArrayList<Etape> listeEtapeT;
	protected ArrayList<Inscription> listeInscrip;
	protected HashMap<Inscription, Integer> mapInsEdition;
	protected ArrayList<HashMap.Entry<Inscription, Integer>> classementGeneral;

	public Edition(int numEdition, String dateDeb, String dateFin, String annee) {
		this.numEdition = numEdition;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.annee = annee;
		this.etatEdition = EtatEdition.insOuverte;
		this.listeEtapeT = new ArrayList<Etape>();
		this.listeInscrip = new ArrayList<Inscription>();
		this.mapInsEdition = new HashMap<Inscription, Integer>();
		this.classementGeneral = new ArrayList<HashMap.Entry<Inscription, Integer>>();
	}

	public Etape getEtapeT(int i) {
		return this.listeEtapeT.get(i);
	};

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

	public ArrayList<Etape> getListeEtapeT() {
		return listeEtapeT;
	}

	public void setListeEtape(ArrayList<Etape> listeEtape) {
		this.listeEtapeT = listeEtape;
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
		this.classementGeneral = new ArrayList<HashMap.Entry<Inscription, Integer>>();
		classementEdition();
		return classementGeneral;
	}

	public void setClassementGeneral(ArrayList<HashMap.Entry<Inscription, Integer>> classementGeneral) {
		this.classementGeneral = classementGeneral;
	}

	public void ajouterEtape(Etape e) {
		this.listeEtapeT.add(e);
	}

	public void ajouterInscrip(Inscription i) {
		this.listeInscrip.add(i);
		this.mapInsEdition.put(i, 0);
	}

	public void organiserEdition() {
		for (Inscription ins : listeInscrip) {
			this.mapInsEdition.put(ins, null);
		}
	}

	public abstract void classementEdition();

	public ArrayList<HashMap.Entry<Inscription, Integer>> getClassement() {
		classementEdition();
		return this.classementGeneral;
	}

}
