package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.bll.RetraitService;
import fr.eni.projetEnchereHugo.bo.Retrait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class RetraitController {

    private final RetraitService retraitService;

    @Autowired
    public RetraitController(RetraitService retraitService) {
        this.retraitService = retraitService;
    }

    @GetMapping("/retraits")
    public String listerRetraits(Model model) {
        model.addAttribute("retraits", retraitService.listerTousLesRetraits());
        return "liste_retraits"; 
    }

    @GetMapping("/retraits/{id}")
    public String afficherRetrait(@PathVariable int id, Model model) {
        Retrait retrait = retraitService.obtenirRetraitParId(id);
        model.addAttribute("retrait", retrait);
        return "details_retrait";
    }

    @GetMapping("/retraits/ajouter")
    public String afficherFormAjoutRetrait(Model model) {
        model.addAttribute("retrait", new Retrait());
        return "ajout_retrait"; 
    }

    @PostMapping("/retraits/ajouter")
    public String ajouterRetrait(@Validated @ModelAttribute Retrait retrait, BindingResult result) {
        if (result.hasErrors()) {
            return "ajout_retrait";
        }
        retraitService.ajouterRetrait(retrait);
        return "redirect:/retraits";
    }

    @GetMapping("/retraits/modifier/{id}")
    public String afficherFormModificationRetrait(@PathVariable int id, Model model) {
        Retrait retrait = retraitService.obtenirRetraitParId(id);
        model.addAttribute("retrait", retrait);
        return "modification_retrait"; 
    }

    @PostMapping("/retraits/modifier/{id}")
    public String modifierRetrait(@PathVariable int id, @ModelAttribute Retrait retrait) {
        retraitService.mettreAJourRetrait(retrait);
        return "redirect:/retraits"; 
    }

    @GetMapping("/retraits/supprimer/{id}")
    public String supprimerRetrait(@PathVariable int id) {
        retraitService.supprimerRetrait(id);
        return "redirect:/retraits";
    }
}
