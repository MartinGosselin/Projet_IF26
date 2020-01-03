package com.example.projet_if26.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.Model.User;

import java.util.List;

@Dao
public interface LogementDao {

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM user WHERE id IN (:logementIds)")
    LiveData<List<User>> loadAllByIds(int[] logementIds);

    @Insert
    void insertAll(Logement... logements);

    @Delete
    void delete(Logement logement);
}
