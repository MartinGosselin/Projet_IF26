package com.example.projet_if26.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Logement {

    private static int idCount = 0;

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "locataire")
    private String locataire;

    @ColumnInfo(name = "zip_code")
    private String zip_code;

    @ColumnInfo(name = "adresse")
    private String adresse;

    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "commentaire")
    private String commentaire;

    @ColumnInfo(name = "created_at")
    private String created_at;

    /*
    @ColumnInfo(name = "user")
    private User user;

     */


    public Logement(String locataire, String zip_code, String adresse, String city, String commentaire, String created_at) {
        this.id = this.idCount;
        Logement.idCount++;
        this.locataire = locataire;
        this.zip_code = zip_code;
        this.adresse = adresse;
        this.city = city;
        this.commentaire = commentaire;
        this.created_at = created_at;
        //this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocataire() {
        return locataire;
    }

    public void setLocataire(String locataire) {
        this.locataire = locataire;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
