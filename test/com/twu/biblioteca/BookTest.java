package com.twu.biblioteca;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;
/**
 * Created by WYJ on 2016/6/6.
 */
public class BookTest {

    @Test
    public void testBookEquals() throws Exception {
        assertTrue(new Book("A","B",new GregorianCalendar(2000,1,15)).equals(new Book("A","B",new GregorianCalendar(2000,1,15))));
        assertFalse(new Book("A","B",new GregorianCalendar(2000,1,15)).equals(new Book("AA","B",new GregorianCalendar(2000,1,15))));
        assertFalse(new Book("A","B",new GregorianCalendar(2000,1,15)).equals(new Book("A","BB",new GregorianCalendar(2000,1,15))));
        assertFalse(new Book("A","B",new GregorianCalendar(2000,1,15)).equals(new Book("A","B",new GregorianCalendar(2000,1,16))));
    }
}