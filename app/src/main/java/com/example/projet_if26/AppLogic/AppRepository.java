package com.example.projet_if26.AppLogic;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.projet_if26.Dao.DetailDao;
import com.example.projet_if26.Dao.LogementDao;
import com.example.projet_if26.Dao.PieceDao;
import com.example.projet_if26.Dao.UserDao;
import com.example.projet_if26.Model.Detail;
import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.Model.Piece;
import com.example.projet_if26.Model.User;

import java.util.List;

public class AppRepository {

    private final AppDatabase appDatabase;

    private DetailDao detailDao;

    private UserDao userDao;

    private LogementDao logementDao;

    private PieceDao pieceDao;

    public AppRepository(Application application) {
        this.appDatabase = AppDatabase.getDatabase(application);
        this.detailDao = appDatabase.detailDao();
        this.userDao = appDatabase.userDao();
        this.logementDao = appDatabase.logementDao();
        this.pieceDao = appDatabase.pieceDao();
    }

    void insertDetail(Detail detail) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            this.detailDao.insert(detail);
        });
    }

    void insertUser(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            this.userDao.insertUser(user);
        });
    }

    void insertLogement(Logement logement){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            this.logementDao.insertLogement(logement);
        });
    }

    List<User> getUserByName(String userName) {
        return this.userDao.getUserByName(userName);
    }

    LiveData<List<Detail>> getAllDetails(){
        return detailDao.getAll();
    }

    LiveData<List<Logement>> getAllLogements(){
        return logementDao.getAllLogement();
    }

    List<Logement> getLogementById(int id){
        return logementDao.getLogementById(id);
    }

    LiveData<List<Piece>> getAllPieceByLogementId(int idLogement){
        return pieceDao.getAllPieceByLogementId(idLogement);
    }

    LiveData<List<Piece>> getAllPieces(){
        return pieceDao.getAllPieces();
    }

    LiveData<List<Detail>> getAllDetailsByPieceId(int pieceId){
        return detailDao.getAllDetailsByPieceId(pieceId);
    }

    void insertPiece(Piece piece) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            this.pieceDao.insertPiece(piece);
        });
    }



}
