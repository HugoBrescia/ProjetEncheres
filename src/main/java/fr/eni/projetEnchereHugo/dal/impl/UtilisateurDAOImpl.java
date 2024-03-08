package fr.eni.projetEnchereHugo.dal.impl;

import fr.eni.projetEnchereHugo.bo.Utilisateur;
import fr.eni.projetEnchereHugo.dal.UtilisateurDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SELECT_ALL_UTILISATEURS = "SELECT * FROM Utilisateurs";
    private final String INSERT_UTILISATEUR = "INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_UTILISATEUR_BY_ID = "SELECT * FROM Utilisateurs WHERE noUtilisateur = ?";
    private final String UPDATE_UTILISATEUR = "UPDATE Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, codePostal = ?, ville = ?, motDePasse = ?, credit = ?, administrateur = ? WHERE noUtilisateur = ?";
    private final String DELETE_UTILISATEUR = "DELETE FROM Utilisateurs WHERE noUtilisateur = ?";

    private static final class UtilisateurMapper implements RowMapper<Utilisateur> {
        public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
            utilisateur.setPseudo(rs.getString("pseudo"));
            utilisateur.setNom(rs.getString("nom"));
            utilisateur.setPrenom(rs.getString("prenom"));
            utilisateur.setEmail(rs.getString("email"));
            utilisateur.setTelephone(rs.getString("telephone"));
            utilisateur.setRue(rs.getString("rue"));
            utilisateur.setCodePostal(rs.getString("code_postal"));
            utilisateur.setVille(rs.getString("ville"));
            utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
            utilisateur.setCredit(rs.getInt("credit"));
            utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
            return utilisateur;
        }
    }

    @Override
    public void save(Utilisateur utilisateur) {
        jdbcTemplate.update(INSERT_UTILISATEUR, 
            utilisateur.getPseudo(), 
            utilisateur.getNom(),
            utilisateur.getPrenom(),
            utilisateur.getEmail(),
            utilisateur.getTelephone(),
            utilisateur.getRue(),
            utilisateur.getCodePostal(),
            utilisateur.getVille(),
            utilisateur.getMotDePasse(),
            utilisateur.getCredit(),
            utilisateur.isAdministrateur()
        );
    }

    @Override
    public Utilisateur getById(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_UTILISATEUR_BY_ID, new UtilisateurMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }



    @Override
    public List<Utilisateur> getAll() {
        return jdbcTemplate.query(SELECT_ALL_UTILISATEURS, new UtilisateurMapper());
    }

    @Override
    public void update(Utilisateur utilisateur) {
        jdbcTemplate.update(UPDATE_UTILISATEUR, 
            utilisateur.getPseudo(), 
            utilisateur.getNom(),
            utilisateur.getPrenom(),
            utilisateur.getEmail(),
            utilisateur.getTelephone(),
            utilisateur.getRue(),
            utilisateur.getCodePostal(),
            utilisateur.getVille(),
            utilisateur.getMotDePasse(),
            utilisateur.getCredit(),
            utilisateur.isAdministrateur(),
            utilisateur.getNoUtilisateur()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_UTILISATEUR, id);
    }

    @Override
    public Utilisateur findByUsername(String username) {
        try {
            String query = "SELECT * FROM Utilisateurs WHERE pseudo = ?";
            return jdbcTemplate.queryForObject(query, new UtilisateurMapper(), username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    

}
