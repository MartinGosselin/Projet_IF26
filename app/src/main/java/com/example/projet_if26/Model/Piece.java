package com.example.projet_if26.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {@ForeignKey(entity = Logement.class, parentColumns = "id", childColumns = "idLogement", onDelete = CASCADE)})
public class Piece {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "commentaire")
    private String commentaire;

    @ColumnInfo(name = "idLogement")
    private int idLogement;


    public Piece(String name, String commentaire, int idLogement) {
        this.id = 0;
        this.name = name;
        this.commentaire = commentaire;
        this.idLogement = idLogement;
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

    public int getIdLogement() {
        return idLogement;
    }

    public void setIdLogement(int idLogement) {
        this.idLogement = idLogement;
    }


}
