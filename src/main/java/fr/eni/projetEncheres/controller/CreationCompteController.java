package fr.eni.projetEncheres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.service.UtilisateurService;

@Controller
public class CreationCompteController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "register";
	}
	
	@PostMapping("/register")
    public String registerUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        // Vérification pseudo unique
        if (!utilisateurService.isUsernameUnique(utilisateur.getUsername())) {
            model.addAttribute("usernameError", "Ce pseudo est déjà utilisé.");
            return "register";
        }

        // Vérification email unique
        if (!utilisateurService.isEmailUnique(utilisateur.getEmail())) {
            model.addAttribute("emailError", "Cet email est déjà utilisé.");
            return "register";
        }

        // Sauvegarde
        utilisateurService.saveUtilisateur(utilisateur);

        return "redirect:/home"; // Redirige vers la page d'accueil
    }
}
