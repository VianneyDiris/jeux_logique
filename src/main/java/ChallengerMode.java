package main.java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;

/**
 * classe contenant le mode challenger
 * @author vianney
 * @version 0.2
  */
public class ChallengerMode {
	ReaderFile reader = new ReaderFile();
	String tabIndice[] = new String [reader.getNbCase()];
	

	/**
	 *fonction qui compare les 2 tableaux pour donner les indices
	 * @param humain
	 * 		JoueurHumain
	 * @param ordinateur
	 * 		JoueurOrdinateur
	 * 
	 */
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
	
	
	/**
	 *fonction qui permet de jouer en mode challenger
	 * @param humain
	 * 	JoueurHumain
	 * @param ordinateur
	 * 		JoueurOrdinateur
	 * 
	 */
	public void partieChallenger(JoueurHumain humain, JoueurOrdinateur ordinateur) {
		ordinateur.randomNumber();
		
		int nbEssai = reader.getNbEssai();
		while (!Arrays.equals(humain.getTabNombreJoueur(),ordinateur.getTabNombreJoueur()) && nbEssai!=0) {
					humain.choixNombre();
					comparerNombre(humain,ordinateur);
					nbEssai--;
					//System.out.println("\nIl vous reste "+nbEssai+" tours");
										
				}
				
		if (nbEssai==0) {
			System.out.println("\nVous avez perdu, nombre d'essai dépassé.");
			System.out.print("La solution était ");
			for (int i = 0;i<reader.getNbCase();i++) {
				System.out.print(ordinateur.getTabNombreJoueur()[i]);
				}
			
		}
		else {
			System.out.println("\nFélicitation vous avez trouvé la combinaison");
			
		}
		
	}
	
	
	public void testCombinaison(JoueurHumain humain, JoueurOrdinateur ordinateur) {
		int compteurBienPlace = 0;
		int compteurMalPlace  = 0;
		boolean[] masterTest = new boolean[reader.getNbCase()];
		boolean[] guessTest = new boolean[reader.getNbCase()];
		
		
		for(int i = 0;i<reader.getNbCase();i++) {
			if(humain.getTabNombreJoueur()[i]==ordinateur.getTabNombreJoueur()[i]) {
				compteurBienPlace++;
				masterTest[i] = true;
				guessTest[i] = true;
			}
		}
		
		if (compteurBienPlace==reader.getNbCase()) {
			
		}
		else {
			for(int i=0;i<reader.getNbCase();i++) {
				for(int j=0;j<reader.getNbCase();j++) {
					if(ordinateur.getTabNombreJoueur()[i]==humain.getTabNombreJoueur()[j] && !masterTest[i] && !guessTest[j]) {
						compteurMalPlace++;
						masterTest[i]=true;
						guessTest[j]=true;
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
			System.out.print(compteurMalPlace+" mal placé ");
		}
		System.out.println("");
		
	}
			
		
		
		
	
	
	
	public void challenger(JoueurHumain humain, JoueurOrdinateur ordinateur) {
		ordinateur.combinaison();
		
		int nbEssai = reader.getNbEssai();
		while(!Arrays.equals(humain.getTabNombreJoueur(),ordinateur.getTabNombreJoueur()) && nbEssai!=0) {
			System.out.print("Proposition : ");
			humain.choixCombinaison();
			testCombinaison(humain,ordinateur);
			nbEssai--;
		}
		
		if (nbEssai==0) {
			System.out.println("\nVous avez perdu, nombre d'essai dépassé.");
			System.out.print("La solution était ");
			for (int i = 0;i<reader.getNbCase();i++) {
				System.out.print(ordinateur.getTabNombreJoueur()[i]);
				}
			
		}
		else {
			System.out.println("\nFélicitation vous avez trouvé la combinaison");
			
		}
		
	}
	
	
}
