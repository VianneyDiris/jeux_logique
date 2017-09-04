package main.java;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author vianney
 * @version 0.1
 *classe contenant le mode duel
 */
public class DuelMode {
	ReaderFile reader = new ReaderFile();
	String tabIndice[] = new String [reader.getNbCase()];
	
	/**
	 *fonction qui fournit les indices au joueur
	 * @param JoueurHumain,JoueurOrdinateur
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
		 *fonction qui adapte le numéro en fonction des indices fournit par le joueur 
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
	*fonction qui permet de jouer en mode duel
	* @param JoueurHumain,JoueurOrdinateur
	* 
	*/		
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
	
	public void duel(JoueurHumain humain, JoueurHumain humain2,JoueurOrdinateur ordinateur,JoueurOrdinateur ordinateur2) {
		int nbEssai = reader.getNbEssai();
		
		ordinateur.combinaison();
		humain.choixCombinaison();
		testCombinaison(humain,ordinateur);
		humain2.choixCombinaison();
		ordinateur2.combinaison();
		testCombinaison2(humain2,ordinateur2);
		
		while (!Arrays.equals(humain.getTabNombreJoueur(),ordinateur.getTabNombreJoueur()) && nbEssai!=0 && !Arrays.equals(humain2.getTabNombreJoueur(),ordinateur2.getTabNombreJoueur())) {
			humain.choixCombinaison();
			testCombinaison(humain,ordinateur);
			for(int i =0;i<reader.getNbCase();i++) {
				System.out.print(ordinateur2.getTabNombreJoueur()[i]);
			}
			testCombinaison2(humain2,ordinateur2);
			
			nbEssai--;
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
	
	
	public void testCombinaison2(JoueurHumain humain, JoueurOrdinateur ordinateur) {
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
