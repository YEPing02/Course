package gestioninscription;

public class Coureur {
	private int numCoureur;
	private String nomCoureur;
	private String prenomCoureur;
	private String dateNais;
	private String groupeSang;

	public Coureur(int numCoureur, String nomCoureur, String prenomCoureur, String dateNais, String groupeSang) {
		this.numCoureur = numCoureur;
		this.nomCoureur = nomCoureur;
		this.prenomCoureur = prenomCoureur;
		this.groupeSang = groupeSang;
	}

	public int getNumCoureur() {
		return numCoureur;
	}

	public void setNumCoureur(int numCoureur) {
		this.numCoureur = numCoureur;
	}

	public String getNomCoureur() {
		return nomCoureur;
	}

	public void setNomCoureur(String nomCoureur) {
		this.nomCoureur = nomCoureur;
	}

	public String getPrenomCoureur() {
		return prenomCoureur;
	}

	public void setPrenomCoureur(String prenomCoureur) {
		this.prenomCoureur = prenomCoureur;
	}

	public String getDateNais() {
		return dateNais;
	}

	public void setDateNais(String dateNais) {
		this.dateNais = dateNais;
	}

	public String getGroupeSang() {
		return groupeSang;
	}

	public void setGroupeSang(String groupeSang) {
		this.groupeSang = groupeSang;
	}

}
