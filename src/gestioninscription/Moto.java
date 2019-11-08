package gestioninscription;

public class Moto extends VehiculeRallye {
	private int cylindree;

	public Moto(String immatriculation, int cylindree) {
		super(immatriculation, coef);
		this.cylindree = cylindree;
	}

	@Override
	public float calculerAvecCoef() {
		int standard = 500;
		int difference = 0;
		int mod = 0;
		float res = 0.00f;
		if (cylindree > standard) {
			difference = cylindree - standard;
			mod = difference / 25;
			res = coef * (1 + mod * 0.25f);
		} else {
			res = coef;
		}
		return res;
	}

}
