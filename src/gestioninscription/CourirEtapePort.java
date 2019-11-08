package gestioninscription;

public class CourirEtapePort {
	private float tempsPort;

	public CourirEtapePort(int tempsPortM, float tempsPortS) {
		this.tempsPort = (float) (tempsPortM * 60 + tempsPortS);
	}

	public float getTempsPort() {
		return this.tempsPort;
	}

}
