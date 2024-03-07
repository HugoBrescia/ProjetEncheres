package fr.eni.projetEnchereHugo.bo;

import java.time.LocalDateTime;

public class Enchere {
    private int id;
    private int noUtilisateur;
    private int noArticle;
    private LocalDateTime dateEnchere;
    private int montantEnchere;

    // Constructeurs
    public Enchere() {
    }

    public Enchere(int id, int noUtilisateur, int noArticle, LocalDateTime dateEnchere, int montantEnchere) {
        this.id = id;
        this.noUtilisateur = noUtilisateur;
        this.noArticle = noArticle;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(int noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public LocalDateTime getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(LocalDateTime dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public int getMontantEnchere() {
        return montantEnchere;
    }

    public void setMontantEnchere(int montantEnchere) {
        this.montantEnchere = montantEnchere;
    }


    @Override
    public String toString() {
        return "Enchere{" +
                "id=" + id +
                ", noUtilisateur=" + noUtilisateur +
                ", noArticle=" + noArticle +
                ", dateEnchere=" + dateEnchere +
                ", montantEnchere=" + montantEnchere +
                '}';
    }
}
