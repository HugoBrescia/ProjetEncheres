package fr.eni.projetEnchereHugo.repository;

import fr.eni.projetEnchereHugo.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilisateurRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Utilisateur> rowMapper = (rs, rowNum) -> {
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
    };

    public List<Utilisateur> findAll() {
        String sql = "SELECT * FROM UTILISATEURS";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @SuppressWarnings("deprecation")
	public Utilisateur findById(Integer id) {
        String sql = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    public void save(Utilisateur utilisateur) {
        String sql = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille(), utilisateur.getMotDePasse(), utilisateur.getCredit(), utilisateur.isAdministrateur());
    }

    public void update(Utilisateur utilisateur) {
        String sql = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?";
        jdbcTemplate.update(sql, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille(), utilisateur.getMotDePasse(), utilisateur.getCredit(), utilisateur.isAdministrateur(), utilisateur.getNoUtilisateur());
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
        jdbcTemplate.update(sql, id);
    }

}
