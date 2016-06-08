package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by WYJ on 2016/6/8.
 */
public class LibraryTest {
    Library library=new Library();

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    @Test
    public void testLibraryMenu() throws Exception {
        String expectOutput="Please select:\r\n" +
                "1.Lists Books\r\n" +
                "9.Quit";
        ByteArrayOutputStream outContent = getByteArrayOutputStream();
        library.libraryMenu();
        assertEquals(expectOutput, outContent.toString().trim());
    }

    @Test
    public void testListAvailableBooks() throws Exception {
        String expectOutput="name='book1', author='author1', publishTime=2000-02-01\r\n" +
                "name='book1', author='author1', publishTime=2000-02-01\r\n" +
                "name='book2', author='author2', publishTime=2000-03-01\r\n" +
                "name='book3', author='author3', publishTime=2000-04-01\r\n" +
                "name='book4', author='author4', publishTime=2000-05-01";
        ByteArrayOutputStream outContent = getByteArrayOutputStream();
        library.listAvailableBooks();
        assertEquals(expectOutput, outContent.toString().trim());
    }

    @Test
    public void testCheckoutBook() throws Exception {
        assertTrue(library.checkoutBook("book2"));
        assertFalse(library.checkoutBook("book9"));
    }
}