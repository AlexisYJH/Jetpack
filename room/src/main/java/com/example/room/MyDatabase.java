package com.example.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @author AlexisYin
 */
@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_db.db";
    private static MyDatabase sInstance;

    public static synchronized MyDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class,
                    DATABASE_NAME)
                    .build();
        }
        return sInstance;
    }

    //Room会自动实现
    public abstract StudentDao getStudentDao();
}
