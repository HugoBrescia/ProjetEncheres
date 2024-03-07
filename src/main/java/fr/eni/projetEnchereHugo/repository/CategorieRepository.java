package fr.eni.projetEnchereHugo.repository;

import fr.eni.projetEnchereHugo.bo.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategorieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Categorie> rowMapper = (rs, rowNum) -> {
        Categorie categorie = new Categorie();
        categorie.setNoCategorie(rs.getInt("no_categorie"));
        categorie.setLibelle(rs.getString("libelle"));
        return categorie;
    };

    public List<Categorie> findAll() {
        String sql = "SELECT * FROM CATEGORIES";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @SuppressWarnings("deprecation")
	public Categorie findById(int id) {
        String sql = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public void save(Categorie categorie) {
        String sql = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
        jdbcTemplate.update(sql, categorie.getLibelle());
    }

    public void delete(int id) {
        String sql = "DELETE FROM CATEGORIES WHERE no_categorie = ?";
        jdbcTemplate.update(sql, id);
    }
}
