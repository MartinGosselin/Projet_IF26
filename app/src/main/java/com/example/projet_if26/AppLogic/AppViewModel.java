package com.example.projet_if26.AppLogic;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projet_if26.Model.Detail;
import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.Model.Piece;
import com.example.projet_if26.Model.User;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

    private AppRepository appRepository;

    public AppViewModel (Application application) {
        super(application);
        appRepository = new AppRepository(application);
    }

    public LiveData<List<Detail>> getAllDetails() { return appRepository.getAllDetails(); }

    public LiveData<List<Logement>> getAllLogements() {
        return appRepository.getAllLogements();
    }

    public void insertDetail(Detail detail) { appRepository.insertDetail(detail); }

    public void insertLogement(Logement logement){
        appRepository.insertLogement(logement);
    }

    public LiveData<List<User>> getUserByName(String userName) {
        return appRepository.getUserByName(userName);
    }

    public void insertUser(User user) {
        appRepository.insertUser(user);
    }

    public List<Logement> getLogementById(int id){
        return appRepository.getLogementById(id);
    }

    public void insertPiece(Piece piece) {
        appRepository.insertPiece(piece);
    }

    public LiveData<List<Piece>> getAllPieces(){
        return appRepository.getAllPieces();
    }

    public LiveData<List<Piece>> getAllPieceByLogementId(int idLogement){
        return appRepository.getAllPieceByLogementId(idLogement);
    }

}
