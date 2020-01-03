package com.example.projet_if26.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User {

    private static int idCount = 0;

    @PrimaryKey
    private int id;

    @ColumnInfo( name = "full_name")
    private String full_name;

    @ColumnInfo( name = "password")
    private String password;

    @ColumnInfo( name = "created_at")
    private String created_at;

    public User(String full_name, String password, String created_at) {
        this.id = this.idCount;
        User.idCount++;
        this.full_name = full_name;
        this.password = password;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
