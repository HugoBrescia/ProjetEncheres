package fr.eni.projetEncheres.dal;

import java.util.Optional;



import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.exceptions.UtilisateurNotFoundRuntimeException;

public interface UtilisateurRepository {


	public Utilisateur save(Utilisateur utilisateur) throws UtilisateurNotFoundRuntimeException;

	Optional<Utilisateur> findUtilisateur(String identifiant);

	boolean isUsernameUnique(String pseudo);

	boolean isEmailUnique(String email);

}
