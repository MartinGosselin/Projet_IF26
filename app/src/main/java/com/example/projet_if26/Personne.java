package com.example.projet_if26;

public class Personne {

    private String prenom;
    private String telephone;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Personne(String nom, String prenom, String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }
}
