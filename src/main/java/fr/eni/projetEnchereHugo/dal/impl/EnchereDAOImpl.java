package fr.eni.projetEnchereHugo.dal.impl;

import fr.eni.projetEnchereHugo.bo.Enchere;
import fr.eni.projetEnchereHugo.dal.EnchereDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class EnchereDAOImpl implements EnchereDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_ENCHERE = "INSERT INTO Enchere (dateEnchere, montantEnchere) VALUES (?, ?)";
    private final String SELECT_ENCHERE_BY_ID = "SELECT * FROM Enchere WHERE id = ?";
    private final String UPDATE_ENCHERE = "UPDATE Enchere SET dateEnchere=?, montantEnchere=? WHERE id=?";
    private final String DELETE_ENCHERE = "DELETE FROM Enchere WHERE id=?";
    private final String SELECT_ALL_ENCHERES = "SELECT * FROM Enchere";

    @Override
    public void save(Enchere enchere) {
        jdbcTemplate.update(INSERT_ENCHERE, enchere.getDateEnchere(), enchere.getMontantEnchere());
    }

    @Override
    public Enchere getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_ENCHERE_BY_ID, (rs, rowNum) -> mapRowToEnchere(rs), id);
    }

    @Override
    public void update(Enchere enchere) {
        jdbcTemplate.update(UPDATE_ENCHERE, enchere.getDateEnchere(), enchere.getMontantEnchere());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_ENCHERE, id);
    }

    @Override
    public List<Enchere> getAll() {
        return jdbcTemplate.query(SELECT_ALL_ENCHERES, (rs, rowNum) -> mapRowToEnchere(rs));
    }

    private Enchere mapRowToEnchere(ResultSet rs) throws SQLException {
        Enchere enchere = new Enchere();
        java.sql.Date dateEnchereSQL = rs.getDate("dateEnchere");
        if (dateEnchereSQL != null) {
            LocalDate dateEnchere = dateEnchereSQL.toLocalDate();
            enchere.setDateEnchere(dateEnchere.atStartOfDay());
        } else {
            enchere.setDateEnchere(null); // Gérer le cas où la date est nulle
        }
        enchere.setMontantEnchere(rs.getInt("montantEnchere"));
        return enchere;
    }
}
