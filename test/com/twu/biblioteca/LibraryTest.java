package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by WYJ on 2016/6/8.
 */
public class LibraryTest {
    Library library=new Library();
    Book book1=new Book("book1","author1",new GregorianCalendar(2000,1,1));
    Book book2=new Book("book2","author2",new GregorianCalendar(2000,2,1));
    Book book3=new Book("book3","author3",new GregorianCalendar(2000,3,1));
    Book book4=new Book("book4","author4",new GregorianCalendar(2000,4,1));

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }


    private void testBookDontExistsCheckout() {
        String bookDontExists="book999";
        assertFalse(library.checkoutBook(bookDontExists));
    }

    private void testOnlyOneBookCheckout() {
        ArrayList<Book> searchResult;
        String containsOnlyOneBook="book2";
        assertTrue(library.getAvailableBooks().contains(book2));
        assertTrue(library.checkoutBook(containsOnlyOneBook));
        assertFalse(library.getAvailableBooks().contains(book2));
        assertTrue(library.getCheckedoutBooks().contains(book2));
    }

    private void testMultipleSameBookCheckout() {
        String containsMoreThanOneBook="book1";
        assertTrue(library.getAvailableBooks().contains(book1));
        assertTrue(library.checkoutBook(containsMoreThanOneBook));
        assertTrue(library.getAvailableBooks().contains(book1));
        assertTrue(library.getCheckedoutBooks().contains(book1));
    }

    private void testReturnBookDontBelongToTheLibrary() {
        assertFalse(library.returnBook("book999","author999"));
    }

    private void testReturnBookBelongsToTheLibrary() {
        library.checkoutBook("book3");
        assertFalse(library.getAvailableBooks().contains(book3));
        assertTrue(library.getCheckedoutBooks().contains(book3));
        assertTrue(library.returnBook("book3","author3"));
        assertTrue(library.getAvailableBooks().contains(book3));
        assertFalse(library.getCheckedoutBooks().contains(book3));
    }

    @Test
    public void testLibraryMenu() throws Exception {
        String expectOutput="Please select:\r\n" +
                "1.Lists Books\r\n" +
                "2.Check out Book\r\n"+
                "3.Return Book\r\n"+
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
        testMultipleSameBookCheckout();
        testOnlyOneBookCheckout();
        testBookDontExistsCheckout();
    }

    @Test
    public void testReturnBook() throws Exception {
        testReturnBookBelongsToTheLibrary();
        testReturnBookDontBelongToTheLibrary();
    }

}