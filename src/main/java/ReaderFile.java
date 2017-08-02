package main.java;
import java.util.ResourceBundle;

public class ReaderFile {
	ResourceBundle bundle = ResourceBundle.getBundle("main.resources.config");
	
	public int getNbCase () {
		String nbCase = bundle.getString("nombre.case");
	return Integer.parseInt(nbCase);
	}
	
	public int getNbEssai () {
		String nbEssai = bundle.getString("nombre.essai");
	return Integer.parseInt(nbEssai);
	}
	
	public int getNbChiffre () {
		String nbChiffre = bundle.getString("nombre.chiffre");
	return Integer.parseInt(nbChiffre);
	}
}
