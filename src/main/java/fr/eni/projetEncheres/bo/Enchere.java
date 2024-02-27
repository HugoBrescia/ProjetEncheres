package fr.eni.projetEncheres.bo;

import java.time.LocalDate;

public class Enchere {

	
	
	// ATTRIBUTS
	private LocalDate dateEnchere;
	private Float montant_enchere;
	
	
	// CONSTRUCTEURS 
	public Enchere() {
		super();
	}
	public Enchere(LocalDate dateEnchere, Float montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}
	
	
	// GETTERS AND SETTERS 
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public Float getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(Float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	
	 // TO STRING 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=").append(dateEnchere).append(", montant_enchere=").append(montant_enchere)
				.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
