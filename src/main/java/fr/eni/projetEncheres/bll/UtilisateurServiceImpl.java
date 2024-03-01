package fr.eni.projetEncheres.bll;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.UtilisateurRepository;
import fr.eni.projetEncheres.exceptions.UtilisateurNotFoundRuntimeException;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository =utilisateurRepository;
	}
	
	
	
	@Override
	public void saveUtilisateur(Utilisateur utilisateur) throws UtilisateurNotFoundRuntimeException {
		utilisateurRepository.save(utilisateur);
		
	}

	@Override
	public Optional<Utilisateur> findUtilisateur(String identifiant) {
		return utilisateurRepository.findUtilisateur(identifiant);
	}



	@Override
	public boolean isUsernameUnique(String pseudo) {
		return utilisateurRepository.isUsernameUnique(pseudo);
	}



	@Override
	public boolean isEmailUnique(String email) {
		return utilisateurRepository.isEmailUnique(email);
	}


	

}
