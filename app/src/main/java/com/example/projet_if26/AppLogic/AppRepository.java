package com.example.projet_if26.AppLogic;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.projet_if26.Dao.DetailDao;
import com.example.projet_if26.Model.Detail;

import java.util.List;

public class AppRepository {

    private final AppDatabase appDatabase;

    private DetailDao detailDao;

    private LiveData<List<Detail>> allDetails;

    public AppRepository(Application application) {
        this.appDatabase = AppDatabase.getDatabase(application);
        this.detailDao = appDatabase.detailDao();
        this.allDetails = detailDao.getAll();
    }

    void insertDetail(Detail detail) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            this.detailDao.insert(detail);
        });
    }

    LiveData<List<Detail>> getAllDetails(){
        return allDetails;
    }
}
