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
    public void testBorrowItem() throws Exception {
        Book book=new Book("A","xxx",new GregorianCalendar(2000,1,15));
        Person person=new Person("User1","123456","396651773@qq.com","Wuhan","1777180xxxx","Normal");
        assertTrue(person.borrowItem(book));
        assertTrue(person.getBorrowedItem().contains(book));
    }

    @Test
    public void testReturnItem() throws Exception {
        Book book=new Book("A","xxx",new GregorianCalendar(2000,1,15));
        Person person=new Person("User1","123456","396651773@qq.com","Wuhan","1777180xxxx","Normal");
        person.borrowItem(book);
        assertTrue(person.getBorrowedItem().contains(book));
        assertTrue(person.returnItem(book));
        assertFalse(person.getBorrowedItem().contains(book));
        assertFalse(person.returnItem(book));
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