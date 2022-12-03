package com.example.paging.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedList;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedListConfigKt;

import com.example.paging.model.Movie;

/**
 * @author AlexisYin
 */
public class MovieViewModel extends ViewModel {
    public LiveData<PagedList<Movie>> moviePagedList;

    public MovieViewModel() {
        PagedList.Config config = new PagedList.Config.Builder()
                //设置控件占位
                .setEnablePlaceholders(false)
                .setPageSize(MovieDataSource.PER_PAGE)
                //设置当距离底部还有多少条数据时开始加载下一页
                .setPrefetchDistance(MovieDataSource.PREFETCH_DISTANCE)
                .setInitialLoadSizeHint(MovieDataSource.PER_PAGE * MovieDataSource.INITIAL_RATIO)
                .setMaxSize(MovieDataSource.PER_PAGE * MovieDataSource.MAX_PAGE)
                .build();
        moviePagedList = new LivePagedListBuilder<>(new MovieDataSourceFactory(), config).build();
    }
}
