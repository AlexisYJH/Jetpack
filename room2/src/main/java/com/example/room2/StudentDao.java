package com.example.room2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @author AlexisYin
 */
@Dao
public interface StudentDao {
    @Insert
    void insert(Student... students);
    @Delete
    void delete(Student... students);
    @Query("DELETE FROM student")
    void clear();
    @Update
    void update(Student... students);
    @Query("SELECT * FROM student")
    LiveData<List<Student>> getAllStudentslive();
    @Query("SELECT * FROM student WHERE id = :id")
    List<Student> getStudentById(int id);
}
