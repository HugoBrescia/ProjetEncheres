package fr.eni.projetEnchereHugo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VenteController {

	@GetMapping("/vente/nouvelle")
	public String afficherPageCreationVente() {
	    return "nouvelle-vente"; 
	}

	@GetMapping("/vente/{id}/modifier")
	public String afficherPageModificationVente(@PathVariable int id, Model model) {
	    return "modification-vente"; 
	}

    @GetMapping("/supprimer-vente")
    public String afficherPageSuppressionVente() {
        return "supprimer-vente";
    }
}
