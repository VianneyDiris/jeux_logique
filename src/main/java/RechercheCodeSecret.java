package main.java;

/**
 * @author vianney
 * @version 0.1
 *classe permettant de jouer au Recherche +- en fonction du mode
 */
public class RechercheCodeSecret {
	private JoueurHumain     humain     = new JoueurHumain();
	private JoueurOrdinateur ordinateur = new JoueurOrdinateur();
	private JoueurHumain     humain2     = new JoueurHumain();
	private JoueurOrdinateur ordinateur2 = new JoueurOrdinateur();
	private ChallengerMode   challenger = new ChallengerMode();
	private DefenseurMode    defenseur  = new DefenseurMode();
	private DuelMode         duel       = new DuelMode();
	
	/**
	 *fonction qui permet de jouer au mode challenger du Recherche +-
	 *  
	 */
	public void challenger() {
		challenger.partieChallenger(humain, ordinateur);
	}
	
	/**
	 *fonction qui permet de jouer au mode defenseur du Recherche +-
	 *  
	 */
	public void defenseur() {
		defenseur.partieDefenseur(humain, ordinateur);
	}
	
	/**
	 *fonction qui permet de jouer au mode duel du Recherche +-
	 *  
	 */
	public void duel() {
		duel.partieDuel(humain, ordinateur, humain2, ordinateur2);
	}

}
