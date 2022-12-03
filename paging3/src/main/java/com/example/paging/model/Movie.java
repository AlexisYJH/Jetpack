package com.example.paging.model;

import java.util.Objects;

/**
 * @author AlexisYin
 */
public class Movie {
    public int id;

    public String cover;

    public String title;

    public String rate;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }

    //用于差分比较
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(cover, movie.cover) && Objects.equals(title, movie.title) && Objects.equals(rate, movie.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cover, title, rate);
    }
}
