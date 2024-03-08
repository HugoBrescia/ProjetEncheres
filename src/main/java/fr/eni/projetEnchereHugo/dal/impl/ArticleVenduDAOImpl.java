package fr.eni.projetEnchereHugo.dal.impl;

import fr.eni.projetEnchereHugo.bo.ArticleVendu;
import fr.eni.projetEnchereHugo.dal.ArticleVenduDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleVenduDAOImpl implements ArticleVenduDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_ARTICLE_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
    private final String SELECT_ALL_ARTICLES = "SELECT * FROM ARTICLES_VENDUS";
    private final String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=? WHERE no_article=?";
    private final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";

    @Override
    public void save(ArticleVendu articleVendu) {
        jdbcTemplate.update(INSERT_ARTICLE, articleVendu.getNomArticle(), articleVendu.getDescription(), articleVendu.getDateDebutEncheres(), articleVendu.getDateFinEncheres(), articleVendu.getMiseAPrix(), articleVendu.getPrixVente(), articleVendu.getNoUtilisateur(), articleVendu.getNoCategorie());
    }

    @Override
    public ArticleVendu getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_ARTICLE_BY_ID, new ArticleVenduMapper(), id);
    }

    @Override
    public List<ArticleVendu> getAll() {
        return jdbcTemplate.query(SELECT_ALL_ARTICLES, new ArticleVenduMapper());
    }

    @Override
    public void update(ArticleVendu articleVendu) {
        jdbcTemplate.update(UPDATE_ARTICLE, articleVendu.getNomArticle(), articleVendu.getDescription(), articleVendu.getDateDebutEncheres(), articleVendu.getDateFinEncheres(), articleVendu.getMiseAPrix(), articleVendu.getPrixVente(), articleVendu.getNoUtilisateur(), articleVendu.getNoCategorie(), articleVendu.getNoArticle());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_ARTICLE, id);
    }

    private static final class ArticleVenduMapper implements RowMapper<ArticleVendu> {
        public ArticleVendu mapRow(ResultSet rs, int rowNum) throws SQLException {
            ArticleVendu articleVendu = new ArticleVendu();
            articleVendu.setNoArticle(rs.getInt("no_article"));
            articleVendu.setNomArticle(rs.getString("nom_article"));
            articleVendu.setDescription(rs.getString("description"));
            articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
            articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
            articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
            articleVendu.setPrixVente(rs.getInt("prix_vente"));
            articleVendu.setNoUtilisateur(rs.getInt("no_utilisateur"));
            articleVendu.setNoCategorie(rs.getInt("no_categorie"));
            return articleVendu;
        }
    }
}
