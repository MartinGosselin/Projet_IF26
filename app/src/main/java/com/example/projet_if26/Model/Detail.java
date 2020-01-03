package com.example.projet_if26.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Detail {

    private static int idCount = 0;

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "commentaire")
    private String commentaire;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "in_state")
    private String in_state;

    @ColumnInfo(name = "out_state")
    private String out_state;

    /*
    @ColumnInfo(name = "piece")
    private Piece piece;
     */

    public Detail(String name, String in_state, String out_state, String commentaire) {
        this.id = this.idCount;
        Detail.idCount++;
        this.commentaire = commentaire;
        this.name = name;
        this.in_state = in_state;
        this.out_state = out_state;
        //this.piece = piece;
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

    /*
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    */
}
