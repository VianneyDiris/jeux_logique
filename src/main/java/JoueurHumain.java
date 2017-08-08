package main.java;

import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;

public class JoueurHumain extends Joueur {
	public void choixNombre() {
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
	}
	
	

}
