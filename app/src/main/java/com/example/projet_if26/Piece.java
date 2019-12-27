package com.example.projet_if26;

public class Piece {

    private String commentaire;
    private String nom;
    private Item[] items;

    public Piece(String commentaire, String nom, Item[] items) {
        this.commentaire = commentaire;
        this.nom = nom;
        this.items = items;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


}
