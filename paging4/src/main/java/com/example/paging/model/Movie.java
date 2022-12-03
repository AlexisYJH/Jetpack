package com.example.paging.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

/**
 * @author AlexisYin
 */
@Entity(tableName = "movie")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "no", typeAffinity = ColumnInfo.INTEGER)
    public int NO;

    //不要用作主键，若为主键查询时会默认按照id的升序或降序查找，那么就会和存放顺序不一样，会导致报错，另外增加主键
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "cover", typeAffinity = ColumnInfo.TEXT)
    public String cover;

    @ColumnInfo(name = "title", typeAffinity = ColumnInfo.TEXT)
    public String title;

    @ColumnInfo(name = "rate", typeAffinity = ColumnInfo.TEXT)
    public String rate;

    @Override
    public String toString() {
        return "Movie{" +
                "NO=" + NO +
                ", id=" + id +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return NO == movie.NO && id == movie.id && cover.equals(movie.cover) && title.equals(movie.title) && rate.equals(movie.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NO, id, cover, title, rate);
    }
}
