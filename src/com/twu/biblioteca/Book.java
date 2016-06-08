package com.twu.biblioteca;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by WYJ on 2016/6/6.
 */
public class Book {
    private String name;
    private String author;
    private GregorianCalendar publishTime;

    public Book(String name, String author, GregorianCalendar publishTime) {
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

    public boolean equals(Object object){
        Book book=(Book)object;
        return name.equals(book.name) && author.equals(book.author) && publishTime.equals(book.publishTime);
    }

    public boolean nameEquals(String bookName){
        return name.equals(bookName);
    }

    public boolean nameAndAuthorEquals(String bookName,String authorName){
        return name.equals(bookName) && author.equals(authorName);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishTime=" + getPublishTimeFormat();
    }

    private String getPublishTimeFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(publishTime.getTime());
    }
}
