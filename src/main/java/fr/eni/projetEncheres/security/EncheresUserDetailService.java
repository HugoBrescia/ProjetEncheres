package fr.eni.projetEncheres.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.UtilisateurRepository;
import fr.eni.projetEncheres.exceptions.EmailNotFoundException;

@Component
public class EncheresUserDetailService implements UserDetailsService{

	
	private UtilisateurRepository utilisateurRepository;
	
	
	public EncheresUserDetailService(UtilisateurRepository utilisateurRepository) {
		super();
		this.utilisateurRepository = utilisateurRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String identifiant) throws UsernameNotFoundException {
	    Optional<Utilisateur> optUtilisateur = utilisateurRepository.findUtilisateur(identifiant);
	    if(optUtilisateur.isEmpty()) {
	        throw new UsernameNotFoundException("Utilisateur non trouvé avec le nom d'utilisateur ou l'email : " + identifiant);
	    }
		
		
		Utilisateur utilisateur = optUtilisateur.get();
		
		 UserBuilder userBuilder = User.withUsername(utilisateur.getPseudo())
            .password(utilisateur.getMotDePasse())
            .roles("UTILISATEUR");
		 
		 if(utilisateur.isAdministrateur()) {
			 userBuilder.roles("ADMINISTRATEUR");
		 }	
		 UserDetails user = userBuilder.build();
		 
		
		return user;
	}

	
	
	
}
