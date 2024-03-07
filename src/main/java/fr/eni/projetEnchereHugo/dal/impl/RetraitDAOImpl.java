package fr.eni.projetEnchereHugo.dal.impl;

import fr.eni.projetEnchereHugo.bo.Retrait;
import fr.eni.projetEnchereHugo.dal.RetraitDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RetraitDAOImpl implements RetraitDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_RETRAIT = "INSERT INTO Retrait (rue, codePostal, ville) VALUES (?, ?, ?)";
    private final String SELECT_RETRAIT_BY_ID = "SELECT * FROM Retrait WHERE id = ?";
    private final String UPDATE_RETRAIT = "UPDATE Retrait SET rue=?, codePostal=?, ville=? WHERE id=?";
    private final String DELETE_RETRAIT = "DELETE FROM Retrait WHERE id=?";
    private final String SELECT_ALL_RETRAITS = "SELECT * FROM Retrait";

    @Override
    public void save(Retrait retrait) {
        jdbcTemplate.update(INSERT_RETRAIT, retrait.getRue(), retrait.getCodePostal(), retrait.getVille());
    }

    @Override
    public Retrait getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_RETRAIT_BY_ID, new RetraitMapper(), id);
    }

    @Override
    public void update(Retrait retrait) {
        jdbcTemplate.update(UPDATE_RETRAIT, retrait.getRue(), retrait.getCodePostal(), retrait.getVille());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_RETRAIT, id);
    }

    @Override
    public List<Retrait> getAll() {
        return jdbcTemplate.query(SELECT_ALL_RETRAITS, new RetraitMapper());
    }

    private static final class RetraitMapper implements RowMapper<Retrait> {
        public Retrait mapRow(ResultSet rs, int rowNum) throws SQLException {
            Retrait retrait = new Retrait();
            retrait.setRue(rs.getString("rue"));
            retrait.setCodePostal(rs.getString("codePostal"));
            retrait.setVille(rs.getString("ville"));
            return retrait;
        }
    }
}
