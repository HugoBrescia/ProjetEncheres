package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.UtilisateurService;
import fr.eni.projetEnchereHugo.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/Inscription")
    public String afficherFormInscription(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "Inscription"; // nom du fichier HTML dans src/main/resources/templates
    }

    @PostMapping("/Inscription")
    public String ajouterUtilisateur(@ModelAttribute Utilisateur utilisateur) {
        utilisateurService.ajouterUtilisateur(utilisateur);
        return "redirect:/Utilisateur"; // redirige vers la liste des utilisateurs après l'inscription
    }

    @GetMapping("/Utilisateurs")
    public String listerUtilisateurs(Model model) {
        model.addAttribute("utilisateurs", utilisateurService.listerTousLesUtilisateurs());
        return "Liste-utilisateur"; // nom du fichier HTML dans src/main/resources/templates
    }

    @GetMapping("/Utilisateurs/{id}")
    public String afficherUtilisateur(@PathVariable int id, Model model) {
        Utilisateur utilisateur = utilisateurService.obtenirUtilisateurParId(id);
        model.addAttribute("utilisateur", utilisateur);
        return "Afficher-profil-utilisateur"; // nom du fichier HTML dans src/main/resources/templates
    }

    @GetMapping("/Utilisateurs/{id}/edit")
    public String afficherFormEdition(@PathVariable int id, Model model) {
        Utilisateur utilisateur = utilisateurService.obtenirUtilisateurParId(id);
        model.addAttribute("utilisateur", utilisateur);
        return "Affichage-profil-utilisateur"; // nom du fichier HTML dans src/main/resources/templates
    }

    @PostMapping("/Utilisateurs/{id}/edit")
    public String mettreAJourUtilisateur(@PathVariable int id, @ModelAttribute Utilisateur utilisateur) {
        utilisateur.setNoUtilisateur(id); // Assurez-vous que l'ID est défini correctement pour la mise à jour
        utilisateurService.mettreAJourUtilisateur(utilisateur);
        return "redirect:/Utilisateurs"; // redirige vers la liste des utilisateurs après la mise à jour
    }

    @PostMapping("/Utilisateurs/{id}/delete")
    public String supprimerUtilisateur(@PathVariable int id) {
        utilisateurService.supprimerUtilisateur(id);
        return "redirect:/Utilisateurs"; // redirige vers la liste des utilisateurs après la suppression
    }

}
