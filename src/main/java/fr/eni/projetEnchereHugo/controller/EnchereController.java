package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.EnchereService;
import fr.eni.projetEnchereHugo.bo.Enchere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        return "detail-vente";
    }

    @GetMapping("/encheres/{id}/edit")
    public String afficherFormModifierEnchere(@PathVariable int id, Model model) {
        Enchere enchere = enchereService.obtenirEnchereParId(id);
        model.addAttribute("enchere", enchere);
        return "modifier-enchere"; 
    }

    @PostMapping("/encheres")
    public String ajouterEnchere(@Validated @ModelAttribute Enchere enchere, BindingResult result) {
        if (result.hasErrors()) {
            return "creation-vente"; 
        }
        enchereService.ajouterEnchere(enchere);
        return "redirect:/"; 
    }


    @PutMapping("/encheres/{id}")
    public String mettreAJourEnchere(@PathVariable int id, @ModelAttribute Enchere enchere) {
        enchereService.mettreAJourEnchere(id, enchere);
        return "redirect:/"; 
    }

    @DeleteMapping("/encheres/{id}")
    public String supprimerEnchere(@PathVariable int id) {
        enchereService.supprimerEnchere(id);
        return "redirect:/"; 
    }
}
