package gestioninscription;

public class VehiculeVoilier extends Vehicule {

	public VehiculeVoilier(String immatriculation) {
		super(immatriculation, coef);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float calculerAvecCoef() {
		return coef;
	}

}
