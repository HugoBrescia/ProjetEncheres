package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.CategorieService;
import fr.eni.projetEnchereHugo.bo.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategorieController {

    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/Categories")
    public String listerCategories(Model model) {
        List<Categorie> categories = categorieService.listerToutesLesCategories();
        model.addAttribute("categories", categories);
        return "Liste-categorie"; // nom du fichier HTML dans src/main/resources/templates
    }

    @GetMapping("/Categories/{id}")
    public String afficherCategorie(@PathVariable int id, Model model) {
        Categorie categorie = categorieService.obtenirCategorieParId(id);
        model.addAttribute("categorie", categorie);
        return "Details-categorie"; // nom du fichier HTML dans src/main/resources/templates
    }

    @GetMapping("/Categories/ajouter")
    public String afficherFormAjoutCategorie(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "Ajouter-categorie"; // nom du fichier HTML dans src/main/resources/templates
    }

    @PostMapping("/Categories/ajouter")
    public String ajouterCategorie(@ModelAttribute Categorie categorie) {
        categorieService.ajouterCategorie(categorie);
        return "redirect:/Categories";
    }

    @GetMapping("/Categories/modifier/{id}")
    public String afficherFormModifierCategorie(@PathVariable int id, Model model) {
        Categorie categorie = categorieService.obtenirCategorieParId(id);
        model.addAttribute("categorie", categorie);
        return "Modifier-categorie"; // nom du fichier HTML dans src/main/resources/templates
    }

    @PostMapping("/Categories/modifier/{id}")
    public String modifierCategorie(@PathVariable int id, @ModelAttribute Categorie categorie) {
        categorie.setNoCategorie(id);
        categorieService.mettreAJourCategorie(categorie);
        return "redirect:/Categories";
    }

    @GetMapping("/Categories/supprimer/{id}")
    public String supprimerCategorie(@PathVariable int id) {
        categorieService.supprimerCategorie(id);
        return "redirect:/Categories";
    }
}
