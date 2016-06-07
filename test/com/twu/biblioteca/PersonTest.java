package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by WYJ on 2016/6/7.
 */
public class PersonTest {

    @Test
    public void testBorrowBook() throws Exception {
        Book book=new Book("A","xxx","1990-07-05");
        Person person=new Person("111","jywang");
        assertTrue(person.BorrowBook(book));
    }

    @Test
    public void testReturnBook() throws Exception {
        Book book=new Book("A","xxx","1990-07-05");
        Person person=new Person("111","jywang");
        person.BorrowBook(book);
        assertTrue(person.ReturnBook(book));
        assertTrue(person.getBorrowedBook().isEmpty());
        assertFalse(person.ReturnBook(book));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new Person("1","yjwang").equals(new Person("1","yjwang")));
        assertTrue(new Person("1","yjwang").equals(new Person("1","yjwang111")));
        assertFalse(new Person("1","yjwang").equals(new Person("2","yjwang")));
        assertFalse(new Person("1","yjwang").equals(new Person("2","yjwang111")));
    }
}