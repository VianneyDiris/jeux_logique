package main.java;

public class RechercheCodeSecret {
	private JoueurHumain     humain     = new JoueurHumain();
	private JoueurOrdinateur ordinateur = new JoueurOrdinateur();
	ChallengerMode challenger = new ChallengerMode();
	
	public void challenger() {
		challenger.partieChallenger(humain, ordinateur);
	}

}
