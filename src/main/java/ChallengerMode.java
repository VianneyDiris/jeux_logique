package main.java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author vianney
 * @version 0.1
 *
 */
public class ChallengerMode {
	ReaderFile reader = new ReaderFile();
	String tabIndice[] = new String [reader.getNbCase()];
	

	
	//fonction qui compare les 2 tableaux pour donner les indices
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
			System.out.println("Vous avez perdu, nombre d'essai dépassé.");
			System.out.print("La solution était ");
			for (int i = 0;i<reader.getNbCase();i++) {
				System.out.print(ordinateur.getTabNombreJoueur()[i]);
				}
			
		}
		else {
			System.out.println("Félicitation vous avez trouvé la combinaison");
			
		}
		
	}
	
	public void testCombinaison(JoueurHumain humain, JoueurOrdinateur ordinateur) {
		for(int i = 0; i<reader.getNbCase();i++) {
			for(int j = 0;i<reader.getNbCase();j++) {
				if(humain.getTabNombreJoueur()[i]==ordinateur.getTabNombreJoueur()[j]){
					
				}
				
			}
			
		}
		
	}
	
	public void challenger(JoueurHumain humain, JoueurOrdinateur ordinateur) {
		ordinateur.combinaison();
		humain.choixCombinaison();
	}
	
	
}
