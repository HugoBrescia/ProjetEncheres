package fr.eni.projetEncheres.dal;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.bo.Utilisateur;

public class RowMapperConfigurator {

	public static RowMapper<Utilisateur> utilisateurRowMapper() {
		RowMapper<Utilisateur> rowMapper = new RowMapper<>() {

			// prévoir programation par réflexion et introspection  (java avancée)
			@Override
			public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
				// méthode RowMapper Utilisateur (appel = RowMapperS.utilisateurRowMapper)

				Utilisateur utilisateur = new Utilisateur();
				// Correspondance relationnel vers objet
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.isAdministrateur();


				return utilisateur;
			}
		};

		return rowMapper;
	}

	public static RowMapper<ArticleVendu> articleVenduRowMapper() {
		RowMapper<ArticleVendu> rowMapper = new RowMapper<>() {

			@Override
			public ArticleVendu mapRow(ResultSet rs, int rowNum) throws SQLException {
				// méthode RowMapper Utilisateur (appel = RowMapperS.utilisateurRowMapper)

				ArticleVendu articleVendu = new ArticleVendu();
				// Correspondance relationnel vers objet
				articleVendu.setNoArticle(rs.getInt("no_article"));
				articleVendu.setNomArticle(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
				articleVendu.setPrixVente(rs.getInt("prix_vente"));
				articleVendu.setEtatVente(rs.getString("etat_vente"));
			
				return articleVendu;
			}
		};

		return rowMapper;
	}
	
	
	public static RowMapper<Categorie> categorieRowMapper() {
		RowMapper<Categorie> rowMapper = new RowMapper<>() {

			@Override
			public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
				// méthode RowMapper Utilisateur (appel = RowMapperS.utilisateurRowMapper)

				Categorie categorie = new Categorie();
				// Correspondance relationnel vers objet
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
							

				return categorie;
			}
		};

		return rowMapper;
	}
	
	public static RowMapper<Enchere> enchereRowMapper() {
		RowMapper<Enchere> rowMapper = new RowMapper<>() {

			@Override
			public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
				// méthode RowMapper Utilisateur (appel = RowMapperS.utilisateurRowMapper)

				Enchere enchere = new Enchere();
				// Correspondance relationnel vers objet
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
							

				return enchere;
			}
		};

		return rowMapper;
	}
	
	
	public static RowMapper<Retrait> RetraitRowMapper() {
		RowMapper<Retrait> rowMapper = new RowMapper<>() {

			@Override
			public Retrait mapRow(ResultSet rs, int rowNum) throws SQLException {
				// méthode RowMapper Utilisateur (appel = RowMapperS.utilisateurRowMapper)

				Retrait retrait = new Retrait();
				// Correspondance relationnel vers objet
				retrait.setRue(rs.getString("rue"));
				retrait.setCode_postal(rs.getInt("code_postal"));
				retrait.setVille(rs.getString("ville"));
							

				return retrait;
			}
		};

		return rowMapper;
	}
}
