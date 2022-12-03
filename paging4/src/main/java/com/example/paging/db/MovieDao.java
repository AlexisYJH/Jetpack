package com.example.paging.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.paging.model.Movie;

import java.util.List;

/**
 * @author AlexisYin
 */
@Dao
public interface MovieDao {
    @Insert
    void insert(List<Movie> movies);

    @Query("DELETE FROM movie")
    void clear();

    @Query("SELECT * FROM movie")
    DataSource.Factory<Integer, Movie> getMovieList();
}
