package com.example.room2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * @author AlexisYin
 */
@Database(entities = {Student.class}, version = 4, exportSchema = true)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_db.db";
    private static MyDatabase sInstance;

    public static synchronized MyDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class,
                    DATABASE_NAME)
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
                    //假设数据库版本升级到4，却没有相应的Migration，则会出现IllegalStateException
                    //加入该方法，在出现升级异常时重建数据表，数据也会丢失
                    //.fallbackToDestructiveMigration()
                    .createFromAsset("prestudent.db")
                    .build();
        }
        return sInstance;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 1");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE temp_student (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "name TEXT," +
                    "age INTEGER NOT NULL," +
                    "sex TEXT DEFAULT 'M'," +
                    "bar_data INTEGER NOT NULL DEFAULT 1)");
            database.execSQL("INSERT INTO temp_student (name, age, sex, bar_data)" +
                    "SELECT name,age,sex,bar_data FROM student");
            database.execSQL("UPDATE temp_student SET sex = 'M' WHERE sex = '1'");
            database.execSQL("DROP TABLE student");
            database.execSQL("ALTER TABLE temp_student RENAME TO student");
        }
    };

    //Room会自动实现
    public abstract StudentDao getStudentDao();
}
