package fr.eni.projetEncheres.dal;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import fr.eni.projetEncheres.bo.Utilisateur;

public interface UtilisateurRepository {

	public User findByUsername(String username);

	public User findByEmail(String email);

	public void save(Utilisateur utilisateur);

}
