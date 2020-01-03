package com.example.projet_if26.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Piece {

    private static int idCount = 0;

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "commentaire")
    private String commentaire;

    /*
    @ColumnInfo(name = "logement")
    private Logement logement;
    */


    public Piece(String name, String commentaire) {
        this.id = this.idCount;
        Piece.idCount++;
        this.name = name;
        this.commentaire = commentaire;
        //this.logement = logement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /*
    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }
    */
}
