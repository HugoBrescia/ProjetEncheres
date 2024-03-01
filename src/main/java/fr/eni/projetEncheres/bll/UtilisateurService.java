package fr.eni.projetEncheres.bll;



import java.util.Optional;

import org.springframework.stereotype.Service;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.exceptions.UtilisateurNotFoundRuntimeException;


@Service
public interface UtilisateurService {

	
	public void saveUtilisateur(Utilisateur utilisateur) throws UtilisateurNotFoundRuntimeException;
	
	public Optional<Utilisateur> findUtilisateur(String identifiant);

	public boolean isUsernameUnique(String pseudo);

	public boolean isEmailUnique(String email);
		


}