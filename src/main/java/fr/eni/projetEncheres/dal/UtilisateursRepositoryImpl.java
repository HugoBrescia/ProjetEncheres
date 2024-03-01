package fr.eni.projetEncheres.dal;

import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.exceptions.UtilisateurNotFound;
import fr.eni.projetEncheres.exceptions.UtilisateurNotFoundRuntimeException;

@Repository
public class UtilisateursRepositoryImpl implements UtilisateurRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private PasswordEncoder passwordEncoder;

	public UtilisateursRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate,
			PasswordEncoder passwordEncoder) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.passwordEncoder = passwordEncoder;
	}

	public NamedParameterJdbcTemplate getNamedParameterjdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterjdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Optional<Utilisateur> findUtilisateur(String identifiant) {
		String sql = "SELECT * FROM utilisateurs WHERE pseudo = ? OR email = ?";
		Optional<Utilisateur> optUtilisateur;
		try {
			Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Utilisateur.class),
					identifiant, identifiant);
			optUtilisateur = Optional.of(utilisateur);
		} catch (EmptyResultDataAccessException e) {
			optUtilisateur = Optional.empty();
		}
		return optUtilisateur;
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) throws UtilisateurNotFoundRuntimeException {
		if (utilisateur.getNoUtilisateur() == null) {
			// Ajout d'un nouvel utilisateur
			String sql = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (:pseudo, :nom, :prenom, :email, :telephone, :rue, :code_postal, :ville, :mot_de_passe, :credit, :administrateur)";

			MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			parameterSource.addValue("pseudo", utilisateur.getPseudo());
			parameterSource.addValue("nom", utilisateur.getNom());
			parameterSource.addValue("prenom", utilisateur.getPrenom());
			parameterSource.addValue("email", utilisateur.getEmail());
			parameterSource.addValue("telephone", utilisateur.getTelephone());
			parameterSource.addValue("rue", utilisateur.getRue());
			parameterSource.addValue("code_postal", utilisateur.getCodePostal());
			parameterSource.addValue("ville", utilisateur.getVille());
			parameterSource.addValue("mot_de_passe", passwordEncoder.encode(utilisateur.getMotDePasse())); // Assurez-vous
																											// d'encoder
																											// le mot de
																											// passe
			parameterSource.addValue("credit", utilisateur.getCredit());
			parameterSource.addValue("administrateur", utilisateur.isAdministrateur() ? 1 : 0); // Convertir boolean en
																								// int (1 pour vrai, 0
																								// pour faux)

			KeyHolder keyHolder = new GeneratedKeyHolder();

			namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[] { "no_utilisateur" });

			utilisateur.setNoUtilisateur(keyHolder.getKey().intValue());
		} else {
			// Modification d'un utilisateur existant
			String sql = "UPDATE UTILISATEURS SET pseudo = :pseudo, email = :email, nom = :nom, prenom = :prenom, telephone = :telephone, rue = :rue, code_postal = :code_postal, ville = :ville, mot_de_passe = :mot_de_passe, credit = :credit, administrateur = :administrateur WHERE no_utilisateur = :no_utilisateur";

			MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			parameterSource.addValue("pseudo", utilisateur.getPseudo());
			parameterSource.addValue("email", utilisateur.getEmail());
			parameterSource.addValue("nom", utilisateur.getNom());
			parameterSource.addValue("prenom", utilisateur.getPrenom());
			parameterSource.addValue("telephone", utilisateur.getTelephone());
			parameterSource.addValue("rue", utilisateur.getRue());
			parameterSource.addValue("code_postal", utilisateur.getCodePostal());
			parameterSource.addValue("ville", utilisateur.getVille());
			parameterSource.addValue("mot_de_passe", passwordEncoder.encode(utilisateur.getMotDePasse())); // Assurez-vous
																											// d'encoder
																											// le mot de
																											// passe
			parameterSource.addValue("credit", utilisateur.getCredit());
			parameterSource.addValue("administrateur", utilisateur.isAdministrateur() ? 1 : 0); // Convertir boolean en
																								// int
			parameterSource.addValue("no_utilisateur", utilisateur.getNoUtilisateur());

			int nbLignes = namedParameterJdbcTemplate.update(sql, parameterSource);
			if (nbLignes == 0) {
				throw new UtilisateurNotFoundRuntimeException(
						"L'utilisateur avec l'ID " + utilisateur.getNoUtilisateur() + " n'a pas été trouvé.");
			}
		}

		return utilisateur;
	}

	@Override
	public boolean isUsernameUnique(String pseudo) {
		String sql = "SELECT COUNT(*) FROM UTILISATEURS WHERE pseudo = :pseudo";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("pseudo", pseudo);

		Integer count = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, Integer.class);
		return count != null && count == 0;
	}

	@Override
	public boolean isEmailUnique(String email) {
		String sql = "SELECT COUNT(*) FROM UTILISATEURS WHERE email = :email";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("email", email);

		Integer count = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, Integer.class);
		return count != null && count == 0;
	}

}
