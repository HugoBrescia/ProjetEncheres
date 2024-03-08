package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.ArticleVenduService;
import fr.eni.projetEnchereHugo.bo.ArticleVendu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private ArticleVenduService articleVenduService;

    @GetMapping("/")
    public String index(Model model) {
    	List<ArticleVendu> vendus = articleVenduService.getAll();
        model.addAttribute("encheres", vendus);
        return "index";
    }
}
