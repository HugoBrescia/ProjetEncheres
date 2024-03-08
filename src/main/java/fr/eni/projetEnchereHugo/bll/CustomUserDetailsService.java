package fr.eni.projetEnchereHugo.bll;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.projetEnchereHugo.bo.Utilisateur;
import fr.eni.projetEnchereHugo.dal.UtilisateurDAO;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.err.println("------------ ici -------------");
        Utilisateur utilisateur = utilisateurDAO.findByUsername(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("L'utilisateur n'a pas été trouvé");
        }
        return new User(utilisateur.getPseudo(), utilisateur.getMotDePasse(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}

