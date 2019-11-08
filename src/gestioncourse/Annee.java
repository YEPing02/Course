package gestioncourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import gestioninscription.Constructeur;
import gestioninscription.Coureur;
import gestioninscription.EquipeCoureur;

public class Annee {
	// les hashMap qui sert au classement
	private HashMap<Coureur, Integer> resultatAnnuelCoureur = new HashMap<Coureur, Integer>();
//	    private HashMap<Constructeur, Integer> resultatAnnuelConstructeur = new HashMap<Constructeur, Integer>();
//	    private HashMap<EquipeCoureur, Integer> resultatAnnuelEquipe = new HashMap<EquipeCoureur, Integer>();
	private ArrayList<EditionRallye> rallyesAnnes = new ArrayList<EditionRallye>();
	private int annee;

	public Annee(int annee) {
		this.annee = annee;
	}

	public int getAnnee() {
		return this.annee;
	}

	public EditionRallye getRallye(int i) {
		return rallyesAnnes.get(i);
	}

	// méthode pour ajouter un rallye au liste
	public void setRallyesAnnes(EditionRallye e) {

		this.rallyesAnnes.add(e);

	}

	// méthode générer les résultat annuel du coureur selon les point
	private void setResultatAnnuelCoureur() {
		HashMap<Coureur, Integer> resultat = new HashMap<Coureur, Integer>();

		for (EditionRallye e : this.rallyesAnnes) {// parcourir chaque rallye de cette annee

			ArrayList<Entry<Coureur, Integer>> array = e.arrayEditionPointCoureur();

			for (Entry<Coureur, Integer> entry : array) {
				int nouveauPoint;
				if (resultat.containsKey(entry.getKey())) {
					nouveauPoint = resultat.get(entry.getKey()) + entry.getValue();
				} else {
					nouveauPoint = entry.getValue();
				}
				resultat.put(entry.getKey(), nouveauPoint);
			}
		}
		this.resultatAnnuelCoureur = resultat;
	}

	// méthode générer le classement annuel du coureur selon les point
	public ArrayList<Entry<Coureur, Integer>> classementAnnuelCoureur() {
		this.setResultatAnnuelCoureur();
		ArrayList<Entry<Coureur, Integer>> lstRes = new ArrayList<Entry<Coureur, Integer>>(
				this.resultatAnnuelCoureur.entrySet());
		for (int i = 0; i < lstRes.size() - 1; i++) {
			for (int j = i + 1; j < lstRes.size(); j++) {
				if (lstRes.get(i).getValue() < lstRes.get(j).getValue()) {
					Entry<Coureur, Integer> entry = lstRes.get(i);
					lstRes.set(i, lstRes.get(j));
					lstRes.set(j, entry);
				}
			}
		}
		return lstRes;
	}

	// méthode pour afficher le classement en String au console
	public String afficheClassementAnnuelCoureur() {
		String s = "No \t Prénom \t Nom \t Points";
		int i = 1;
		for (Entry<Coureur, Integer> e : this.classementAnnuelCoureur()) {
			s += "\n " + i + " \t" + e.getKey().getPrenomCoureur() + " \t" + e.getKey().getNomCoureur() + " \t"
					+ e.getValue();
			i++;
		}
		return s;
	}

	// méthode générer les résultat annuel du constrcuteur selon les point
//	    private void setResultatAnnuelConstructeur() {
//	        HashMap<Constructeur, Integer> resultat = new HashMap<Constructeur, Integer>();
//	        for (EditionRallye e : this.rallyesAnnes) {
//	            ArrayList<Entry<Constructeur, Integer>> array = e.arrayEditionPointConstructeur();
//	            for (Entry<Constructeur, Integer> entry : array) {
//	                int nouveauPoint;
//	                if (resultat.containsKey(entry.getKey())) {
//	                    nouveauPoint = resultat.get(entry.getKey()) + entry.getValue();
//	                } else {
//	                    nouveauPoint = entry.getValue();
//	                }
//	                resultat.put(entry.getKey(), nouveauPoint);
//	            }
//	        }
//	        this.resultatAnnuelConstructeur = resultat;
//	    }
//
//	    //méthode générer le classement annuel du constructeur
//	    public ArrayList<Entry<Constructeur, Integer>> classementAnnuelConstructeur() {
//	        this.setResultatAnnuelConstructeur();
//	        ArrayList<Entry<Constructeur, Integer>> lstRes = new ArrayList<Entry<Constructeur, Integer>>(this.resultatAnnuelConstructeur.entrySet());
//	        for (int i = 0; i < lstRes.size() - 1; i++) {
//	            for (int j = i + 1; j < lstRes.size(); j++) {
//	                if (lstRes.get(i).getValue() < lstRes.get(j).getValue()) {
//	                    Entry<Constructeur, Integer> entry = lstRes.get(i);
//	                    lstRes.set(i, lstRes.get(j));
//	                    lstRes.set(j, entry);
//	                }
//	            }
//	        }
//	        return lstRes;
//	    }
//
//	    //méthode pour afficher le classement en String au console
//	    public String afficheClassementAnnuelConstruct() {
//	        String s = "No \t Constructeur \t Points";
//	        int i = 1;
//	        for (Entry<Constructeur, Integer> e : this.classementAnnuelConstructeur()) {
//	            s += "\n " + i + " \t" + e.getKey().getNomConstructeur() + " \t" + e.getValue();
//	            i++;
//	        }
//	        return s;
//	    }
//
//	    //méthode générer les résultat annuel du équipe selon les point
//	    private void setResultatAnnuelEquipe() {
//	        HashMap<EquipeCoureur, Integer> resultat = new HashMap<EquipeCoureur, Integer>();
//	        for (EditionRallye e : this.rallyesAnnes) {
//	            ArrayList<Entry<EquipeCoureur, Integer>> array = e.arrayEditionPointEquipe();
//	            for (Entry<EquipeCoureur, Integer> entry : array) {
//	                int nouveauPoint;
//	                if (resultat.containsKey(entry.getKey())) {
//	                    nouveauPoint = resultat.get(entry.getKey()) + entry.getValue();
//	                } else {
//	                    nouveauPoint = entry.getValue();
//	                }
//	                resultat.put(entry.getKey(), nouveauPoint);
//	            }
//	        }
//	        this.resultatAnnuelEquipe = resultat;
//	    }
//
//	    //méthode générer le classement annuel de l'équipe
//	    public ArrayList<Entry<EquipeCoureur, Integer>> classementAnnuelEquipe() {
//	        this.setResultatAnnuelEquipe();
//	        ArrayList<Entry<EquipeCoureur, Integer>> lstRes = new ArrayList<Entry<EquipeCoureur, Integer>>(this.resultatAnnuelEquipe.entrySet());
//	        for (int i = 0; i < lstRes.size() - 1; i++) {
//	            for (int j = i + 1; j < lstRes.size(); j++) {
//	                if (lstRes.get(i).getValue() < lstRes.get(j).getValue()) {
//	                    Entry<EquipeCoureur, Integer> entry = lstRes.get(i);
//	                    lstRes.set(i, lstRes.get(j));
//	                    lstRes.set(j, entry);
//	                }
//	            }
//	        }
//	        return lstRes;
//	    }
//
//	    //méthode pour afficher le classement en String dans console
//	    public String afficheClassementEditionEquipe() {
//	        String s = "No \t Equipe \t Points";
//	        int i = 1;
//	        for (Entry<EquipeCoureur, Integer> e : this.classementAnnuelEquipe()) {
//	            s += "\n " + i + " \t" + e.getKey().getNomEquipe() + " \t" + e.getValue();
//	            i++;
//	        }
//	        return s;
//	    }

}
