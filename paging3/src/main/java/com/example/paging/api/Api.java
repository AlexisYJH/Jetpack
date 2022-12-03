package com.example.paging.api;


import com.example.paging.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author AlexisYin
 */
public interface Api {

    @GET("ikds.do")
    Call<List<Movie>> getMovies(
            @Query("since") int since,
            @Query("pagesize") int pagesize
    );
}
