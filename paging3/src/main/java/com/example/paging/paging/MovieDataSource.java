package com.example.paging.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;

import com.example.paging.api.RetrofitClient;
import com.example.paging.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author AlexisYin
 */
public class MovieDataSource extends ItemKeyedDataSource<Integer, Movie> {
    private static final String TAG = "YIN-MovieDataSource";

    public static final int PER_PAGE = 8;
    public static final int PREFETCH_DISTANCE = 2;
    public static final int INITIAL_RATIO = 2;
    public static final int MAX_PAGE = 65536;


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Movie> callback) {
        int since = 0;
        RetrofitClient.getInstance().getApi().getMovies(since, PER_PAGE).enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.body() != null) {
                    //把数据传递给PagedList
                    callback.onResult(response.body());
                    Log.d(TAG, "loadInitial: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.e(TAG, "loadInitial: " + t.getMessage());
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Movie> loadCallback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Movie> callback) {
        RetrofitClient.getInstance().getApi().getMovies(params.key, PER_PAGE).enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.body() != null) {
                    //把数据传递给PagedList
                    callback.onResult(response.body());
                    Log.d(TAG, params.key + "--> loadAfter: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.e(TAG, params.key + " loadAfter: " + t.getMessage());
            }
        });

    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Movie movie) {
        return movie.id;
    }
}
