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
    LibraryItem book1=new Book("book1","author1",new GregorianCalendar(2000,1,1));
    LibraryItem book2=new Book("book2","author2",new GregorianCalendar(2000,2,1));
    LibraryItem book3=new Book("book3","author3",new GregorianCalendar(2000,3,1));
    LibraryItem book4=new Book("book4","author4",new GregorianCalendar(2000,4,1));
    LibraryItem movie1=new Movie("movie1","author1",new GregorianCalendar(2000,4,1),8.7);
    LibraryItem movie2=new Movie("movie2","author2",new GregorianCalendar(2001,4,1),7.7);
    LibraryItem movie3=new Movie("movie3","author3",new GregorianCalendar(2002,4,1),9.0);

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }


    private void testItemDontExistsCheckout() {
        String bookDontExists="book999";
        String movieDontExists="movie999";
        library.setUserSelection("book");
        assertFalse(library.checkoutItem(bookDontExists));
        library.setUserSelection("movie");
        assertFalse(library.checkoutItem(movieDontExists));
    }

    private void testOnlyOneItemCheckout() {
        ArrayList<Book> searchResult;
        String containsOnlyOneItem="movie2";
        library.setUserSelection("movie");
        assertTrue(library.getAvailableBooks().contains(movie2));
        assertTrue(library.checkoutItem(containsOnlyOneItem));
        assertFalse(library.getAvailableBooks().contains(movie2));
        assertTrue(library.getCheckedoutBooks().contains(movie2));
    }

    private void testMultipleSameItemCheckout() {
        String containsMoreThanOneBook="book1";
        library.setUserSelection("book");
        assertTrue(library.getAvailableBooks().contains(book1));
        assertTrue(library.checkoutItem(containsMoreThanOneBook));
        assertTrue(library.getAvailableBooks().contains(book1));
        assertTrue(library.getCheckedoutBooks().contains(book1));
    }

    private void testReturnItemDontBelongToTheLibrary() {
        library.setUserSelection("book");
        assertFalse(library.returnItem("book999","author999"));
        library.setUserSelection("movie");
        assertFalse(library.returnItem("movie999","author999"));
    }

    private void testReturnItemBelongsToTheLibrary() {
        library.setUserSelection("book");
        library.checkoutItem("book3");
        assertFalse(library.getAvailableBooks().contains(book3));
        assertTrue(library.getCheckedoutBooks().contains(book3));
        assertTrue(library.returnItem("book3","author3"));
        assertTrue(library.getAvailableBooks().contains(book3));
        assertFalse(library.getCheckedoutBooks().contains(book3));
    }

    @Test
    public void testLibraryMenu() throws Exception {
        String expectOutput="Please select:\r\n" +
                "1.Lists Books\r\n" +
                "2.Check out Book\r\n"+
                "3.Return Book\r\n"+
                "4.Lists Movies\r\n"+
                "5.Check out Movie\r\n"+
                "6.Return Movie\r\n"+
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
        library.setUserSelection("book");
        library.listAvailableItems();
        assertEquals(expectOutput, outContent.toString().trim());
    }

    @Test
    public void testCheckoutBook() throws Exception {
        library.setCurrentUser(new Person("User1","123456","aaaaaa@gmail.com","Bangalore","123456789","normal"));
        testMultipleSameItemCheckout();
        testOnlyOneItemCheckout();
        testItemDontExistsCheckout();
        System.out.println(library.getLibraryRecords());
    }

    @Test
    public void testReturnBook() throws Exception {
        library.setCurrentUser(new Person("User1","123456","aaaaaa@gmail.com","Bangalore","123456789","normal"));
        testReturnItemBelongsToTheLibrary();
        testReturnItemDontBelongToTheLibrary();
        System.out.println(library.getLibraryRecords());
    }

}