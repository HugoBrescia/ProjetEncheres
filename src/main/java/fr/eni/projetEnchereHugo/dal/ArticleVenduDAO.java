package fr.eni.projetEnchereHugo.dal;

import fr.eni.projetEnchereHugo.bo.ArticleVendu;

import java.util.List;

public interface ArticleVenduDAO {
    void save(ArticleVendu articleVendu);
    ArticleVendu getById(int id);
    List<ArticleVendu> getAll();
    void update(ArticleVendu articleVendu);
    void delete(int id);
}
