package fr.eni.projetEnchereHugo.repository;

import fr.eni.projetEnchereHugo.bo.Enchere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class EnchereRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Enchere> rowMapper = (rs, rowNum) -> {
        Enchere enchere = new Enchere();
        enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
        enchere.setNoArticle(rs.getInt("no_article"));
        enchere.setDateEnchere(rs.getTimestamp("date_enchere").toLocalDateTime());
        enchere.setMontantEnchere(rs.getInt("montant_enchere"));
        return enchere;
    };

    public List<Enchere> findAll() {
        String sql = "SELECT * FROM ENCHERES";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @SuppressWarnings("deprecation")
	public Enchere findById(int id) {
        String sql = "SELECT * FROM ENCHERES WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public void save(Enchere enchere) {
        String sql = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, enchere.getNoUtilisateur(), enchere.getNoArticle(),
                            Timestamp.valueOf(enchere.getDateEnchere()), enchere.getMontantEnchere());
    }

    public void update(Enchere enchere) {
        String sql = "UPDATE ENCHERES SET no_utilisateur = ?, no_article = ?, date_enchere = ?, montant_enchere = ? WHERE id = ?";
        jdbcTemplate.update(sql, enchere.getNoUtilisateur(), enchere.getNoArticle(),
                            Timestamp.valueOf(enchere.getDateEnchere()), enchere.getMontantEnchere(),
                            enchere.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM ENCHERES WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
