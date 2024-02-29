package fr.eni.projetEncheres.dal;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import fr.eni.projetEncheres.bo.Utilisateur;

public interface UtilisateurRepository {


	public Utilisateur save(Utilisateur utilisateur);

	Optional<Utilisateur> findUtilisateur(String identifiant);

}
