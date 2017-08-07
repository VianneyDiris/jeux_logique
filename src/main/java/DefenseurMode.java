package main.java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class DefenseurMode {
	ReaderFile reader = new ReaderFile();
	int tabNombreJoueur[] = new int [reader.getNbCase()];
	int tabNombreOrdinateur[] = new int [reader.getNbCase()];
	String tabIndice[] = new String [reader.getNbCase()];
	
	//demande un nombre à l'utilisateur et l'enregistre dans un tableau
	public void lecture() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un nombre");
		int nombre = sc.nextInt();
		int current=nombre;
			for (int i = 0;i<reader.getNbCase();i++) {
					tabNombreJoueur[i]=current%10;
					current=current/10;
			}
			
		//renverse le tableau
		ArrayUtils.reverse(tabNombreJoueur);
				//sc.close();
		}
		
	//choix du nombre par l'ordinateur et l'enregistre dans un tableau
		public void randomNumber() {
			
			for(int i =0;i<reader.getNbCase();i++) {
				int chiffre = new Random().nextInt(10);
				tabNombreOrdinateur[i] = chiffre;
				}
			
			for (int i = 0;i<reader.getNbCase();i++) {
				System.out.print(tabNombreOrdinateur[i]);
				}
			System.out.println("");
		}
		//demande les indices aux joueurs
		public void indice () {
			Scanner sc = new Scanner(System.in);
			System.out.print("Réponse : ");
			String indice = sc.nextLine();
			tabIndice = indice.split("");
						
		}
		
		//change le numéro en fonction des indices
		public void adapteNumero() {
			for(int i = 0;i<reader.getNbCase();i++) {
				if(tabIndice[i].equals("-")) {
					tabNombreOrdinateur[i] = tabNombreOrdinateur[i] - 1;
				}
				else if(tabIndice[i].equals("+")) {
					tabNombreOrdinateur[i] = tabNombreOrdinateur[i] + 1;
				}
				else {
					tabNombreOrdinateur[i] = tabNombreOrdinateur[i];
				}
			}
			for (int i = 0;i<reader.getNbCase();i++) {
				System.out.print(tabNombreOrdinateur[i]);
				}
			
		}
		
		public void partieDefenseur() {
			lecture();
			randomNumber();
			int nbEssai = reader.getNbEssai();
			while (!Arrays.equals(tabNombreJoueur, tabNombreOrdinateur) && nbEssai!=0) {
						indice();
						adapteNumero();						
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
