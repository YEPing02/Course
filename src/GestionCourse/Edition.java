package GestionCourse;
import java.util.ArrayList;

import GestionInscription.Inscription;

public class Edition {
	private int numEdition;
	private String dateFin;
	private String annee;
	private String dateDeb;
	private EtatEdition etatEdition;
	private ArrayList<Etape> listeEtape;
	private ArrayList<Inscription> listeInscrip;

	
	public ArrayList<Inscription> classementEdition(){
		return null;
	}
	public void ajouterEtape(Etape e) {
		this.listeEtape.add(e);
	}
	public void ajouterInscrip(Inscription i) {
		this.listeInscrip.add(i);
	}
}
