import donnee.Donnee;
import interfacegraphic.Accueil;

public class Main {
	public static void main(String[] arg) {
		Donnee d = new Donnee();
		Accueil a = new Accueil(d);
		a.setVisible(true);

		/*
		 * L'indication pour la partie de l'inscription (implantation de la base de
		 * donné) est mis dans interfacegraphic.Accueil
		 */
	}
}
