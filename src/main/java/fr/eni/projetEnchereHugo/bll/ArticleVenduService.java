package fr.eni.projetEnchereHugo.bll;

import fr.eni.projetEnchereHugo.bo.ArticleVendu;
import fr.eni.projetEnchereHugo.dal.ArticleVenduDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleVenduService {

    @Autowired
    private ArticleVenduDAO articleVenduDAO;

    public void save(ArticleVendu articleVendu) {
        articleVenduDAO.save(articleVendu);
    }

    public ArticleVendu getById(int id) {
        return articleVenduDAO.getById(id);
    }

    public List<ArticleVendu> getAll() {
        return articleVenduDAO.getAll();
    }

    public void update(ArticleVendu articleVendu) {
        articleVenduDAO.update(articleVendu);
    }

    public void delete(int id) {
        articleVenduDAO.delete(id);
    }
}
