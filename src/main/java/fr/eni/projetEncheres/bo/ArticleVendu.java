package fr.eni.projetEncheres.bo;

import java.time.LocalDate;

public class ArticleVendu {

	
	
	// ATTRIBUTS 
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Float miseAPrix;
	private Float prixVente;
	private String etatVente;
	
	
	
	
	// CONSTRUCTEURS
	public ArticleVendu() {
		super();
	}
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Float miseAPrix, Float prixVente, String etatVente) {
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
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Float miseAPrix, Float prixVente, String etatVente) {
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
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
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
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public Float getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(Float miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public Float getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(Float prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	
	
	
	
}
