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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> optUtilisateur = UtilisateurRepository.findByUsername(username);
		if(optUtilisateur.isEmpty()) {
			throw new UsernameNotFoundException("utilisateur non trouve : "+username+" éssayez avec votre Email");
		}
	}
	
	@Override
	public UserDetails loadUserByEmail(String email) throws EmailNotFoundException {
		Optional<Utilisateur> optUtilisateur = UtilisateurRepository.findByEmail(email);
		if(optUtilisateur.isEmpty()) {
			throw new EmailNotFoundException("Email de l'utilisateur non trouve : "+email+" éssayez avec votre nom d'utilisateur (pseudo)");
		}
		
		
		Utilisateur utilisateur = optUtilisateur.get();
		
		 UserBuilder userBuilder = User.withUsername(utilisateur.getPseudo())
            .password(utilisateur.getMotDePasse())
            .roles("MEMBRE");
		 
		 if(utilisateur.isAdministrateur()) {
			 userBuilder.roles("ADMINISTRATEUR");
		 }	
		 UserDetails user = userBuilder.build();
		 
		
		return user;
	}

	
	
	
}
