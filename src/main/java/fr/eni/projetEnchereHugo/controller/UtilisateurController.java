package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.UtilisateurService;
import fr.eni.projetEnchereHugo.bo.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/inscription")
    public String afficherFormInscription(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/inscription")
    public String ajouterUtilisateur(@Validated @ModelAttribute Utilisateur utilisateur, BindingResult result) {
        if (result.hasErrors()) {
            return "inscription";
        }
        String hashedPassword = passwordEncoder.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(hashedPassword);
        utilisateurService.ajouterUtilisateur(utilisateur);
        return "redirect:/utilisateurs/" + utilisateur.getNoUtilisateur() + "/profil";
    }

        @GetMapping("/se-connecter")
        public String login() {
            return "se-connecter";
        }

        @GetMapping("/login-error")
        public String loginError(Model model) {
            model.addAttribute("loginError", true);
            return "se-connecter";
        }
        
        @GetMapping("/logout")
        public String logout(HttpServletRequest request) {
            request.getSession().invalidate();
            return "redirect:/";
        }
    


    @GetMapping("/utilisateurs")
    public String listerUtilisateurs(Model model) {
        model.addAttribute("utilisateurs", utilisateurService.listerTousLesUtilisateurs());
        return "liste-utilisateurs";
    }

    @GetMapping("/utilisateurs/{id}/profil")
    public String afficherProfilUtilisateur(@PathVariable int id, Model model) {
        Utilisateur utilisateur = utilisateurService.obtenirUtilisateurParId(id);
        model.addAttribute("utilisateur", utilisateur);
        return "afficher-profil"; 
    }

    @GetMapping("/utilisateurs/{id}/edit")
    public String afficherFormEdition(@PathVariable int id, Model model) {
        Utilisateur utilisateur = utilisateurService.obtenirUtilisateurParId(id);
        model.addAttribute("utilisateur", utilisateur);
        return "modifier-profil"; // 
    }

    @PostMapping("/Utilisateurs/{id}/edit")
    public String mettreAJourUtilisateur(@PathVariable int id, @ModelAttribute Utilisateur utilisateur) {
        utilisateur.setNoUtilisateur(id);
        utilisateurService.mettreAJourUtilisateur(utilisateur);
        return "redirect:/afficher-profil";
    }

    @PostMapping("/Utilisateurs/{id}/delete")
    public String supprimerUtilisateur(@PathVariable int id) {
        utilisateurService.supprimerUtilisateur(id);
        return "redirect:/afficher-profil";
    }
    
    @GetMapping("/afficher-profil")
    public String affichageProfilUtilisateur(Principal principal, Model model) {
        String username = principal.getName();
        Utilisateur utilisateur = utilisateurService.trouverParNomUtilisateur(username);
        model.addAttribute("utilisateur", utilisateur);
        return "afficher-profil";
    }
    
    
    
    
    

}
