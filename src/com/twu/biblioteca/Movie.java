package com.twu.biblioteca;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by WYJ on 2016/6/10.
 */
public class Movie extends LibraryItem {
    private double movieRate;

    public Movie(String name, String author, GregorianCalendar publishTime, double movieRate) {
        super(name, author, publishTime);
        this.movieRate = movieRate;
    }

    public double getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(double movieRate) {
        this.movieRate = movieRate;
    }

    public String getPublishTimeFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        return formatter.format(publishTime.getTime());
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseTime=" + getPublishTimeFormat()+
                ", rate=" + movieRate;
    }


}
