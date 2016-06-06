package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by WYJ on 2016/6/6.
 */
public class BookTest {

    @Test
    public void testBookEquals() throws Exception {
        assertTrue(new Book("A","B","2000-01-15").equals(new Book("A","B","2000-01-15")));
        assertFalse(new Book("A","B","2000-01-15").equals(new Book("AA","B","2000-01-15")));
        assertFalse(new Book("A","B","2000-01-15").equals(new Book("A","BB","2000-01-15")));
        assertFalse(new Book("A","B","2000-01-15").equals(new Book("A","B","2000-01-16")));
    }
}