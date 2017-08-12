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
		System.out.print(" -> R�ponse : ");
		for (int i = 0;i<humain.getTabNombreJoueur().length;i++) {
			System.out.print(tabIndice[i]);
		}
	}
	
	//demande les indices aux joueurs + verification indices
			public void indice (JoueurHumain humain, JoueurOrdinateur ordinateur) {
				Scanner sc = new Scanner(System.in);
				System.out.print("R�ponse : ");
				String indice = sc.nextLine();
				tabIndice = indice.split("");
				
				//v�rification des indices
				for(int i = 0;i<reader.getNbCase();i++) {
					if((tabIndice[i].equals("-") && ordinateur.getTabNombreJoueur()[i]>humain.getTabNombreJoueur()[i]) || (tabIndice[i].equals("+") && ordinateur.getTabNombreJoueur()[i]<humain.getTabNombreJoueur()[i]) || (tabIndice[i].equals("=") && ordinateur.getTabNombreJoueur()[i]==humain.getTabNombreJoueur()[i])) {
						
					}
				
					else {
						System.out.println("vous avez essay� de tricher");
						indice(humain,ordinateur);
					}
				}
							
			}
	
	public void partieDuel(JoueurHumain humain, JoueurOrdinateur ordinateur,JoueurHumain humain2, JoueurOrdinateur ordinateur2) {
		ordinateur.randomNumber();
		
		humain2.choixNombre();
		ordinateur2.choixNombre();
		indice(humain2,ordinateur2);
		int nbEssai = reader.getNbEssai();
		while (!Arrays.equals(humain.getTabNombreJoueur(),ordinateur.getTabNombreJoueur()) && nbEssai!=0) {
			humain.choixNombre();
			comparerNombre(humain,ordinateur);
					nbEssai--;
					//System.out.println("\nIl vous reste "+nbEssai+" tours");
										
				}
				
		if (nbEssai==0) {
			System.out.println("Vous avez perdu, nombre d'essai d�pass�.");
			System.out.print("La solution �tait ");
			for (int i = 0;i<reader.getNbCase();i++) {
				System.out.print(ordinateur.getTabNombreJoueur()[i]);
				}
			
		}
		else {
			System.out.println("F�licitation vous avez trouv� la combinaison");
			
		}
		
		
		
		
	}

}
