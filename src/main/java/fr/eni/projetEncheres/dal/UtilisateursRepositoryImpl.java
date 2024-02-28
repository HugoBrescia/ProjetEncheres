package fr.eni.projetEncheres.dal;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.exceptions.UtilisateurNotFound;


@Repository
public class UtilisateursRepositoryImpl implements UtilisateurRepository{

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	
	
}
