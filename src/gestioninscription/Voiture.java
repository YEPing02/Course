package gestioninscription;

public class Voiture extends VehiculeRallye {
	private int puissance;

	public Voiture(String immatriculation,int puissance) {
		super(immatriculation, coef);
		this.puissance = puissance;
	}
	
	@Override
	public double calculerAvecCoef() {
		int standard = 300;
		int difference = 0;
		int mod=0;
		double res = 0.00;
		if(puissance>standard) {
			difference = puissance-standard;
			res = coef+(difference*0.05);
		}else if (puissance<20) {
			difference =standard-puissance;
			res= coef-(difference*0.05);
		}else {
			res = coef;
		}
		return res;
	}

}
