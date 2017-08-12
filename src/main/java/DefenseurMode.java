package main.java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class DefenseurMode {
	ReaderFile reader = new ReaderFile();
	String tabIndice[] = new String [reader.getNbCase()];
	
			
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
		
		//change le numéro en fonction des indices
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
		
		public void partieDefenseur(JoueurHumain humain, JoueurOrdinateur ordinateur) {
			humain.choixNombre();
			ordinateur.choixNombre();
			int nbEssai = reader.getNbEssai();
			while (!Arrays.equals(humain.getTabNombreJoueur(), ordinateur.getTabNombreJoueur()) && nbEssai!=0) {
						indice(humain,ordinateur);
						adapteNumero(ordinateur);						
						nbEssai--;
						System.out.println("\nIl reste "+nbEssai+" tours");
											
					}
					
			if (nbEssai==0) {
				System.out.println("Vous avez gagné,le nombre d'essai est dépassé.");
								
			}
			else {
				System.out.println("Désolé mais vous avez perdu, l'ordinateur a trouvé votre numéro.");
				
			}
			
		}
		

}
