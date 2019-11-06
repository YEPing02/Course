package gestioncourse;
import java.util.ArrayList;
import java.util.HashMap;

import gestioninscription.*;

public class Speciale {
	private int numSpeciale;
	private float tempsLimiteEtape;
	private ArrayList<Inscription> listeInscrip;
	
	public Speciale (int numSpeciale, int tempsLimiteH, int tempsLimiteM,float tempsLimiteS) {
		enregistrerTemps(tempsLimiteH, tempsLimiteM, tempsLimiteS);
		this.numSpeciale = numSpeciale;
	}
	
	public void enregistrerTemps(int tempsLimiteH, int tempsLimiteM,float tempsLimiteS) {
		this.tempsLimiteEtape=tempsLimiteH*3600+tempsLimiteM*60+tempsLimiteS;
	}
	
	public String getStringTempsLimite() {		
		String s= new String();
		s+=(int)(tempsLimiteEtape/3600)+"H "+(int)(tempsLimiteEtape%3600/60)+"'";
		s+=(float)(Math.round(tempsLimiteEtape%3600%60*100))/100;
		return s;				
	}
	
	
	//
	public int getHeure() {
		return (int)(tempsLimiteEtape/3600);
	}
	public int getMinute() {
		return (int)(tempsLimiteEtape%3600/60);
	}
	
	public float getSeconde() {
		return (float)(Math.round(tempsLimiteEtape%3600%60*100))/100;
	}
	//
	
	
	
	public ArrayList<Inscription> classementSpeciale(){
		return null;
	}
	public int getNumSpeciale() {
		return numSpeciale;
	}
	public void setNumSpeciale(int numSpeciale) {
		this.numSpeciale = numSpeciale;
	}
	public ArrayList<Inscription> getListeInscrip() {
		return listeInscrip;
	}
	public void setListeInscrip(ArrayList<Inscription> listeInscrip) {
		this.listeInscrip = listeInscrip;
	}
	
	
	
}
