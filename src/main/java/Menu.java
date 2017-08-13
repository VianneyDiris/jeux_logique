package main.java;

import java.util.Scanner;

public class Menu {
	
	public void menuJeu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir votre jeu :");
		System.out.println("1 : Matsermind");
		System.out.println("2 : Recherche +-");
		System.out.println("3 : Quitter le programme");
		int choixJeu = sc.nextInt();
		
		if (choixJeu==1) {
			
		}
		else if (choixJeu==2) {
			choixMode();
			
		}
		else if (choixJeu==3) {
			
		}
		
		else {
			System.out.println("Vous avez choisi aucun jeu");
			
			menuJeu();
		}		
		
		
		
	}
	
	public void choixMode() {
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
			menuJeu();
		}		
		
	}

}
