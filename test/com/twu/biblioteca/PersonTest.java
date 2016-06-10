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
        Person person=new Person("User1","123456","396651773@qq.com","Wuhan","1777180xxxx","Normal");
        assertTrue(person.borrowBook(book));
        assertTrue(person.getBorrowedBook().contains(book));
    }

    @Test
    public void testReturnBook() throws Exception {
        Book book=new Book("A","xxx",new GregorianCalendar(2000,1,15));
        Person person=new Person("User1","123456","396651773@qq.com","Wuhan","1777180xxxx","Normal");
        person.borrowBook(book);
        assertTrue(person.returnBook(book));
        assertFalse(person.getBorrowedBook().contains(book));
        assertFalse(person.returnBook(book));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new Person("yjwang","123456","396651773@qq.com","Wuhan","1777180xxxx","Normal")
                .equals(new Person("yjwang","123456","396651773@qq.com","Wuhan","1777180xxxx","Normal")));
        assertTrue(new Person("yjwang","123456","396651773@qq.com","Wuhan","1777180xxxx","Normal")
                .equals(new Person("yjwang","12345678","396651773@qq.com","Wuhan","1777180xxxx","Normal")));
        assertFalse(new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx","Normal")
                .equals(new Person("222","jywang","396651773@qq.com","Wuhan","1777180xxxx","Normal")));
        assertFalse(new Person("111","jywang","396651773@qq.com","Wuhan","1777180xxxx","Normal")
                .equals(new Person("222","jywang222","396651773@qq.com","Wuhan","1777180xxxx","Normal")));
    }
}