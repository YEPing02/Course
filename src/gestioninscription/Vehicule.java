package gestioninscription;

public abstract class Vehicule {
	protected String immatriculation;
	protected static float coef = 1;

	public Vehicule(String immatriculation, float coef) {
		this.immatriculation = immatriculation;
		this.coef = coef;
	}

	public Vehicule(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public abstract float calculerAvecCoef();

}
