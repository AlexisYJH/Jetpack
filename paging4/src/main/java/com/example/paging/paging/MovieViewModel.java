package com.example.paging.paging;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedList;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedListConfigKt;

import com.example.paging.db.MovieDao;
import com.example.paging.db.MyDatabase;
import com.example.paging.model.Movie;

/**
 * @author AlexisYin
 */
public class MovieViewModel extends AndroidViewModel {
    public LiveData<PagedList<Movie>> moviePagedList;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        MovieDao movieDao = MyDatabase.getInstance(application).getMovieDao();
        moviePagedList = new LivePagedListBuilder<>(
                movieDao.getMovieList(), MovieBoundaryCallback.PER_PAGE)
                .setBoundaryCallback(new MovieBoundaryCallback(application))
                .build();
    }

    public void refresh() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                MyDatabase.getInstance(getApplication()).getMovieDao().clear();
            }
        });
    }
}
