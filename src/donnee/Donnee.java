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

	    public Donnee() {
	        lstCourse = new ArrayList<Course>();
	        lstEdition = new ArrayList<Edition>();
	        lstEtape = new ArrayList<Etape>();
	        lstCoureur = new ArrayList<Coureur>();
	        lstType = new ArrayList<String>();
	        
	        init();
	    }
	    
	    
	    public void init() {

	        lstType.add("Rallye");
	        lstType.add("Régate");
	        lstType.add("Vélo");
	        lstType.add("Courir");	        
	        lstCourse.add(new CourseRallye("RallyeParis"));
	        lstCourse.add(new CourseRallye("RallyeToulouse"));
	        lstCourse.add(new CourseRallye("RallyeMarseille"));
	        
	        lstCourse.get(0).ajouterEditon(new Edition(1, "2016/01/01", "2016/02/01", "2016"));
	        lstCourse.get(0).ajouterEditon(new Edition(2, "2017/01/01", "2017/02/01", "2017"));
	        lstCourse.get(0).ajouterEditon(new Edition(3, "2018/01/01", "2018/02/01", "2018"));
	        lstCourse.get(0).ajouterEditon(new Edition(4, "2019/01/01", "2019/02/01", "2019"));
	        
	        lstCourse.get(0).getEdition(0).ajouterEtape(new Etape(0, 2, 00, 00));
	        lstCourse.get(0).getEdition(0).ajouterEtape(new Etape(1, 3, 00, 00));
	        lstCourse.get(0).getEdition(0).ajouterEtape(new Etape(2, 4, 30, 00));
	        lstCourse.get(0).getEdition(0).ajouterEtape(new Etape(3, 4, 00, 00));
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

