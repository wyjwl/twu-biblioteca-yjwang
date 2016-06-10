package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by WYJ on 2016/6/6.
 */
public class Person {

    private String userName;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private String level;
    private ArrayList<Book> borrowedBook;


    public Person(String userName, String password, String email, String address, String phoneNumber, String level) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level = level;
        borrowedBook=new ArrayList<Book>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        return userName.equals(person.userName);
    }
}
