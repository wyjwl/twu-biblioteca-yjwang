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
        Person person=new Person("111","jywang");
        assertTrue(person.borrowBook(book));
        assertTrue(person.getBorrowedBook().contains(book));
    }

    @Test
    public void testReturnBook() throws Exception {
        Book book=new Book("A","xxx",new GregorianCalendar(2000,1,15));
        Person person=new Person("111","jywang");
        person.borrowBook(book);
        assertTrue(person.returnBook(book));
        assertFalse(person.getBorrowedBook().contains(book));
        assertFalse(person.returnBook(book));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new Person("1","yjwang").equals(new Person("1","yjwang")));
        assertTrue(new Person("1","yjwang").equals(new Person("1","yjwang111")));
        assertFalse(new Person("1","yjwang").equals(new Person("2","yjwang")));
        assertFalse(new Person("1","yjwang").equals(new Person("2","yjwang111")));
    }
}