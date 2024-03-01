package fr.eni.projetEncheres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.projetEncheres.bll.ConnexionService;

@Controller
public class ConnexionController {
	
	private final ConnexionService connexionService;
	
	@Autowired
	public ConnexionController(ConnexionService connexionService) {
		this.connexionService = connexionService;
	}
	
	@PostMapping("/se-connecter")
	public String connexionRequete(@RequestParam("pseudo") String pseudo, @RequestParam("motDePasse") String motDePasse) {
		if (connexionService.authentificationUtilisateur(pseudo, motDePasse)) {
			return "index-connecte";
		} else {
			return "se-connecter";
		}
	}
	
}
