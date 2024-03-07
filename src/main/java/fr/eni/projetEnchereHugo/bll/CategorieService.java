package fr.eni.projetEnchereHugo.bll;

import fr.eni.projetEnchereHugo.bo.Categorie;
import fr.eni.projetEnchereHugo.dal.CategorieDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {

    @Autowired
    private CategorieDAO categorieDAO;

    public void ajouterCategorie(Categorie categorie) {
        categorieDAO.save(categorie);
    }

    public Categorie obtenirCategorieParId(int id) {
        return categorieDAO.getById(id);
    }

    public void mettreAJourCategorie(Categorie categorie) {
        categorieDAO.update(categorie);
    }

    public void supprimerCategorie(int id) {
        categorieDAO.delete(id);
    }

    public List<Categorie> listerToutesLesCategories() {
        return categorieDAO.getAll();
    }
}
