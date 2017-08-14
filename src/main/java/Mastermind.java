package main.java;

public class Mastermind {
	private JoueurHumain     humain     = new JoueurHumain();
	private JoueurOrdinateur ordinateur = new JoueurOrdinateur();
	private JoueurHumain     humain2     = new JoueurHumain();
	private JoueurOrdinateur ordinateur2 = new JoueurOrdinateur();
	private ChallengerMode   challenger = new ChallengerMode();
	private DefenseurMode    defenseur  = new DefenseurMode();
	private DuelMode         duel       = new DuelMode();
	
	public void challenger() {
		challenger.challenger(humain, ordinateur);
	}
	
	public void defenseur() {
		defenseur.partieDefenseur(humain, ordinateur);
	}
	
	public void duel() {
		duel.partieDuel(humain, ordinateur, humain2, ordinateur2);
	}


}
