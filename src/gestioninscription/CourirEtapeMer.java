package gestioninscription;

public class CourirEtapeMer {
	private float distance;
	private float tempsMer;

	public CourirEtapeMer(float distance, int tempsMerJour, int tempsMerH) {
		this.distance = distance;
		this.tempsMer = (float) (tempsMerJour + (float) tempsMerH / 24);
	}

	public float getDistance() {
		return this.distance;
	}

	public float getTempsMer() {
		return this.tempsMer;
	}

}
