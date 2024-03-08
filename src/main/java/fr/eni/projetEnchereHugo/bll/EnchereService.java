package fr.eni.projetEnchereHugo.bll;

import fr.eni.projetEnchereHugo.bo.Enchere;
import fr.eni.projetEnchereHugo.dal.EnchereDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnchereService {

    @Autowired
    private EnchereDAO enchereDAO;

    public void ajouterEnchere(Enchere enchere) {
        enchereDAO.save(enchere);
    }

    public Enchere obtenirEnchereParId(int id) {
        return enchereDAO.getById(id);
    }

    public void mettreAJourEnchere(int id, Enchere enchere) {
        enchereDAO.update(enchere);
    }

    public void supprimerEnchere(int id) {
        enchereDAO.delete(id);
    }

    public List<Enchere> listerToutesLesEncheres() {
        return enchereDAO.getAll();
    }
}
