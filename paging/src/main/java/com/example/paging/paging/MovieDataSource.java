package com.example.paging.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.example.paging.api.RetrofitClient;
import com.example.paging.model.Movie;
import com.example.paging.model.Movies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author AlexisYin
 */
public class MovieDataSource extends PositionalDataSource<Movie> {
    private static final String TAG = "YIN-MovieDataSource";

    public static final int PER_PAGE = 8;
    public static final int PREFETCH_DISTANCE = 2;
    public static final int INITIAL_RATIO = 2;
    public static final int MAX_PAGE = 65536;


    //页面首次加载数据会调用
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Movie> callback) {
        int start = 0;
        RetrofitClient.getInstance().getApi().getMovies(start, PER_PAGE).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies movies = response.body();
                if (movies != null) {
                    //把数据传递给PagedList, total用于预留位置
                    callback.onResult(movies.movieList, movies.start, movies.total);
                    Log.d(TAG, "loadInitial: " + movies.movieList);
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e(TAG, "loadInitial: " + t.getMessage());
            }
        });
    }

    //加载下一页
    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Movie> callback) {
        RetrofitClient.getInstance().getApi().getMovies(params.startPosition, PER_PAGE).enqueue(new Callback<Movies>() {

            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies movies = response.body();
                if (movies != null) {
                    //把数据传递给PagedList
                    callback.onResult(movies.movieList);
                    Log.d(TAG, params.startPosition + "-->loadRange: " + movies.movieList);
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e(TAG, "loadRange: " + t.getMessage());
            }
        });
    }
}
