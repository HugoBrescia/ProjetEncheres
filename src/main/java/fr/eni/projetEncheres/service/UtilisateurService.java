package fr.eni.projetEncheres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public boolean isUsernameUnique(String username) {
		User utilisateurExistant = utilisateurRepository.findByUsername(username);
		return utilisateurExistant == null;
	}
	
	public boolean isEmailUnique(String email) {
		User utilisateurExistant = utilisateurRepository.findByEmail(email);
		return utilisateurExistant == null;
	}

	public void saveUtilisateur(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
	}

}