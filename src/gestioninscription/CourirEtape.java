package gestioninscription;

public class CourirEtape {
	private int tempsEatpe;

	public CourirEtape(int tempsEtapeH, int tempsEtapeM, int tempsEtapeS) {
		this.tempsEatpe = (tempsEtapeH * 3600) + tempsEtapeM * 60 + tempsEtapeS;
		// this.etatQualifie = etatQualifie =true;

	}

	/*
	 * public boolean estQualifie() { return this.etatQualifie; }
	 */

	public int getTempsEtape() {
		return this.tempsEatpe;
	}

}
