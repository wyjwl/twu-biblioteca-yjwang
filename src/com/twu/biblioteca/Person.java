package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by WYJ on 2016/6/6.
 */
public class Person {

    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> borrowedBook;

    public Person(String id, String name, String email, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
