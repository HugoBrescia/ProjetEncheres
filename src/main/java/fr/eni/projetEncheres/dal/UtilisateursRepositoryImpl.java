package fr.eni.projetEncheres.dal;


import java.util.Optional;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.exceptions.UtilisateurNotFound;




@Repository
public class UtilisateursRepositoryImpl implements UtilisateurRepository{

	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	public UtilisateursRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.setNamedParameterjdbcTemplate(namedParameterJdbcTemplate);
		this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
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
		        Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Utilisateur.class), identifiant, identifiant);
		        optUtilisateur = Optional.of(utilisateur);
		    } catch (EmptyResultDataAccessException e) {
		        optUtilisateur = Optional.empty();
		    }
		    return optUtilisateur;
		}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		 if(utilisateur.getNoUtilisateur() == null) {
		        // Ajout d'un nouvel utilisateur
		        String sql = "INSERT INTO utilisateurs (pseudo, email, nom, prenom, motDePasse) VALUES (:pseudo, :email, :nom, :prenom, :motDePasse)";
		        
		        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		        parameterSource.addValue("pseudo", utilisateur.getPseudo());
		        parameterSource.addValue("email", utilisateur.getEmail());
		        parameterSource.addValue("nom", utilisateur.getNom());
		        parameterSource.addValue("prenom", utilisateur.getPrenom());
		        parameterSource.addValue("motDePasse", utilisateur.getMotDePasse());
		        
		        KeyHolder keyHolder = new GeneratedKeyHolder();
		        
		        namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[]{"id"});
		        
		        utilisateur.setId(keyHolder.getKey().intValue());
		    } else {
		        // Modification d'un utilisateur existant
		        String sql = "UPDATE utilisateurs SET pseudo = ?, email = ?, nom = ?, prenom = ?, motDePasse = ? WHERE id = ?";
		        int nbLignes = jdbcTemplate.update(sql, utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getMotDePasse(), utilisateur.getId());
		        if(nbLignes == 0) {
		            throw new UtilisateurNotFound(); // Assurez-vous d'avoir une exception appropriée définie
		        }
		    }
		    
		    return utilisateur;
	}

	

	
	}	

