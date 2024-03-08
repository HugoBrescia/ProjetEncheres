package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.ArticleVenduService;
import fr.eni.projetEnchereHugo.bo.ArticleVendu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleVenduController {

    private final ArticleVenduService articleVenduService;

    @Autowired
    public ArticleVenduController(ArticleVenduService articleVenduService) {
        this.articleVenduService = articleVenduService;
    }

    @GetMapping("/articles")
    public String listerArticles(Model model) {
        model.addAttribute("articles", articleVenduService.getAll());
        return "liste-encheres";
    }

    @GetMapping("/article/{id}")
    public String afficherArticle(@PathVariable(name  ="id" ) int id, Model model) {
        ArticleVendu article = articleVenduService.getById(id);
        if (article == null) {
            return "redirect:/liste-encheres";
        }
        model.addAttribute("article", article);
        return "detail-vente"; 
    }

    @GetMapping("/Article/ajouter")
    public String afficherFormAjoutArticle(Model model) {
        model.addAttribute("article", new ArticleVendu());
        return "creation-vente";
    }

    @PostMapping("/Article/ajouter")
    public String ajouterArticle(@Validated @ModelAttribute ArticleVendu article, BindingResult result) {
        if (result.hasErrors()) {
            return "creation-vente";
        }
        articleVenduService.save(article);
        return "redirect:/liste-encheres";
    }


    @GetMapping("/Article/modifier/{id}")
    public String afficherFormModifierArticle(@PathVariable int id, Model model) {
        ArticleVendu article = articleVenduService.getById(id);
        if (article == null) {
            return "redirect:/liste-encheres";
        }
        model.addAttribute("article", article);
        return "modification-vente"; 
    }

    @PostMapping("/Article/modifier")
    public String modifierArticle(@ModelAttribute ArticleVendu article) {
        articleVenduService.update(article);
        return "redirect:/liste-encheres";
    }

    @GetMapping("/Article/supprimer/{id}")
    public String supprimerArticle(@PathVariable int id) {
        articleVenduService.delete(id);
        return "redirect:/liste-encheres";
    }
}
