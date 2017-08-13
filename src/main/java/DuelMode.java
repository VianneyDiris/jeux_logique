package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class DuelMode {
	ReaderFile reader = new ReaderFile();
	String tabIndice[] = new String [reader.getNbCase()];
	
	public void comparerNombre(JoueurHumain humain, JoueurOrdinateur ordinateur) {
		for (int i = 0;i<reader.getNbCase();i++) {
			if (humain.getTabNombreJoueur()[i]==ordinateur.getTabNombreJoueur()[i]) {
				tabIndice[i] = "=";
					}
			else if(humain.getTabNombreJoueur()[i]<ordinateur.getTabNombreJoueur()[i]) {
					tabIndice[i] = "+";
			}
				else {
					tabIndice[i] = "-";
				}
		}
		System.out.print("Proposition : ");
		for (int i = 0;i<humain.getTabNombreJoueur().length;i++) {
			System.out.print(humain.getTabNombreJoueur()[i]);
		}
		System.out.print(" -> Réponse : ");
		for (int i = 0;i<humain.getTabNombreJoueur().length;i++) {
			System.out.print(tabIndice[i]);
		}
	}
	
	//demande les indices aux joueurs + verification indices
			public void indice (JoueurHumain humain, JoueurOrdinateur ordinateur) {
				Scanner sc = new Scanner(System.in);
				System.out.print("Réponse : ");
				String indice = sc.nextLine();
				tabIndice = indice.split("");
				
				//vérification des indices
				for(int i = 0;i<reader.getNbCase();i++) {
					if((tabIndice[i].equals("-") && ordinateur.getTabNombreJoueur()[i]>humain.getTabNombreJoueur()[i]) || (tabIndice[i].equals("+") && ordinateur.getTabNombreJoueur()[i]<humain.getTabNombreJoueur()[i]) || (tabIndice[i].equals("=") && ordinateur.getTabNombreJoueur()[i]==humain.getTabNombreJoueur()[i])) {
						
					}
				
					else {
						System.out.println("vous avez essayé de tricher");
						indice(humain,ordinateur);
					}
				}
							
			}
			
			public void adapteNumero(JoueurOrdinateur ordinateur) {
				for(int i = 0;i<reader.getNbCase();i++) {
					if(tabIndice[i].equals("-")) {
						ordinateur.getTabNombreJoueur()[i] = ordinateur.getTabNombreJoueur()[i] - 1;
					}
					else if(tabIndice[i].equals("+")) {
						ordinateur.getTabNombreJoueur()[i] = ordinateur.getTabNombreJoueur()[i] + 1;
					}
					else {
						ordinateur.getTabNombreJoueur()[i] = ordinateur.getTabNombreJoueur()[i];
					}
				}
				for (int i = 0;i<reader.getNbCase();i++) {
					System.out.print(ordinateur.getTabNombreJoueur()[i]);
					}
				
			}
	
	public void partieDuel(JoueurHumain humain, JoueurOrdinateur ordinateur,JoueurHumain humain2, JoueurOrdinateur ordinateur2) {
		ordinateur.randomNumber();
		humain.choixNombre();
		comparerNombre(humain,ordinateur);
		humain2.choixNombre();
		ordinateur2.choixNombre();
		indice(humain2,ordinateur2);
		adapteNumero(ordinateur2);
		int nbEssai = reader.getNbEssai();
		while (!Arrays.equals(humain.getTabNombreJoueur(),ordinateur.getTabNombreJoueur()) && nbEssai!=0 && !Arrays.equals(humain2.getTabNombreJoueur(),ordinateur2.getTabNombreJoueur())) {
			
			humain.choixNombre();
			comparerNombre(humain,ordinateur);
			indice(humain2,ordinateur2);
			adapteNumero(ordinateur2);
			
			
			
			
			
			nbEssai--;
					//System.out.println("\nIl vous reste "+nbEssai+" tours");
										
				}
				
		if (nbEssai==0 && !Arrays.equals(humain.getTabNombreJoueur(),ordinateur.getTabNombreJoueur())) {
			System.out.println("Vous avez perdu.");
			System.out.print("La solution était ");
			for (int i = 0;i<reader.getNbCase();i++) {
				System.out.print(ordinateur.getTabNombreJoueur()[i]);
				}
			
		}
		if (nbEssai==0 && !Arrays.equals(humain2.getTabNombreJoueur(),ordinateur2.getTabNombreJoueur())) {
			System.out.println("Félicitation vous avez vaincu l'ordinateur");
			
		}
		if (nbEssai!=0 && Arrays.equals(humain.getTabNombreJoueur(),ordinateur.getTabNombreJoueur())) {
			System.out.println("Félicitation vous avez trouvé la bonne combinaison dans le temps imparti");
		}
		if (nbEssai!=0 && Arrays.equals(humain2.getTabNombreJoueur(),ordinateur2.getTabNombreJoueur())) {
			System.out.println("Vous avez perdu. L'ordinateur a trouvé votre combinaison");
			
			
		}
		
		
		
		
	}

}
