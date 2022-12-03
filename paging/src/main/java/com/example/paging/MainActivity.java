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
 * -1.准备Server
 * 0.添加依赖，准备layout文件
 * 1.创建model包
 * 创建Movie类，实现equals和hashCode用于后续的差分比较
 * 创建Movies类
 * 2.创建api包
 * 创建Api接口，RetrofitClient类，网络请求
 * 3.创建paging包
 * 创建MovieDataSource类，继承PositionalDataSource
 * 创建MovieDataSourceFactory类，继承DataSource.Factory
 * 创建MovieViewModel类，在ViewModel中配置PagedList
 * 创建MoviePagedListAdapter类
 * 4.RecycleView绑定Adapter，观察MovieViewModel.moviePagedList
 * 5.增加网络权限和networkSecurityConfig申明
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