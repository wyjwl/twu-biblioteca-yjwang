package com.twu.biblioteca;


/**
 * Created by WYJ on 2016/6/6.
 */
public class Book {
    private String name;
    private String author;
    private String publishTime;

    public Book(String name, String author, String publishTime) {
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

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public boolean equals(Object object){
        Book book=(Book)object;
        return name==book.name && author==book.author && publishTime==book.publishTime;
    }
}
