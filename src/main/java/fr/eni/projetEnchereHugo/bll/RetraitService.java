package fr.eni.projetEnchereHugo.bll;

import fr.eni.projetEnchereHugo.bo.Retrait;
import fr.eni.projetEnchereHugo.dal.RetraitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetraitService {

    @Autowired
    private RetraitDAO retraitDAO;

    public void ajouterRetrait(Retrait retrait) {
        retraitDAO.save(retrait);
    }

    public Retrait obtenirRetraitParId(int id) {
        return retraitDAO.getById(id);
    }

    public void mettreAJourRetrait(Retrait retrait) {
        retraitDAO.update(retrait);
    }

    public void supprimerRetrait(int id) {
        retraitDAO.delete(id);
    }

    public List<Retrait> listerTousLesRetraits() {
        return retraitDAO.getAll();
    }
}
