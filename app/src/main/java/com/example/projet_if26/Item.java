package com.example.projet_if26;

public class Item {
    private String nom;
    private String etat;
    private String commentaire;

    public Item(String nom, String etat, String commentaire) {
        this.nom = nom;
        this.etat = etat;
        this.commentaire = commentaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nom='" + nom + '\'' +
                ", etat='" + etat + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
