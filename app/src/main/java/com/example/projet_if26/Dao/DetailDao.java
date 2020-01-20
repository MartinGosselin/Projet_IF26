package com.example.projet_if26.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.projet_if26.Model.Detail;

import java.util.List;

@Dao
public interface DetailDao {

    @Query("SELECT * FROM detail")
    LiveData<List<Detail>> getAll();

    @Query("SELECT * FROM detail WHERE id IN (:detailIds)")
    LiveData<List<Detail>> loadAllByIds(int[] detailIds);

    @Query("SELECT * FROM detail WHERE idPiece IN (:idPiece)")
    LiveData<List<Detail>> getAllDetailsByPieceId(int idPiece);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Detail detail);

    @Delete
    void delete(Detail detail);
}
