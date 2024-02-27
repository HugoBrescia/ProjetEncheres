package fr.eni.projetEncheres.bo;

public class Retrait {

	// ATTRIBUTS
	private String rue;
	private int code_postal;
	private String ville;
	
	
	// CONSTRUCTEURS 
	public Retrait() {
		super();
	}
	public Retrait(String rue, int code_postal, String ville) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	
	
	
	// GETTERS AND SETTERS 
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	// TO STRING 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [rue=").append(rue).append(", code_postal=").append(code_postal).append(", ville=")
				.append(ville).append("]");
		return builder.toString();
	}
	
	

	
	
}
