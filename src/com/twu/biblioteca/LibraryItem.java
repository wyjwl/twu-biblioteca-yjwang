package com.twu.biblioteca;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by WYJ on 2016/6/10.
 */
public abstract class LibraryItem {
    protected String name;
    protected String author;
    protected GregorianCalendar publishTime;

    public LibraryItem(String name, String author, GregorianCalendar publishTime) {
        this.name = name;
        this.author = author;
        this.publishTime = publishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public GregorianCalendar getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(GregorianCalendar publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishTime=" + getPublishTimeFormat();
    }

    public String getPublishTimeFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(publishTime.getTime());
    }
}
