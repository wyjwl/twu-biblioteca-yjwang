package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by WYJ on 2016/6/7.
 */
public class PersonTest {

    @Test
    public void testBorrowBook() throws Exception {
        Book book=new Book("A","xxx",new GregorianCalendar(2000,1,15));
        Person person=new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx");
        assertTrue(person.borrowBook(book));
        assertTrue(person.getBorrowedBook().contains(book));
    }

    @Test
    public void testReturnBook() throws Exception {
        Book book=new Book("A","xxx",new GregorianCalendar(2000,1,15));
        Person person=new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx");
        person.borrowBook(book);
        assertTrue(person.returnBook(book));
        assertFalse(person.getBorrowedBook().contains(book));
        assertFalse(person.returnBook(book));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx")
                .equals(new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx")));
        assertTrue(new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx")
                .equals(new Person("111","jywang111","396651773@qq.com","Wuhan","1777180xxxx")));
        assertFalse(new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx")
                .equals(new Person("222","jywang","396651773@qq.com","Wuhan","1777180xxxx")));
        assertFalse(new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx")
                .equals(new Person("222","jywang222","396651773@qq.com","Wuhan","1777180xxxx")));
    }
}