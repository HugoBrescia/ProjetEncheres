package fr.eni.projetEncheres.bo;

import java.util.Objects;

public class Utilisateur {

	// ATTRIBUTS
	private Integer noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private int telephone;
	private String rue;
	private int codePostal;
	private String ville;
	private String motDePasse;
	private Integer credit;
	private boolean administrateur;

	// CONSTRUCTEURS
	public Utilisateur() {
		super();
	}

	public Utilisateur(int noUtilisateur, String pseudo, String nom, String email, int telephone, String rue,
			int codePostal, String ville, String motDePasse, Integer credit, boolean administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Utilisateur(String pseudo, String nom, String email, int telephone, String rue, int codePostal, String ville,
			String motDePasse, Integer credit, boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	// TO STRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [noUtilisateur=").append(noUtilisateur).append(", pseudo=").append(pseudo)
				.append(", nom=").append(nom).append(", email=").append(email).append(", telephone=").append(telephone)
				.append(", rue=").append(rue).append(", codePostal=").append(codePostal).append(", ville=")
				.append(ville).append(", motDePasse=").append(motDePasse).append(", credit=").append(credit)
				.append(", administrateur=").append(administrateur).append("]");
		return builder.toString();
	}

	// HASHCODE de MDP
	@Override
	public int hashCode() {
		return Objects.hash(motDePasse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(motDePasse, other.motDePasse);
	}

	// GETTERS AND SETTERS
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public String getUsername() {
		
		return null;
	}

	public Object getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
