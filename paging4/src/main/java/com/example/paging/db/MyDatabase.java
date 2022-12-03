package com.example.paging.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.paging.model.Movie;

/**
 * @author AlexisYin
 */
@Database(entities = {Movie.class}, version = 1, exportSchema = true)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_db.db";

    private static MyDatabase sInstance;

    public static synchronized MyDatabase getInstance(Context context){
        if(sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, DATABASE_NAME).build();
        }
        return sInstance;
    }

    public abstract MovieDao getMovieDao();
}
