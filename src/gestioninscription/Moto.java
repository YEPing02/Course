package gestioninscription;

public class Moto extends VehiculeRallye {
	private int cylindree;

	public Moto(String immatriculation,int cylindree) {
		super(immatriculation, coef);
		this.cylindree = cylindree;		
	}
	
	@Override
	public double calculerAvecCoef() {
		int standard = 500;
		int difference = 0;
		int mod=0;
		double res = 0.00;
		if(cylindree>standard) {
			difference = cylindree-standard;
			mod = difference/25;
			res = coef*(1+mod*0.25);
		}else {
			res = coef;
		}
		return res;
	}

}
