package com.example.projet_if26.AppLogic;

import android.content.Context;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.projet_if26.Dao.DetailDao;
import com.example.projet_if26.Dao.LogementDao;
import com.example.projet_if26.Dao.PieceDao;
import com.example.projet_if26.Dao.UserDao;
import com.example.projet_if26.Model.Detail;
import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.Model.Piece;
import com.example.projet_if26.Model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Piece.class, Logement.class, Detail.class}, version = 4, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract PieceDao pieceDao();
    public abstract DetailDao detailDao();
    public abstract LogementDao logementDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 8;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback adminLoginCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(() -> {
                /*
                UserDao dao = INSTANCE.userDao();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                dao.insertUser(new User("admin","admin", formatter.format(date)));
                Log.d("ADMIN", "admin added");

                 */



            });
        }
    };

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app_database")
                            .addCallback(adminLoginCallback)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
