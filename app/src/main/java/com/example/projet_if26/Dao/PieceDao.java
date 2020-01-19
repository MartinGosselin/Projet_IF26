package com.example.projet_if26.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.Model.Piece;
import com.example.projet_if26.Model.User;

import java.util.List;

@Dao
public interface PieceDao {
    @Query("SELECT * FROM piece")
    LiveData<List<Piece>> getAllPieces();

    @Query("SELECT * FROM user WHERE id IN (:pieceIds)")
    LiveData<List<Piece>> loadAllByIds(int[] pieceIds);

    @Query("SELECT * FROM piece WHERE id IN (:id)")
    List<Piece> getPieceById(int id);

    @Query("SELECT * FROM piece WHERE idLogement = :idLogement")
    LiveData<List<Piece>> getAllPieceByLogementId(int idLogement);

    @Insert
    void insertPiece(Piece piece);

    @Delete
    void delete(Piece piece);
}
