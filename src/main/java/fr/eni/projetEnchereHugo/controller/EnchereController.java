package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.EnchereService;
import fr.eni.projetEnchereHugo.bo.Enchere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EnchereController {

    private final EnchereService enchereService;

    @Autowired
    public EnchereController(EnchereService enchereService) {
        this.enchereService = enchereService;
    }

    @GetMapping("/encheres/{id}")
    public String obtenirEnchereParId(@PathVariable int id, Model model) {
        Enchere enchere = enchereService.obtenirEnchereParId(id);
        model.addAttribute("enchere", enchere);
        return "detail-vente"; // nom du fichier HTML dans src/main/resources/templates
    }

    @GetMapping("/encheres/{id}/edit")
    public String afficherFormModifierEnchere(@PathVariable int id, Model model) {
        Enchere enchere = enchereService.obtenirEnchereParId(id);
        model.addAttribute("enchere", enchere);
        return "modifier-enchere"; // nom du fichier HTML dans src/main/resources/templates
    }

    @PostMapping("/encheres")
    public String ajouterEnchere(@ModelAttribute Enchere enchere) {
        enchereService.ajouterEnchere(enchere);
        return "redirect:/"; // redirige vers la page d'accueil après l'ajout
    }

    @PutMapping("/encheres/{id}")
    public String mettreAJourEnchere(@PathVariable int id, @ModelAttribute Enchere enchere) {
        enchereService.mettreAJourEnchere(id, enchere);
        return "redirect:/"; // redirige vers la page d'accueil après la mise à jour
    }

    @DeleteMapping("/encheres/{id}")
    public String supprimerEnchere(@PathVariable int id) {
        enchereService.supprimerEnchere(id);
        return "redirect:/"; // redirige vers la page d'accueil après la suppression
    }
}
