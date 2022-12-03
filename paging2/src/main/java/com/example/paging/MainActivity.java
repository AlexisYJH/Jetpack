package com.example.paging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.paging.model.Movie;
import com.example.paging.paging.MoviePagedListAdapter;
import com.example.paging.paging.MovieViewModel;

/**
 * 添加依赖
 * 修改Movies类，修改Api
 * 修改MovieDataSource类，继承PageKeyedDataSource
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MoviePagedListAdapter adapter = new MoviePagedListAdapter();
        recyclerView.setAdapter(adapter);

        MovieViewModel movieViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MovieViewModel.class);
        movieViewModel.moviePagedList.observe(this, new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(PagedList<Movie> movies) {
                adapter.submitList(movies);
            }
        });
    }
}