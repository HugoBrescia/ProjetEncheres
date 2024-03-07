package fr.eni.projetEnchereHugo.dal.impl;

import fr.eni.projetEnchereHugo.bo.Categorie;
import fr.eni.projetEnchereHugo.dal.CategorieDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategorieDAOImpl implements CategorieDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_CATEGORIE = "INSERT INTO Categorie (libelle) VALUES (?)";
    private final String SELECT_CATEGORIE_BY_ID = "SELECT * FROM Categorie WHERE id = ?";
    private final String UPDATE_CATEGORIE = "UPDATE Categorie SET libelle=? WHERE id=?";
    private final String DELETE_CATEGORIE = "DELETE FROM Categorie WHERE id=?";
    private final String SELECT_ALL_CATEGORIES = "SELECT * FROM Categorie";

    @Override
    public void save(Categorie categorie) {
        jdbcTemplate.update(INSERT_CATEGORIE, categorie.getLibelle());
    }

    @Override
    public Categorie getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_CATEGORIE_BY_ID, new CategorieMapper(), id);
    }

    @Override
    public void update(Categorie categorie) {
        jdbcTemplate.update(UPDATE_CATEGORIE, categorie.getLibelle());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_CATEGORIE, id);
    }

    @Override
    public List<Categorie> getAll() {
        return jdbcTemplate.query(SELECT_ALL_CATEGORIES, new CategorieMapper());
    }

    private static final class CategorieMapper implements RowMapper<Categorie> {
        public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Categorie categorie = new Categorie();
            categorie.setNoCategorie(rs.getInt("noCategorie"));
            categorie.setLibelle(rs.getString("libelle"));
            return categorie;
        }
    }
}
