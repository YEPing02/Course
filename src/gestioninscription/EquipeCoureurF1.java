package gestioninscription;

import java.util.ArrayList;

public class EquipeCoureurF1 {
	private String nomEquipe;
	private ArrayList<Coureur> listeCoureurEquipe;

	public EquipeCoureurF1(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public void ajouterCoureur(Coureur c) {
		listeCoureurEquipe.add(c);
	}

}
