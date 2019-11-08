package gestioninscription;

import gestioncourse.*;

public class Inscription {
	private int numInscrip;
	private Coureur coureur;
	private Edition edition;
	private EtatInscrip etatinscrip;
	private Vehicule vehicule;
	private float tempsFinal;
	private int point;
	private int position;

	public Inscription(int numInscrip, Coureur coureur, Edition edition, Vehicule vehicule) {
		this.numInscrip = numInscrip;
		this.coureur = coureur;
		this.edition = edition;
		this.vehicule = vehicule;

	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public float getTempsFinal() {
		return tempsFinal;
	}

	public void setTempsFinal(float tempsFinal) {
		this.tempsFinal = tempsFinal;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Coureur getCoureur() {
		return coureur;
	}

}
