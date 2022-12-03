package com.example.paging.api;


import com.example.paging.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author AlexisYin
 */
public interface Api {

    @GET("pds.do")
    Call<Movies> getMovies(
            @Query("start") int start,
            @Query("count") int count
    );
}
