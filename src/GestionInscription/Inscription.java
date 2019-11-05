package GestionInscription;

public class Inscription {
	private int numInscrip;
	private String dateInscrip;
	private EtatInscription etatInscription;
	
	private Coureur coureur;
	private Vehicule vehicule;
	
	
	
	
	
	
	public void validerInscrip() {
		this.etatInscription=EtatInscription.validee;
	}
	public void modifierInscripInscrip() {
		
	}
	public void annulerInscrip() {
		this.etatInscription=EtatInscription.annulee;
	}

}
