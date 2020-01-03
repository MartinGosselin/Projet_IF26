package com.example.projet_if26.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.projet_if26.Model.Piece;
import com.example.projet_if26.Model.User;

import java.util.List;

@Dao
public interface PieceDao {
    @Query("SELECT * FROM piece")
    LiveData<List<Piece>> getAll();

    @Query("SELECT * FROM user WHERE id IN (:pieceIds)")
    LiveData<List<User>> loadAllByIds(int[] pieceIds);

    @Insert
    void insertAll(Piece... pieces);

    @Delete
    void delete(Piece piece);
}
