package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by WYJ on 2016/6/6.
 */
public class WelcomeTest {

    @Test
    public void testGetWelcomeMsg() throws Exception {
        Welcome welcome=new Welcome();
        assertTrue(welcome.getWelcomeMsg().equals("Welcome to Bangalore Public Library"));
    }

}