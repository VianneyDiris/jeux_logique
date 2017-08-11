package main.java;

import java.util.Random;

public class JoueurOrdinateur extends Joueur {
	private ReaderFile reader = new ReaderFile();
	private int tabNombreJoueur[] =new int [reader.getNbCase()];
	
	
	public void choixNombre() {
		for(int i =0;i<this.reader.getNbCase();i++) {
				this.tabNombreJoueur[i] = 5;
			}
		
		for (int i = 0;i<this.reader.getNbCase();i++) {
			System.out.print(this.tabNombreJoueur[i]);
			}
		System.out.println("");
		
	}
	
	public void randomNumber() {
		for(int i =0;i<this.reader.getNbCase();i++) {
			int chiffre = new Random().nextInt(10);
			this.tabNombreJoueur[i] = chiffre;
			}
		
		for (int i = 0;i<this.reader.getNbCase();i++) {
			System.out.print(this.tabNombreJoueur[i]);
			}
		System.out.println("");
	}
	
	public int [] getTabNombreJoueur() {
		return this.tabNombreJoueur;
	}

}
