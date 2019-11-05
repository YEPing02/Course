package gestioninscription;

public class Camion extends VehiculeRallye {
	private int poids;

	public Camion(String immatriculation, int poids) {
		super(immatriculation, coef);
		this.poids = poids;
	}
	
	@Override
	public double calculerAvecCoef() {
		int standard = 2000;
		int difference = 0;
		int mod=0;
		double res = 0.00;
		if(poids>standard) {
			difference = poids-standard;
			mod = difference/100;
			res = coef*(1+mod*0.1);
		}else {
			res = coef;
		}
		return res;
	}

}
