package main.java;

import org.apache.log4j.Logger;

/**
 * @author vianney
 * @version 0.2
 *classe permettant de lancer le jeu
 */
public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menu menu = new Menu();
		menu.menuJeu();
	
		
		

	}

}
