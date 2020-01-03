package com.example.projet_if26.AppLogic;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.projet_if26.Dao.DetailDao;
import com.example.projet_if26.Dao.LogementDao;
import com.example.projet_if26.Dao.PieceDao;
import com.example.projet_if26.Dao.UserDao;
import com.example.projet_if26.Model.Detail;
import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.Model.Piece;
import com.example.projet_if26.Model.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Piece.class, Logement.class, Detail.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract PieceDao pieceDao();
    public abstract DetailDao detailDao();
    public abstract LogementDao logementDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
