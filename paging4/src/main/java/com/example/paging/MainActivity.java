package com.example.paging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;

import com.example.paging.model.Movie;
import com.example.paging.paging.MoviePagedListAdapter;
import com.example.paging.paging.MovieViewModel;

/**
 * 1. 添加依赖
 * 2. 修改布局，使用SwipeRefreshLayout包含RecyclerView
 * 3. 修改Movie类，是一个Entity
 * 4. 新建db包
 * 新建MyDatabase抽象类，继承RoomDatabase，指定数据库schema导出的位置
 * 新建MovieDao接口
 * 5. 新建MovieBoundaryCallback，继承PagedList.BoundaryCallback
 * 6. 删除MovieDataSource和MovieDataSourceFactory
 * 7. 修改MovieViewModel
 * 8. MainActivity中增加SwipeRefreshLayout处理
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

        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                movieViewModel.refresh();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}