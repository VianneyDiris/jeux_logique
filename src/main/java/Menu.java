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
		System.out.println("1 : Mastermind");
		System.out.println("2 : Recherche +-");
		System.out.println("3 : Quitter le programme");
		try {int choixJeu = sc.nextInt();
		}
		
		
		
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
			clear.clearConsole();
			recherche.challenger();
			sc = new Scanner(System.in);
			System.out.println("\nVoulez vous :");
			System.out.println("1 : rejouer");
			System.out.println("2 : changer de jeu");
			System.out.println("3 : quitter le programme");
			int choix = sc.nextInt();
			
			if (choix==1) {
				clear.clearConsole();
				recherche.challenger();
			}
			else if (choix==2) {
				clear.clearConsole();
				menuJeu();
			}
			else {
				
			}
		}
		else if (choixMode==2) {
			clear.clearConsole();
			recherche.defenseur();
		
			sc = new Scanner(System.in);
			System.out.println("\nVoulez vous :");
			System.out.println("1 : rejouer");
			System.out.println("2 : changer de jeu");
			System.out.println("3 : quitter le programme");
			int choix = sc.nextInt();
			
			if (choix==1) {
				clear.clearConsole();
				recherche.defenseur();
			}
			else if (choix==2) {
				clear.clearConsole();
				menuJeu();
			}
			else {
				
			}
			
		}
		else if (choixMode==3) {
			clear.clearConsole();
			recherche.duel();
		
			sc = new Scanner(System.in);
			System.out.println("\nVoulez vous :");
			System.out.println("1 : rejouer");
			System.out.println("2 : changer de jeu");
			System.out.println("3 : quitter le programme");
			int choix = sc.nextInt();
			
			if (choix==1) {
				clear.clearConsole();
				recherche.duel();
			}
			else if (choix==2) {
				clear.clearConsole();
				menuJeu();
			}
			else {
				
			}
			
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
		System.out.println("\nVeuillez choisir votre mode :");
		System.out.println("1 : Challenger");
		System.out.println("2 : Défenseur");
		System.out.println("3 : Duel");
		int choixMode = sc.nextInt();
		
		if (choixMode==1) {
			clear.clearConsole();
			mastermind.challenger();
			
			sc = new Scanner(System.in);
			System.out.println("\nVoulez vous :");
			System.out.println("1 : rejouer");
			System.out.println("2 : changer de jeu");
			System.out.println("3 : quitter le programme");
			int choix = sc.nextInt();
			
			if (choix==1) {
				clear.clearConsole();
				mastermind.challenger();
			}
			else if (choix==2) {
				clear.clearConsole();
				menuJeu();
			}
			else {
				
			}
		}
		else if (choixMode==2) {
			mastermind.defenseur();
			
		}
		else if (choixMode==3) {
			mastermind.duel();
		}
		
		else {
			System.out.println("Vous avez choisi aucun mode");
			clear.clearConsole();
			menuJeu();
		}		
		
	}
	


}
