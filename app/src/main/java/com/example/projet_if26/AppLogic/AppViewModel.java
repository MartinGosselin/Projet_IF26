package com.example.projet_if26.AppLogic;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.projet_if26.Model.Detail;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    private LiveData<List<Detail>> allDetails;

    public AppViewModel (Application application) {
        super(application);
        appRepository = new AppRepository(application);
        allDetails = appRepository.getAllDetails();
    }

    public LiveData<List<Detail>> getAllDetails() { return allDetails; }

    public void insertDetail(Detail detail) { appRepository.insertDetail(detail); }
}
