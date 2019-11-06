package gestioncourse;
import java.util.ArrayList;

public class EtapeRallye extends Etape{

	private ArrayList<Speciale> listeSpeciale;
	
	public EtapeRallye(int numEtape, int tempsLimiteH, int tempsLimiteM, Float float1) {
		super(numEtape, tempsLimiteH, tempsLimiteM, float1);

this.listeSpeciale=new ArrayList<Speciale>();
	}

	public ArrayList<Speciale> getListeSpeciale() {
		return listeSpeciale;
	}

	public void setListeSeciale(ArrayList<Speciale> listeSeciale) {
		this.listeSpeciale = listeSeciale;
	}
	
	public void ajouterSpeciale(Speciale s) {
		this.listeSpeciale.add(s);
	}
	
	public Speciale getSpeciale(int i) {
		return listeSpeciale.get(i);
	}
	
	
}
