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
		System.out.print(" -> R�ponse : ");
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
	
	
	public void testCombinaison(JoueurHumain humain, JoueurOrdinateur ordinateur) {
		int compteurBienPlace = 0;
		int compteurMalPlace  = 0;
		boolean[] masterTest = new boolean[4];
		boolean[] guessTest = new boolean[4];
		
		
		for(int i = 0;i<reader.getNbCase();i++) {
			if(humain.getTabNombreJoueur()[i]==ordinateur.getTabNombreJoueur()[i]) {
				System.out.println(compteurBienPlace);
				compteurBienPlace++;
				masterTest[i] = true;
				guessTest[i] = true;
			}
		}
		
		if (compteurBienPlace==reader.getNbCase()) {
			System.out.println("mettre la fonction fin de partie");
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

		System.out.print("R�ponse : ");
		if(compteurBienPlace>0) 
		{
			System.out.print(compteurBienPlace+" bien plac� ");
		}
		if(compteurMalPlace>0) 
		{
			System.out.print(compteurMalPlace+" mal plac� ");
		}
		
	}
			
		
		
		
	
	
	
	public void challenger(JoueurHumain humain, JoueurOrdinateur ordinateur) {
		ordinateur.combinaison();
		humain.choixCombinaison();
		testCombinaison(humain,ordinateur);
	}
	
	
}
