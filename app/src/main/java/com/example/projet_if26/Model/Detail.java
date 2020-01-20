package com.example.projet_if26.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {@ForeignKey(entity = Piece.class, parentColumns = "id", childColumns = "idPiece", onDelete = CASCADE)})
public class Detail {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "commentaire")
    private String commentaire;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "in_state")
    private String in_state;

    @ColumnInfo(name = "out_state")
    private String out_state;

    @ColumnInfo(name = "idPiece")
    private int idPiece;

    public Detail(String name, String in_state, String out_state, String commentaire,int idPiece) {
        this.id = 0;
        this.commentaire = commentaire;
        this.name = name;
        this.in_state = in_state;
        this.out_state = out_state;
        this.idPiece = idPiece;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIn_state() {
        return in_state;
    }

    public void setIn_state(String in_state) {
        this.in_state = in_state;
    }

    public String getOut_state() {
        return out_state;
    }

    public void setOut_state(String out_state) {
        this.out_state = out_state;
    }


    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
    }


}
