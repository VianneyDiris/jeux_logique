package main.java;

import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;
/**
 * @author vianney
 * @version 0.1
 *classe définissant le comportement du joueur humain
 */
public class JoueurHumain extends Joueur {
	private ReaderFile reader = new ReaderFile();
	private int tabNombreJoueur[] = new int [reader.getNbCase()];
	private ClearTerminal clear = new ClearTerminal();
	
	/**
	 *fonction qui demande au joueur d'entrer un nombre
	 *  
	 */
	public void choixNombre() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nProposition : ");
		int nombre = sc.nextInt();
		int current=nombre;
			for (int i = 0;i<reader.getNbCase();i++) {
				tabNombreJoueur[i]=current%10;
				current=current/10;
			}
			//renverse le tableau
			ArrayUtils.reverse(tabNombreJoueur);
			
	}
	
	/**
	 *fonction qui demande au joueur d'entrer une combinaison pour le mastermind
	 * 
	 */
	public void choixCombinaison() {
		Scanner sc = new Scanner(System.in);
		int nombre = sc.nextInt();
		int current=nombre;
			for (int i = 0;i<reader.getNbCase();i++) {
				this.tabNombreJoueur[i]=current%10;
				current=current/10;
				if(this.tabNombreJoueur[i]>reader.getNbChiffre()) {
					System.out.println("Vous avez entré un nombre contenant un chiffre plus grand que "+reader.getNbChiffre());
					choixCombinaison();
				}
			}
			//renverse le tableau
			ArrayUtils.reverse(this.tabNombreJoueur);
			
			
			
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
