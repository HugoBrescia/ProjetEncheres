package fr.eni.projetEncheres.bo;



import java.util.Date;

public class Enchere {

	
	
	// ATTRIBUTS
	private Date dateEnchere;
	private Integer montant_enchere;
	
	
	// CONSTRUCTEURS 
	public Enchere() {
		super();
	}
	public Enchere(Date dateEnchere, Integer montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}
	
	
	// GETTERS AND SETTERS 
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public Integer getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(Integer montant_enchere) {
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
