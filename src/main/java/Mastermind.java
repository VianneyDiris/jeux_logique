package main.java;

/**
 * @author vianney
 * @version 0.1
 *classe permettant de jouer au mastermind en fonction du mode
 */
public class Mastermind {
	private JoueurHumain     humain     = new JoueurHumain();
	private JoueurOrdinateur ordinateur = new JoueurOrdinateur();
	private JoueurHumain     humain2     = new JoueurHumain();
	private JoueurOrdinateur ordinateur2 = new JoueurOrdinateur();
	private ChallengerMode   challenger = new ChallengerMode();
	private DefenseurMode    defenseur  = new DefenseurMode();
	private DuelMode         duel       = new DuelMode();
	
	/**
	 *fonction qui permet de jouer au mode challenger du Mastermind
	 *  
	 */
	public void challenger() {
		challenger.challenger(humain, ordinateur);
	}
	
	/**
	 *fonction qui permet de jouer au mode defenseur du Mastermind
	 *  
	 */
	public void defenseur() {
		defenseur.defenseur(humain, ordinateur);
	}
	
	/**
	 *fonction qui permet de jouer au mode duel du Mastermind
	 *  
	 */
	public void duel() {
		duel.partieDuel(humain, ordinateur, humain2, ordinateur2);
	}


}
