package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author vianney
 * @version 0.1
 *classe contenant le mode defenseur
 */
public class DefenseurMode {
	ReaderFile reader = new ReaderFile();
	String tabIndice[] = new String [reader.getNbCase()];
	
	
		/**
		 *fonction qui demande les indices aux joueurs + verifie les indices
		 * @param JoueurHumain,JoueurOrdinateur
		 * 
		 */
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
		
		/**
		 *change le numéro de l'ordinateur en fonction des indices
		 * @param JoueurOrdinateur
		 * 
		 */
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
		
		/**
		 *fonction qui permet de jouer en mode defenseur
		 * @param JoueurHumain
		 * @param JoueurOrdinateur
		 * 
		 */
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
		
		public void defenseur(JoueurHumain humain, JoueurOrdinateur ordinateur) {
			humain.choixCombinaison();
			ordinateur.combinaison();
			int nbEssai = reader.getNbEssai();
			while (!Arrays.equals(humain.getTabNombreJoueur(), ordinateur.getTabNombreJoueur())&& nbEssai!=0) {
				testCombinaison(humain,ordinateur);
				for (int i = 0;i<reader.getNbCase();i++) {
					System.out.print(ordinateur.getTabNombreJoueur()[i]);
					}
				nbEssai--;
			}
			System.out.println("");
			if (nbEssai==0) {
				System.out.println("Vous avez gagné,le nombre d'essai est dépassé.");
								
			}
			else {
				System.out.println("Désolé mais vous avez perdu, l'ordinateur a trouvé votre combinaison.");
				
			}
			
					
			
			
		}
		
		
		public void testCombinaison(JoueurHumain humain, JoueurOrdinateur ordinateur) {
			int compteurBienPlace = 0;
			int compteurMalPlace  = 0;
			boolean[] masterTest = new boolean[reader.getNbCase()];
			boolean[] guessTest = new boolean[reader.getNbCase()];
			boolean[] testBP = new boolean[reader.getNbCase()];
			int [] tempNombreJoueur = new int [reader.getNbCase()]; 
			
			
			
			for(int i = 0;i<reader.getNbCase();i++) {
				if(humain.getTabNombreJoueur()[i]==ordinateur.getTabNombreJoueur()[i]) {
					compteurBienPlace++;
					masterTest[i] = true;
					guessTest[i] = true;
					tempNombreJoueur[i]=ordinateur.getTabNombreJoueur()[i];
					testBP[i]= true;
				
					
					
				}
			}
			
			if (compteurBienPlace==reader.getNbCase()) {
				
			}
			else {
				for(int i=0;i<reader.getNbCase();i++) {
					for(int j=0;j<reader.getNbCase();j++) {
						if(ordinateur.getTabNombreJoueur()[i]==humain.getTabNombreJoueur()[j] && !masterTest[i] && !guessTest[j]) {
							compteurMalPlace++;
							
							guessTest[j]=true;
							
							for (int k=0;k<reader.getNbCase();k++) {
								if(i!=k && !testBP[k] && !masterTest[i]) {
									tempNombreJoueur[k]=ordinateur.getTabNombreJoueur()[i];
									testBP[k]=true;
									masterTest[i]=true;
								
								}
								if(i==reader.getNbCase()-1 &&!testBP[k] && !masterTest[i]) {
									tempNombreJoueur[k]=ordinateur.getTabNombreJoueur()[i];
									testBP[k]=true;
									masterTest[i]=true;
								}
							}
							
												
														
						}
					}
				}
			}
		
			
			System.out.print("-> Réponse : ");
			if(compteurBienPlace>0) 
			{
				System.out.print(compteurBienPlace+" bien placé ");
			}
			if(compteurMalPlace>0) 
			{
				System.out.print(compteurMalPlace+" présent ");
			}
			System.out.println("");
			for(int l = 0;l<reader.getNbCase();l++) {
				if(l<reader.getNbCase() && !testBP[l] && ordinateur.getTabNombreJoueur()[l]+1<=reader.getNbChiffre()) {
					tempNombreJoueur[l]= ordinateur.getTabNombreJoueur()[l]+1;
					testBP[l]=true;
				}
				if(l<reader.getNbCase() && !testBP[l] && ordinateur.getTabNombreJoueur()[l]+1>reader.getNbChiffre()) {
					tempNombreJoueur[l]=0;
					testBP[l]=true;
				}
			}
			
			
			for (int i = 0;i<reader.getNbCase();i++) {
				ordinateur.getTabNombreJoueur()[i]=tempNombreJoueur[i];
				}
			
		}
		
		
		

}
