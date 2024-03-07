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

    private final String INSERT_ARTICLE = "INSERT INTO ArticleVendu (nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_ARTICLE_BY_ID = "SELECT * FROM ArticleVendu WHERE id = ?";
    private final String SELECT_ALL_ARTICLES = "SELECT * FROM ArticleVendu";
    private final String UPDATE_ARTICLE = "UPDATE ArticleVendu SET nomArticle=?, description=?, dateDebutEncheres=?, dateFinEncheres=?, miseAPrix=?, prixVente=?, etatVente=? WHERE id=?";
    private final String DELETE_ARTICLE = "DELETE FROM ArticleVendu WHERE id=?";

    @Override
    public void save(ArticleVendu articleVendu) {
        jdbcTemplate.update(INSERT_ARTICLE, articleVendu.getNomArticle(), articleVendu.getDescription(), articleVendu.getDateDebutEncheres(), articleVendu.getDateFinEncheres(), articleVendu.getMiseAPrix(), articleVendu.getPrixVente(), articleVendu.getEtatVente());
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
        jdbcTemplate.update(UPDATE_ARTICLE, articleVendu.getNomArticle(), articleVendu.getDescription(), articleVendu.getDateDebutEncheres(), articleVendu.getDateFinEncheres(), articleVendu.getMiseAPrix(), articleVendu.getPrixVente(), articleVendu.getEtatVente());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_ARTICLE, id);
    }

    private static final class ArticleVenduMapper implements RowMapper<ArticleVendu> {
        public ArticleVendu mapRow(ResultSet rs, int rowNum) throws SQLException {
            ArticleVendu articleVendu = new ArticleVendu();
            articleVendu.setNoArticle(rs.getInt("noArticle"));
            articleVendu.setNomArticle(rs.getString("nomArticle"));
            articleVendu.setDescription(rs.getString("description"));
            articleVendu.setDateDebutEncheres(rs.getTimestamp("dateDebutEncheres").toLocalDateTime().toLocalDate());
            articleVendu.setDateFinEncheres(rs.getTimestamp("dateFinEncheres").toLocalDateTime().toLocalDate());
            articleVendu.setMiseAPrix(rs.getInt("miseAPrix"));
            articleVendu.setPrixVente(rs.getInt("prixVente"));
            articleVendu.setEtatVente(rs.getString("etatVente"));
            return articleVendu;
        }
    }

}
