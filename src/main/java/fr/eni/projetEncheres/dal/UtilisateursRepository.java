package fr.eni.projetEncheres.dal;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.exceptions.UtilisateurNotFound;

public interface UtilisateursRepository {

	public Utilisateur saveCompte(Utilisateur utilisateur)throws UtilisateurNotFound; // create + update !!
	
	
	
}
