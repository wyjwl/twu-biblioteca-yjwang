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
}
