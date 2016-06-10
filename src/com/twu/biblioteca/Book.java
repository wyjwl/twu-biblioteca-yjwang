package com.twu.biblioteca;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by WYJ on 2016/6/6.
 */
public class Book extends LibraryItem{

    public Book(String name, String author, GregorianCalendar publishTime) {
        super(name,author,publishTime);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishTime=" + getPublishTimeFormat();
    }

}
