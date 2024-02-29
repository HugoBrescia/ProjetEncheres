package fr.eni.projetEncheres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AffichageController {

	@GetMapping("/afficher-profil-utilisateur")
	public String afficherProfilUtilisateur() {
		return "afficher-profil-utilisateur";
	}
	
	@GetMapping("/affichage-profil")
	public String affichageProfil() {
		return "affichage-profil";
	}
	
	@GetMapping("/detail-vente")
	public String detailVente() {
		return "detail-vente";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/index-connecte")
	public String indexConnecte() {
		return "index-connecte";
	}
	
	@GetMapping("/inscription")
	public String inscription() {
		return "inscription";
	}
	
	@GetMapping("/modification-vente")
	public String modificationVente() {
		return "modification-vente";
	}
	
	@GetMapping("/modifier-profil")
	public String modifierProfil() {
		return "modifier-profil";
	}
	
	@GetMapping("/nouvelle-vente")
	public String nouvelleVente() {
		return "nouvelle-vente";
	}
	
	@GetMapping("/se-connecter")
	public String seConnecter() {
		return "se-connecter";
	}
	
	@GetMapping("/vente-remportee")
	public String venteRemportee() {
		return "vente-remportee";
	}
	
	@GetMapping("/vente-terminee")
	public String venteTerminee() {
		return "vente-terminee";
	}
	
}
