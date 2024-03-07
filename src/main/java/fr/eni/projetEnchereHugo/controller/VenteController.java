package fr.eni.projetEnchereHugo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VenteController {

    @GetMapping("/creer-vente")
    public String afficherPageCreationVente() {
        return "creer-vente";
    }

    @GetMapping("/modifier-vente")
    public String afficherPageModificationVente() {
        return "modifier-vente";
    }

    @GetMapping("/supprimer-vente")
    public String afficherPageSuppressionVente() {
        return "supprimer-vente";
    }
}
