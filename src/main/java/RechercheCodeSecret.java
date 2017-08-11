package main.java;

public class RechercheCodeSecret {
	private JoueurHumain     humain     = new JoueurHumain();
	private JoueurOrdinateur ordinateur = new JoueurOrdinateur();
	private ChallengerMode   challenger = new ChallengerMode();
	private DefenseurMode    defenseur  = new DefenseurMode();
	
	public void challenger() {
		challenger.partieChallenger(humain, ordinateur);
	}
	
	public void defenseur() {
		defenseur.partieDefenseur(humain, ordinateur);
	}

}
