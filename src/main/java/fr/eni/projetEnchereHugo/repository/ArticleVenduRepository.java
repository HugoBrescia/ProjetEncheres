package fr.eni.projetEnchereHugo.repository;

import fr.eni.projetEnchereHugo.bo.ArticleVendu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class ArticleVenduRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<ArticleVendu> rowMapper = (rs, rowNum) -> {
        ArticleVendu article = new ArticleVendu();
        article.setNoArticle(rs.getInt("no_article"));
        article.setNomArticle(rs.getString("nom_article"));
        article.setDescription(rs.getString("description"));
        article.setMiseAPrix(rs.getInt("prix_initial"));
        article.setDateDebutEncheres(rs.getTimestamp("date_debut_encheres").toLocalDateTime().toLocalDate());
        article.setDateFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime().toLocalDate());
        article.setNoUtilisateur(rs.getInt("no_utilisateur"));
        article.setNoCategorie(rs.getInt("no_categorie"));
        return article;
    };

    public List<ArticleVendu> findAll() {
        String sql = "SELECT * FROM ARTICLES_VENDUS";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @SuppressWarnings("deprecation")
	public ArticleVendu findById(int id) {
        String sql = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public void save(ArticleVendu article) {
        String sql = "INSERT INTO ARTICLES_VENDUS (nom_article, description, prix_initial, date_debut_encheres, date_fin_encheres, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, article.getNomArticle(), article.getDescription(), article.getMiseAPrix(), Timestamp.valueOf(article.getDateDebutEncheres().atStartOfDay()), Timestamp.valueOf(article.getDateFinEncheres().atStartOfDay()), article.getNoUtilisateur(), article.getNoCategorie());
    }

    public void update(ArticleVendu article) {
        String sql = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, prix_initial=?, date_debut_encheres=?, date_fin_encheres=?, no_utilisateur=?, no_categorie=? WHERE no_article=?";
        jdbcTemplate.update(sql, article.getNomArticle(), article.getDescription(), article.getMiseAPrix(), Timestamp.valueOf(article.getDateDebutEncheres().atStartOfDay()), Timestamp.valueOf(article.getDateFinEncheres().atStartOfDay()), article.getNoUtilisateur(), article.getNoCategorie(), article.getNoArticle());
    }

    public void delete(int id) {
        String sql = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";
        jdbcTemplate.update(sql, id);
    }

}
