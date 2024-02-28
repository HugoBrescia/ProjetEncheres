package fr.eni.projetEncheres.bo;

import java.sql.Date;
import java.time.LocalDate;

public class ArticleVendu {

	
	
	// ATTRIBUTS 
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	
	
	
	
	// CONSTRUCTEURS
	public ArticleVendu() {
		super();
	}
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			Integer miseAPrix, Integer prixVente, String etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	
	
	// TO STRING 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [noArticle=").append(noArticle).append(", nomArticle=").append(nomArticle)
				.append(", description=").append(description).append(", dateDebutEncheres=").append(dateDebutEncheres)
				.append(", dateFinEncheres=").append(dateFinEncheres).append(", miseAPrix=").append(miseAPrix)
				.append(", prixVente=").append(prixVente).append(", etatVente=").append(etatVente).append("]");
		return builder.toString();
	}
	
	
	
	// GETTERS AND SETTERS 
	public Integer getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(Date date) {
		this.dateDebutEncheres = date;
	}
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public Integer getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(Integer i) {
		this.miseAPrix = i;
	}
	public Integer getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	
	
	
	
}
