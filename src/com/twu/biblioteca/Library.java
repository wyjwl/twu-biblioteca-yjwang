package com.twu.biblioteca;

import java.util.*;

/**
 * Created by WYJ on 2016/6/7.
 */
public class Library {
    private ArrayList<Book> libraryBooks;
    private ArrayList<Book> checkedoutBooks;
    private ArrayList<Book> availableBooks;
    public Library() {
        libraryBooks=new ArrayList<Book>();
        checkedoutBooks=new ArrayList<Book>();
        availableBooks=new ArrayList<Book>();
        libraryBooks.add(new Book("book1","author1",new GregorianCalendar(2000,1,1)));
        libraryBooks.add(new Book("book1","author1",new GregorianCalendar(2000,1,1)));
        libraryBooks.add(new Book("book2","author2",new GregorianCalendar(2000,2,1)));
        libraryBooks.add(new Book("book3","author3",new GregorianCalendar(2000,3,1)));
        libraryBooks.add(new Book("book4","author4",new GregorianCalendar(2000,4,1)));
        availableBooks=libraryBooks;
    }

    public void libraryMenu(){
        System.out.println("Please select:");
        System.out.println("1.Lists Books");
        System.out.println("2.Check out Book");
        System.out.println("9.Quit");
    }

    public void run(){
        showWelcomeMsg();
        showSystemMenu();
    }

    private void showWelcomeMsg() {
        Welcome welcome=new Welcome();
        System.out.println(welcome.getWelcomeMsg());
    }

    private void showSystemMenu() {
        boolean systemRun=true;
        while(systemRun){
            libraryMenu();
            switch (Integer.parseInt(getInput())){
                case 1:listAvailableBooks();
                    break;
                case 2:checkoutBook();
                    break;
                case 9:
                    systemRun=false;
                    break;
                default:
                    System.out.println("Invalid input, please try again:");
                    break;
            }
        }
    }

    public void listAvailableBooks() {
        Iterator<Book> it=availableBooks.iterator();
        while(it.hasNext()){
            Book b=it.next();
            System.out.println(b);
        }
    }

    private String getInput() {
        Scanner userInput=new Scanner(System.in);
        return userInput.nextLine();
    }

    public boolean checkoutBook(String ...args){
        System.out.println("Input the book name you want to check out:");
        String bookName;
        boolean isTest=(args.length!=0);
        if(isTest) {
            bookName =args[0];
        }
        else{
            bookName =getInput();
        }
        ArrayList<Book> searchResult = getSearchResult(bookName);
        if(searchResult.isEmpty()){
            System.out.println("Can not find this book!");
            return false;
        }
        else{
            int index;
            if(isTest) {
                index = getCheckoutIndex(searchResult,0);
            }
            else{
                index = getCheckoutIndex(searchResult);
            }
            if(index>-1) {
                availableBooks.remove(searchResult.get(index));
                checkedoutBooks.add(searchResult.get(index));
                System.out.println("Enjoy the book!");
                return true;
            }
            else{
                return false;
            }
        }
    }

    private int getCheckoutIndex(ArrayList<Book> searchResult,int ...args) {
        int index=1;
        Iterator<Book> it;
        it=searchResult.iterator();
        System.out.println("Which one you want to borrow?");
        while(it.hasNext()){
            Book b=it.next();
            System.out.println(index+++"."+b);
        }
        if(args.length==0) {
            int input = Integer.parseInt(getInput()) - 1;
            while (input >= index) {
                System.out.println("Invalid input, try again(press 0 to cancel):");
                input = Integer.parseInt(getInput()) - 1;
            }
            return input;
        }
        else{
            return args[0];
        }
    }

    private ArrayList<Book> getSearchResult(String bookName) {
        ArrayList<Book> searchResult=new ArrayList<Book>();
        Iterator<Book> it=availableBooks.iterator();
        while(it.hasNext()){
            Book b=it.next();
            if(b.nameEquals(bookName)){
                searchResult.add(b);
            }
        }
        return searchResult;
    }


}
