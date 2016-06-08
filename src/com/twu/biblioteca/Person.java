package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by WYJ on 2016/6/6.
 */
public class Person {
    private String id;
    private String name;
    private ArrayList<Book> borrowedBook;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
        borrowedBook=new ArrayList<Book>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBook() {
        return borrowedBook;
    }

    public boolean borrowBook(Book book){
        return borrowedBook.add(book);
    }

    public boolean returnBook(Book book){
        return borrowedBook.remove(book);
    }

    public boolean equals(Object object){
        Person person=(Person)object;
        return id.equals(person.id);
    }
}
