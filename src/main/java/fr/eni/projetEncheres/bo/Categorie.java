package fr.eni.projetEncheres.bo;

public class Categorie {

	// ATTRIBUTS
	private int noCategorie;
	private String libelle;
	
	// CONSTRUCTEURS 
	public Categorie() {
		super();
	}
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	// TO STRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=").append(noCategorie).append(", libelle=").append(libelle).append("]");
		return builder.toString();
	}
	
	
	// GETTERS AND SETTERS 
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
