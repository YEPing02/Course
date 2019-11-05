package gestioninscription;

public abstract class Vehicule {
	protected String immatriculation;
	protected static double coef = 1;
	
	public Vehicule(String immatriculation, double coef) {
		this.immatriculation = immatriculation;
		this.coef = coef;
	}
	
	public abstract double calculerAvecCoef();
	
	

}
