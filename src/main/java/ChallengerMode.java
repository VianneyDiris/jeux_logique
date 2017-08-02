package main.java;

import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;

public class ChallengerMode {
	ReaderFile reader = new ReaderFile();
	
	public void lecture () {
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir un nombre");
	int nombre = sc.nextInt();
	int tabNombre[] = new int [reader.getNbCase()];
	int current=nombre;
	
		for (int i = 0;i<reader.getNbCase();i++) {
			tabNombre[i]=current%10;
			current=current/10;
		}
		
		//renverse le tableau
		ArrayUtils.reverse(tabNombre);
		
	System.out.println(tabNombre[0]+""+tabNombre[1]+""+tabNombre[2]+""+tabNombre[3]);
	sc.close();
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
