package main.java;

import java.util.Random;
/**
 * @author vianney
 * @version 0.1
 *classe définissant le comportement du joueur ordinateur
 */
public class JoueurOrdinateur extends Joueur {
	private ReaderFile reader = new ReaderFile();
	private int tabNombreJoueur[] =new int [reader.getNbCase()];
	
	/**
	 *fonction qui donne un nombre en fonction de la taille demandé dans le config.properties
	 *  
	 */
	public void choixNombre() {
		for(int i =0;i<this.reader.getNbCase();i++) {
				this.tabNombreJoueur[i] = 5;
			}
		if(this.reader.getModeDeveloppeur()==true) {
		for (int i = 0;i<this.reader.getNbCase();i++) {
			System.out.print(this.tabNombreJoueur[i]);
			}
		System.out.println("");
		}
	}
	
	/**
	 *fonction qui donne un nombre aléatoire en fonction de la taille
	 *  
	 */
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
	
	/**
	 *fonction qui donne une combinaison de nombre
	 *  
	 */
	public void combinaison() {
		for(int i =0;i<this.reader.getNbCase();i++) {
			int chiffre = new Random().nextInt(reader.getNbChiffre() - 0);
			this.tabNombreJoueur[i] = chiffre;
			}
		
		for (int i = 0;i<this.reader.getNbCase();i++) {
			System.out.print(this.tabNombreJoueur[i]);
			}
		System.out.println("");
		
	}
	
	/**
	 *fonction qui renvoit le nombre ou la combinaison du joueur
	 * @return le nombre du joueur
	 * 
	 */
	public int [] getTabNombreJoueur() {
		return this.tabNombreJoueur;
	}
	


}
