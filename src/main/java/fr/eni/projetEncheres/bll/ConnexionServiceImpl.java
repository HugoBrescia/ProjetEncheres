package fr.eni.projetEncheres.bll;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.UtilisateurRepository;

@Service
public class ConnexionServiceImpl implements ConnexionService {

	@Autowired
    private UtilisateurRepository utilisateurRepository;
	
	@Override
	public boolean authentificationUtilisateur(String pseudo, String motDePasse) {
	    Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findUtilisateur(pseudo);
	    if (utilisateurOptional.isPresent()) {
	        Utilisateur utilisateur = utilisateurOptional.get();
	        return utilisateur.getMotDePasse().equals(motDePasse);
	    }
	    return false;
	}

	
}
