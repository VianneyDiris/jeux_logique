package main.java;

import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;

public class ChallengerMode {
	ReaderFile reader = new ReaderFile();
	int tabNombreJoueur[] = new int [reader.getNbCase()];
	int tabNombreOrdinateur[] = new int [reader.getNbCase()];
	String tabIndice[] = new String [reader.getNbCase()];
	
	//
	public int [] lecture() {
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
				for (int i = 0;i<tabNombreJoueur.length;i++) {
					System.out.print(tabNombreJoueur[i]);
				}
	
	sc.close();
	System.out.println("");
	return tabNombreJoueur;
	}
	
	
	public int [] randomNumber() {
		
		for(int i =0;i<reader.getNbCase();i++) {
			int chiffre = new Random().nextInt(10);
			tabNombreOrdinateur[i] = chiffre;
			
		}
		
		for (int i = 0;i<reader.getNbCase();i++) {
			System.out.print(tabNombreOrdinateur[i]);
		}
		System.out.println("");
		
		return tabNombreOrdinateur;
	}
	
	
	public void comparerNombre() {
		for (int i = 0;i<reader.getNbCase();i++) {
			if (tabNombreJoueur[i]==tabNombreOrdinateur[i]) {
				tabIndice[i] = "=";
					}
			else if(tabNombreJoueur[i]<tabNombreOrdinateur[i]) {
					tabIndice[i] = "+";
			}
				else {
					tabIndice[i] = "-";
				}
		}
		for (int i = 0;i<tabNombreJoueur.length;i++) {
			System.out.print(tabNombreJoueur[i]);
		}
		System.out.println(" ");
		for (int i = 0;i<tabNombreJoueur.length;i++) {
			System.out.print(tabIndice[i]);
		}
	}
}
