package fr.eni.projetEnchereHugo.bll;

import fr.eni.projetEnchereHugo.bo.Utilisateur;
import fr.eni.projetEnchereHugo.dal.UtilisateurDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurDAO utilisateurDAO;

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.save(utilisateur);
    }

    public Utilisateur obtenirUtilisateurParId(int id) {
        return utilisateurDAO.getById(id);
    }

    public void mettreAJourUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.update(utilisateur);
    }

    public void supprimerUtilisateur(int id) {
        utilisateurDAO.delete(id);
    }

    public List<Utilisateur> listerTousLesUtilisateurs() {
        return utilisateurDAO.getAll();
    }

    public Utilisateur trouverParNomUtilisateur(String pseudo) {
        return utilisateurDAO.findByUsername(pseudo);
    }
}
