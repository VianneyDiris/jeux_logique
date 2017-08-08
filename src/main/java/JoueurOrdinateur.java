package main.java;

import java.util.Random;

public class JoueurOrdinateur extends Joueur {
	
	public void choixNombre() {
		for(int i =0;i<reader.getNbCase();i++) {
			tabNombreJoueur[i] = 5;
			}
		
		for (int i = 0;i<reader.getNbCase();i++) {
			System.out.print(tabNombreJoueur[i]);
			}
		System.out.println("");
		
	}
	
	public void randomNumber() {
		for(int i =0;i<reader.getNbCase();i++) {
			int chiffre = new Random().nextInt(10);
			tabNombreJoueur[i] = chiffre;
			}
		
		for (int i = 0;i<reader.getNbCase();i++) {
			System.out.print(tabNombreJoueur[i]);
			}
		System.out.println("");
	}

}
