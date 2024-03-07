package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.ArticleVenduService;
import fr.eni.projetEnchereHugo.bo.ArticleVendu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleVenduController {

    private final ArticleVenduService articleVenduService;

    @Autowired
    public ArticleVenduController(ArticleVenduService articleVenduService) {
        this.articleVenduService = articleVenduService;
    }

    @GetMapping("/Articles")
    public String listerArticles(Model model) {
        model.addAttribute("articles", articleVenduService.getAll());
        return "Liste-article"; // nom du fichier HTML dans src/main/resources/templates
    }

    @GetMapping("/Article/{id}")
    public String afficherArticle(@PathVariable int id, Model model) {
        ArticleVendu article = articleVenduService.getById(id);
        if (article == null) {
            return "redirect:/Articles";
        }
        model.addAttribute("article", article);
        return "Detail-vente"; // nom du fichier HTML dans src/main/resources/templates
    }

    @GetMapping("/Article/ajouter")
    public String afficherFormAjoutArticle(Model model) {
        model.addAttribute("article", new ArticleVendu());
        return "Creation-vente"; // nom du fichier HTML dans src/main/resources/templates
    }

    @PostMapping("/Article/ajouter")
    public String ajouterArticle(@ModelAttribute ArticleVendu article) {
        articleVenduService.save(article);
        return "redirect:/Articles";
    }

    @GetMapping("/Article/modifier/{id}")
    public String afficherFormModifierArticle(@PathVariable int id, Model model) {
        ArticleVendu article = articleVenduService.getById(id);
        if (article == null) {
            return "redirect:/Articles";
        }
        model.addAttribute("article", article);
        return "Modification-vente"; // nom du fichier HTML dans src/main/resources/templates
    }

    @PostMapping("/Article/modifier")
    public String modifierArticle(@ModelAttribute ArticleVendu article) {
        articleVenduService.update(article);
        return "redirect:/Articles";
    }

    @GetMapping("/Article/supprimer/{id}")
    public String supprimerArticle(@PathVariable int id) {
        articleVenduService.delete(id);
        return "redirect:/Articles";
    }
}
