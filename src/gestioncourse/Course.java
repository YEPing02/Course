package gestioncourse;

import java.util.*;

public abstract class Course {
	protected int numCourse;
	protected String nomCourse;
	protected ArrayList<Edition> listeEdition;

	// BD
	protected int idC;
	protected Set<Edition> lstEdition; // sert à utilisé par hibernate

	public Set<Edition> getLstEdition() {
		return lstEdition;
	}

	//
	public Course(int numCourse, String nomCourse) {
		this.nomCourse = nomCourse;
		this.lstEdition = new HashSet<Edition>();
		this.listeEdition = new ArrayList<Edition>(lstEdition);

	}

	public String getNomCourse() {
		return nomCourse;
	}

	public void setNomCourse(String nomCourse) {
		this.nomCourse = nomCourse;
	}

	public ArrayList<Edition> getListeEdition() {
		return listeEdition;
	}

	public Edition getEdition(int i) {
		return listeEdition.get(i);
	}

	public void setListeEdition(ArrayList<Edition> listeEdition) {
		this.listeEdition = listeEdition;
		// BD
		this.lstEdition = new HashSet<Edition>(lstEdition);
	}

	public void ajouterEditon(Edition ed) {
		this.listeEdition.add(ed);
		// BD
		this.lstEdition.add(ed);
	}

}
