package gestioncourse;
import gestioninscription.Inscription;

public class CourirSpeciale {
	private double tempsSpeciale; 
	private boolean etatQualifieS;

	private Inscription inscription;
	private Speciale speciale;
	
	public boolean estQualifieS() {
		return this.etatQualifieS;
	}
}

