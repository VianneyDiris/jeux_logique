package main.java;

import java.util.Random;
import java.util.Scanner;

public class ChallengerMode {
	ReaderFile reader = new ReaderFile();
	
	public void lecture () {
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir un nombre");
	String nombre = sc.nextLine();
	System.out.println("Vous avez saisi "+nombre);
	}
	
	public void randomNumber() {
		int tabNombre[] = new int [reader.getNbCase()];
		for(int i =0;i<reader.getNbCase();i++) {
			int chiffre = new Random().nextInt(10);
			
			tabNombre[i] = chiffre;
			
		}
		System.out.println(tabNombre[0]+""+tabNombre[1]+""+tabNombre[2]+""+tabNombre[3]);
		
	}
}
