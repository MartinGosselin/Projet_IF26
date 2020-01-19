package com.example.projet_if26.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.Model.User;

import java.util.List;

@Dao
public interface LogementDao {

    @Query("SELECT * FROM logement")
    LiveData<List<Logement>> getAllLogement();

    @Query("SELECT * FROM logement WHERE id IN (:id)")
    List<Logement> getLogementById(int id);

    @Query("SELECT * FROM logement WHERE id IN (:logementIds)")
    LiveData<List<Logement>> loadAllByIds(int[] logementIds);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertLogement(Logement logement);

    @Delete
    void delete(Logement logement);


}
