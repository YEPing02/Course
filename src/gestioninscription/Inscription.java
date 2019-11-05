package gestioninscription;
import gestioncourse.*;

public class Inscription {
	private int numInscrip;
	private Coureur coureur;
	private Edition edition;
	private EtatInscrip etatinscrip;
	private Vehicule vehicule;
	
	public Inscription (int numInscrip, Coureur coureur, Edition edition, Vehicule vehicule) {
		this.numInscrip = numInscrip;
		this.coureur = coureur;
		this.edition = edition;
		this.vehicule = vehicule;
		
	}
	
	public Vehicule getVehicule() {
		return this.vehicule;
	}
	
	
	

}
