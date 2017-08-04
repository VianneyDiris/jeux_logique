package main.java;

import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class DefenseurMode {
	ReaderFile reader = new ReaderFile();
	int tabNombreJoueur[] = new int [reader.getNbCase()];
	int tabNombreOrdinateur[] = new int [reader.getNbCase()];
	
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
	
		

}
