package main.java;

import java.io.IOException;
import java.util.Scanner;
/**
 * @author vianney
 * @version 0.1
 *classe permettant de choisir le jeu et le mode de jeu
 */
public class Menu {
	/**
	 *fonction qui permet de choisir son jeu
	 *  
	 */
	ClearTerminal clear = new ClearTerminal();
	public void menuJeu() {
		clear.clearConsole();
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir votre jeu :");
		System.out.println("1 : Matsermind");
		System.out.println("2 : Recherche +-");
		System.out.println("3 : Quitter le programme");
		int choixJeu = sc.nextInt();
		
		if (choixJeu==1) {
			choixModeMastermind();
		}
		else if (choixJeu==2) {
			choixModeCodeSecret();
			
		}
		else if (choixJeu==3) {
			
		}
		
		else {
			System.out.println("Vous avez choisi aucun jeu");
			clear.clearConsole();
			menuJeu();
		}		
		
		
		
	}
	
	/**
	 *fonction qui permet de choisir le mode de jeu de Recherche +-
	 *  
	 */
	public void choixModeCodeSecret() {
		clear.clearConsole();
		RechercheCodeSecret recherche = new RechercheCodeSecret();
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir votre mode :");
		System.out.println("1 : Challenger");
		System.out.println("2 : Défenseur");
		System.out.println("3 : Duel");
		int choixMode = sc.nextInt();
		
		if (choixMode==1) {
			recherche.challenger();
		}
		else if (choixMode==2) {
			recherche.defenseur();
			
		}
		else if (choixMode==3) {
			recherche.duel();
		}
		
		else {
			System.out.println("Vous avez choisi aucun mode");
			clear.clearConsole();
			menuJeu();
		}		
		
	}
	
	/**
	 *fonction qui permet de choisir le mode de jeu de mastermind
	 *  
	 */
	public void choixModeMastermind() {
		clear.clearConsole();
		Mastermind mastermind  = new Mastermind();
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir votre mode :");
		System.out.println("1 : Challenger");
		System.out.println("2 : Défenseur");
		System.out.println("3 : Duel");
		int choixMode = sc.nextInt();
		
		if (choixMode==1) {
			mastermind.challenger();
		}
		else if (choixMode==2) {
			
			
		}
		else if (choixMode==3) {
			
		}
		
		else {
			System.out.println("Vous avez choisi aucun mode");
			clear.clearConsole();
			menuJeu();
		}		
		
	}
	


}
