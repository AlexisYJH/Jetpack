package com.example.paging.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.paging.api.RetrofitClient;
import com.example.paging.model.Movie;
import com.example.paging.model.Movies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author AlexisYin
 */
public class MovieDataSource extends PageKeyedDataSource<Integer, Movie> {
    private static final String TAG = "YIN-MovieDataSource";

    public static final int PER_PAGE = 8;
    public static final int FIRST_PAGE = 1;
    public static final int PREFETCH_DISTANCE = 2;
    public static final int INITIAL_RATIO = 2;
    public static final int MAX_PAGE = 65536;

    //第一页
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> loadInitialParams, @NonNull LoadInitialCallback<Integer, Movie> callback) {
        RetrofitClient.getInstance().getApi().getMovies(FIRST_PAGE, PER_PAGE).enqueue(new Callback<Movies>() {

            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies movies = response.body();
                if (movies != null) {
                    //把数据传递给PagedList
                    callback.onResult(movies.movieList, null, FIRST_PAGE + 1);
                    Log.d(TAG, "loadInitial: " + movies.movieList);
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e(TAG, "loadInitial: " + t.getMessage());
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Integer, Movie> loadCallback) {

    }


    //下一页
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {
        RetrofitClient.getInstance().getApi().getMovies(params.key, PER_PAGE).enqueue(new Callback<Movies>() {

            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies movies = response.body();
                if (movies != null) {
                    //把数据传递给PagedList
                    Integer nextKey = movies.hasMore ? params.key + 1 : null;
                    callback.onResult(movies.movieList, nextKey);
                    Log.d(TAG, nextKey + "-->loadAfter: " + movies.movieList);
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e(TAG, "loadAfter: " + t.getMessage());
            }
        });

    }



}
