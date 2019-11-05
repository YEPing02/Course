package gestioncourse;
import java.util.ArrayList;

public abstract class Course {
	protected int numCourse;
	protected static int prochaineNum=0;
	protected String nomCourse;
	protected ArrayList<Edition> listeEdition;

	
	public Course(String nomCourse) {
		this.numCourse = prochaineNum;
		prochaineNum = prochaineNum++;
		this.nomCourse = nomCourse;
		this.listeEdition = new ArrayList<Edition>();	
		
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
	}
	

	public void ajouterEditon(Edition ed) {
		this.listeEdition.add(ed);
	}
	
	
}
