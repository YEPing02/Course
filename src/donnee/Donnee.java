package donnee;

import java.util.ArrayList;

import javax.swing.ListCellRenderer;

import gestioncourse.*;
import gestioninscription.*;

public class Donnee {
	private ArrayList<Course> lstCourse;
	private ArrayList<Edition> lstEdition;
	private ArrayList<Etape> lstEtape;
	private ArrayList<Coureur> lstCoureur;
	private ArrayList<String> lstType;
	private ArrayList<Annee> lstAnnee;

	public Donnee() {
		lstCourse = new ArrayList<Course>();
		lstEdition = new ArrayList<Edition>();
		lstEtape = new ArrayList<Etape>();
		lstCoureur = new ArrayList<Coureur>();
		lstType = new ArrayList<String>();
		lstAnnee = new ArrayList<Annee>();
		init();
	}

	public void init() {
		lstType.add("Rallye");
		lstType.add("F1");
		lstType.add("Volvo");

		lstAnnee.add(new Annee(2016));
		lstAnnee.add(new Annee(2017));
		lstAnnee.add(new Annee(2018));
		lstAnnee.add(new Annee(2019));

		Coureur c1, c2, c3, c4, c5, c6, c7, c8, c9;
		c1 = new Coureur(1, "YE", "Ping", "09-10-2000", "O");
		c2 = new Coureur(1, "SHEN", "Yuxuan", "09-10-2000", "O");
		c3 = new Coureur(1, "LI", "Jiadong", "09-10-2000", "O");
		c4 = new Coureur(1, "ZHANG", "Chenguang", "09-10-2000", "O");
		c5 = new Coureur(1, "CoureurE", "A", "09-10-2000", "O");
		c6 = new Coureur(1, "CoureurF", "A", "09-10-2000", "O");
		c7 = new Coureur(1, "CoureurG", "A", "09-10-2000", "O");
		c8 = new Coureur(1, "CoureurH", "A", "09-10-2000", "O");
		c9 = new Coureur(1, "CoureurI", "A", "09-10-2000", "O");

		// Rallye
		CourseRallye cr1 = new CourseRallye(1, "RallyeParis");
		lstCourse.add(cr1);
		// editionRallye
		EditionRallye edr1 = new EditionRallye(1, "2016/01/01", "2016/02/01", "2016");
		lstAnnee.get(0).setRallyesAnnes(edr1);

		EditionRallye edr2 = new EditionRallye(2, "2017/01/01", "2017/02/01", "2017");
		lstCourse.get(0).ajouterEditon(edr1);
		lstCourse.get(0).ajouterEditon(edr2);
		// Etape
		EtapeRallye etr1 = new EtapeRallye(1);
		EtapeRallye etr2 = new EtapeRallye(2);
		EtapeRallye etr3 = new EtapeRallye(3);
		EtapeRallye etr4 = new EtapeRallye(4);

		EditionRallye ed1 = (EditionRallye) (lstCourse.get(0).getEdition(0));
		ed1.ajouterEtape(etr1);
		ed1.ajouterEtape(etr2);
		ed1.ajouterEtape(etr3);
		ed1.ajouterEtape(etr4);
		// speciale
		Speciale s1 = new Speciale(1, 1, 0, 1);
		Speciale s2 = new Speciale(1, 1, 0, 1);
		Speciale s3 = new Speciale(1, 1, 0, 1);
		etr1.ajouterSpeciale(s1);
		etr1.ajouterSpeciale(s2);
		etr1.ajouterSpeciale(s3);
		// Inscrition
		Inscription ir1 = new Inscription(1, c1, edr1, new Voiture("V1", 1));
		Inscription ir2 = new Inscription(2, c2, edr1, new Voiture("V2", 1));
		Inscription ir3 = new Inscription(3, c3, edr1, new Voiture("V3", 1));
		Inscription ir4 = new Inscription(4, c4, edr1, new Voiture("V4", 1));
		edr1.ajouterInscrip(ir1);
		edr1.ajouterInscrip(ir2);
		edr1.ajouterInscrip(ir3);
		edr1.ajouterInscrip(ir4);
		// courir
		etr1.enregistreTemps(ir1);
		etr1.enregistreTemps(ir2);
		etr1.enregistreTemps(ir3);
		etr1.enregistreTemps(ir4);
		s1.enregistreTemps(ir1, 1234);
		s1.enregistreTemps(ir2, 1234);
		s1.enregistreTemps(ir3, 1234);
		s1.enregistreTemps(ir4, 1234);

		// F1
		CourseF1 cf1 = new CourseF1(4, "F1Marseille");
		lstCourse.add(cf1);
		// EditionF1
		EditionF1 edf1 = new EditionF1(1, "2016/01/01", "2016/12/01", "2016");
		EditionF1 edf2 = new EditionF1(2, "2017/01/01", "2017/12/01", "2017");
		cf1.ajouterEditon(edf1);
		cf1.ajouterEditon(edf2);
		// EtapeF1
		EtapeF1 etf1 = new EtapeF1(1, 23, 22, 22, "Toulouse", "France");
		EtapeF1 etf2 = new EtapeF1(2, 23, 22, 22, "Pekin", "Chine");
		EtapeF1 etf3 = new EtapeF1(3, 23, 22, 22, "Madrid", "Espagnol");
		EtapeF1 etf4 = new EtapeF1(4, 23, 22, 22, "Manaco", "Manaco");
		EtapeF1 etf5 = new EtapeF1(5, 23, 22, 22, "Londre", "Royaume-Uni");
		edf1.ajouterEtape(etf1);
		edf1.ajouterEtape(etf2);
		edf1.ajouterEtape(etf3);
		edf1.ajouterEtape(etf4);
		edf1.ajouterEtape(etf5);
		// Inscription
		Inscription if1 = new Inscription(1, c1, edf1, new VoitureFormule("F1", 1));
		Inscription if2 = new Inscription(2, c2, edf1, new VoitureFormule("F2", 1));
		Inscription if3 = new Inscription(3, c3, edf1, new VoitureFormule("F3", 1));
		Inscription if4 = new Inscription(4, c4, edf1, new VoitureFormule("F4", 1));
		edf1.ajouterInscrip(if1);
		edf1.ajouterInscrip(if2);
		edf1.ajouterInscrip(if3);
		edf1.ajouterInscrip(if4);
		// enregistrer temps

		// toulouse
		etf1.enregistreTemps(if1, 1, 0, 0);
		etf1.enregistreTemps(if2, 2, 0, 0);
		etf1.enregistreTemps(if3, 3, 0, 0);
		etf1.enregistreTemps(if4, 4, 0, 0);
		// Pekin
		etf2.enregistreTemps(if1, 0, 30, 0);
		etf2.enregistreTemps(if2, 1, 0, 0);
		etf2.enregistreTemps(if3, 3, 0, 0);
		etf2.enregistreTemps(if4, 4, 0, 0);
		// Madrid
		etf3.enregistreTemps(if1, 1, 0, 0);
		etf3.enregistreTemps(if2, 3, 0, 0);
		etf3.enregistreTemps(if3, 1, 40, 0);
		etf3.enregistreTemps(if4, 4, 0, 0);
		// Monaco
		etf4.enregistreTemps(if1, 2, 0, 0);
		etf4.enregistreTemps(if2, 3, 0, 0);
		etf4.enregistreTemps(if3, 4, 0, 0);
		etf4.enregistreTemps(if4, 4, 0, 0);
		// Londre
		etf5.enregistreTemps(if1, 2, 0, 0);
		etf5.enregistreTemps(if2, 5, 0, 0);
		etf5.enregistreTemps(if3, 2, 0, 0);
		etf5.enregistreTemps(if4, 2, 0, 0);
		/**********************************************************/

		// Volvo
		CourseVolvo courseVolvo1 = new CourseVolvo(1, "Volvo Grand Prix");
		lstCourse.add(courseVolvo1);
		// Edition
		EditionVolvo editionVolvo = new EditionVolvo(1, "01-03-2019", "01-12-2019", "2019");
		courseVolvo1.ajouterEditon(editionVolvo);
		EtapeMer etapeMer1, etapeMer2;
		EtapeVolvo etapePort3, etapePort4;
		etapeMer1 = new EtapeMer(1, 0, 0, 0, "Mer1", 400000, 1);
		etapeMer2 = new EtapeMer(2, 0, 0, 0, "Mer2", 1000000, 2);
		etapePort3 = new EtapeVolvo(3, 1, 0, 0, "Port1");
		etapePort4 = new EtapeVolvo(4, 0, 50, 0, "Port2");

		Vehicule voilier = new VehiculeVoilier("VOILIER");

		Inscription i1, i2, i3, i4, i5, i6, i7, i8, i9;
		i1 = new Inscription(1, c1, editionVolvo, voilier);
		i2 = new Inscription(2, c2, editionVolvo, voilier);
		i3 = new Inscription(3, c3, editionVolvo, voilier);
		i4 = new Inscription(4, c4, editionVolvo, voilier);
		i5 = new Inscription(5, c5, editionVolvo, voilier);
		i6 = new Inscription(6, c6, editionVolvo, voilier);
		i7 = new Inscription(7, c7, editionVolvo, voilier);
		i8 = new Inscription(8, c8, editionVolvo, voilier);
		i9 = new Inscription(9, c9, editionVolvo, voilier);

		CourirEtapeMer cemi1Mer1, cemi2Mer1, cemi3Mer1, cemi4Mer1, cemi1Mer2, cemi2Mer2, cemi3Mer2, cemi4Mer2;
		cemi1Mer1 = new CourirEtapeMer(410000, 3, 2);
		cemi2Mer1 = new CourirEtapeMer(410000, 3, 10);
		cemi3Mer1 = new CourirEtapeMer(310000, 3, 0);
		cemi4Mer1 = new CourirEtapeMer(410000, 3, 20);
		cemi1Mer2 = new CourirEtapeMer(1000123, 10, 3);
		cemi2Mer2 = new CourirEtapeMer(1000123, 10, 4);
		cemi3Mer2 = new CourirEtapeMer(1000123, 9, 22);
		cemi4Mer2 = new CourirEtapeMer(1000123, 10, 22);

		etapeMer1.enregistreTempsMer(i1, cemi1Mer1.getTempsMer(), cemi1Mer1.getDistance());
		etapeMer1.enregistreTempsMer(i2, cemi2Mer1.getTempsMer(), cemi2Mer1.getDistance());
		etapeMer1.enregistreTempsMer(i3, cemi3Mer1.getTempsMer(), cemi3Mer1.getDistance());
		etapeMer1.enregistreTempsMer(i4, cemi4Mer1.getTempsMer(), cemi4Mer1.getDistance());
		etapeMer2.enregistreTempsMer(i1, cemi1Mer2.getTempsMer(), cemi1Mer2.getDistance());
		etapeMer2.enregistreTempsMer(i2, cemi2Mer2.getTempsMer(), cemi2Mer2.getDistance());
		etapeMer2.enregistreTempsMer(i3, cemi3Mer2.getTempsMer(), cemi3Mer2.getDistance());
		etapeMer2.enregistreTempsMer(i4, cemi4Mer2.getTempsMer(), cemi4Mer2.getDistance());

		CourirEtapePort cepi1Port3, cepi2Port3, cepi3Port3, cepi4Port3, cepi1Port4, cepi2Port4, cepi3Port4, cepi4Port4;
		cepi1Port3 = new CourirEtapePort(46, 38f);
		cepi2Port3 = new CourirEtapePort(56, 38f);
		cepi3Port3 = new CourirEtapePort(66, 38f);
		cepi4Port3 = new CourirEtapePort(51, 38f);
		cepi1Port4 = new CourirEtapePort(44, 38f);
		cepi2Port4 = new CourirEtapePort(41, 38f);
		cepi3Port4 = new CourirEtapePort(40, 38f);
		cepi4Port4 = new CourirEtapePort(39, 38f);

		etapePort3.enregistreTemps(i1, cepi1Port3.getTempsPort());
		etapePort3.enregistreTemps(i2, cepi2Port3.getTempsPort());
		etapePort3.enregistreTemps(i3, cepi3Port3.getTempsPort());
		etapePort3.enregistreTemps(i4, cepi4Port3.getTempsPort());
		etapePort4.enregistreTemps(i1, cepi1Port4.getTempsPort());
		etapePort4.enregistreTemps(i2, cepi2Port4.getTempsPort());
		etapePort4.enregistreTemps(i3, cepi3Port4.getTempsPort());
		etapePort4.enregistreTemps(i4, cepi4Port4.getTempsPort());

		etapePort3.classementTemps();
		etapePort4.classementTemps();

		etapeMer1.classementTemps();
		etapeMer2.classementTemps();

		etapePort3.listePointsVolvo();
		etapePort4.listePointsVolvo();

		etapeMer1.listePointsVolvoMer();
		etapeMer2.listePointsVolvoMer();

		etapeMer1.classementPoint();
		etapeMer2.classementPoint();

		etapePort3.classementPoint();
		etapePort4.classementPoint();

		System.out.println("classementPointEtapeMer1 : " + etapeMer1.affichierClassementPoint());
		System.out.println("classementPointEtapeMer2 : " + etapeMer2.affichierClassementPoint());

		System.out.println("-----------------------------------");

		editionVolvo.ajouterInscrip(i1);
		editionVolvo.ajouterInscrip(i2);
		editionVolvo.ajouterInscrip(i3);
		editionVolvo.ajouterInscrip(i4);

		editionVolvo.ajouterEtapeMer(etapeMer1);
		editionVolvo.ajouterEtapeMer(etapeMer2);

		editionVolvo.ajouterEtape(etapePort3);
		editionVolvo.ajouterEtape(etapePort4);

		editionVolvo.pointsEtapeMeretPort();
		editionVolvo.pointEstMeme();
		editionVolvo.classementEdition();
		System.out.println(editionVolvo.afficherClassementEidtionVolvo());

	}

	public ArrayList<Annee> getLstAnnee() {
		return lstAnnee;
	}

	public void setLstType(ArrayList<String> lstType) {
		this.lstType = lstType;
	}

	// setters
	public void setLstCourse(ArrayList<Course> lstCourse) {
		this.lstCourse = lstCourse;
	}

	public void setLstEdition(ArrayList<Edition> lstEdition) {
		this.lstEdition = lstEdition;
	}

	public void setLstEtape(ArrayList<Etape> lstEtape) {
		this.lstEtape = lstEtape;
	}

	public void setLstAnnee(ArrayList<Annee> lstAnnee) {
		this.lstAnnee = lstAnnee;
	}

	public void setLstCoureur(ArrayList<Coureur> lstCoureur) {
		this.lstCoureur = lstCoureur;
	}

	// getters

	public ArrayList<Edition> getLstEdition() {
		return lstEdition;
	}

	public ArrayList<Etape> getLstEtape() {
		return lstEtape;
	}

	public ArrayList<Course> getLstCourse() {
		return lstCourse;
	}

	public ArrayList<String> getLstType() {
		return lstType;
	}

	//
	public Course getCourse(int i) {
		return lstCourse.get(i);
	}

	public Edition getEdition(int i) {
		return this.lstEdition.get(i);
	}

	public Etape getEtape(int i) {
		return this.lstEtape.get(i);
	}

	public ArrayList<Coureur> getLstCoureur() {
		return lstCoureur;
	}

	public Annee getAnnee(int i) {
		return this.lstAnnee.get(i);
	}

	public Coureur getCoureur(int i) {
		return this.lstCoureur.get(i);
	}

	public void ajoutCourse(Course r) {
		this.lstCourse.add(r);
	}

	public void ajoutEdition(Edition edi) {
		this.lstEdition.add(edi);
	}
}
