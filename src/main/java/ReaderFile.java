package main.java;
import java.util.ResourceBundle;
/**
 * @author vianney
 * @version 0.2
 *classe permettant de récupérer les informations du config.properties
 */
public class ReaderFile {
	ResourceBundle bundle = ResourceBundle.getBundle("main.resources.config");
	
	/**
	 *fonction qui permet de récupérer la taille du nombre
	 *@return taille du nombre
	 */
	public int getNbCase () {
		String nbCase = bundle.getString("nombre.case");
	return Integer.parseInt(nbCase);
	}
	
	/**
	 *fonction qui permet de récupérer le nombre de coups possible
	 *@return nombre d'essai
	 */
	public int getNbEssai () {
		String nbEssai = bundle.getString("nombre.essai");
	return Integer.parseInt(nbEssai);
	}
	
	/**
	 *fonction qui permet de récupérer le plus grand nombre pour le mastermind
	 *@return chiffre max du mastermind
	 */
	public int getNbChiffre () {
		String nbChiffre = bundle.getString("nombre.chiffre");
	return Integer.parseInt(nbChiffre);
	}
	
	/**
	 *fonction qui permet de savoir si le mode développeur est activé
	 *@return true si le mode développeur est activé
	 *@return false si il n'est pas activé
	 */
	public boolean getModeDeveloppeur() {
		if(bundle.getString("mode.developpeur").equals("oui")) {
			return true;
		}
		else {
			return false;
		}
	}
}
