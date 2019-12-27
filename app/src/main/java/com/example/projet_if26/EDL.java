package com.example.projet_if26;

public class EDL {

    private Personne proprietaire;
    private Personne locataire;
    private String adresseBien;
    private String etat;
    private Piece[] pieces;

    public EDL(Personne proprietaire, Personne locataire, String adresseBien, String etat, Piece[] pieces) {
        this.proprietaire = proprietaire;
        this.locataire = locataire;
        this.adresseBien = adresseBien;
        this.etat = etat;
        this.pieces = pieces;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Personne getLocataire() {
        return locataire;
    }

    public void setLocataire(Personne locataire) {
        this.locataire = locataire;
    }

    public String getAdresseBien() {
        return adresseBien;
    }

    public void setAdresseBien(String adresseBien) {
        this.adresseBien = adresseBien;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }
}
