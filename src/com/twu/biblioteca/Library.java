package com.twu.biblioteca;

import java.util.*;

/**
 * Created by WYJ on 2016/6/7.
 */
public class Library {
    private String userSelection;
    private ArrayList<Person> allUsers;
    private Person currentUser;
    private ArrayList<LibraryRecord> libraryRecords;
    private ArrayList<LibraryItem> libraryItems;
    private ArrayList<LibraryItem> checkedoutItems;
    private ArrayList<LibraryItem> availableItems;

    public Library() {
        initLibraryItems();
        initUsers();
    }

    public void setCurrentUser(Person currentUser) {
        this.currentUser = currentUser;
    }

    public boolean login(String ...args){
        String userName;
        String password;
        boolean isTest=(args.length!=0);
        if(isTest){
            userName=args[0];
            password=args[1];
        }
        else{
            System.out.println("Please input username:");
            userName=getInput();
            System.out.println("Please input password");
            password=getInput();
        }
        Iterator<Person> it=allUsers.iterator();
        while(it.hasNext()){
            Person person=it.next();
            if(person.getUserName().equals(userName) && person.getPassword().equals(password)){
                currentUser=person;
                return true;
            }
        }
        return false;
    }

    private void initUsers() {
        allUsers=new ArrayList<Person>();
        allUsers.add(new Person("User1","123456","aaaaaa@gmail.com","Bangalore","123456789","normal"));
        allUsers.add(new Person("User2","123456","bbbbbb@gmail.com","Pune","987654321","normal"));
        allUsers.add(new Person("User3","123456","cccccc@gmail.com","Pune","147852369","admin"));
    }


    public void showCurrentUserInfo(){
        System.out.println(currentUser);
    }
    public ArrayList<LibraryItem> getCheckedoutBooks() {
        return checkedoutItems;
    }

    public ArrayList<LibraryItem> getAvailableBooks() {
        return availableItems;
    }

    public ArrayList<LibraryRecord> getLibraryRecords() {
        return libraryRecords;
    }

    private void initLibraryItems() {
        libraryItems=new ArrayList<LibraryItem>();
        checkedoutItems=new ArrayList<LibraryItem>();
        availableItems=new ArrayList<LibraryItem>();
        libraryItems.add(new Book("book1","author1",new GregorianCalendar(2000,1,1)));
        libraryItems.add(new Book("book1","author1",new GregorianCalendar(2000,1,1)));
        libraryItems.add(new Book("book2","author2",new GregorianCalendar(2000,2,1)));
        libraryItems.add(new Book("book3","author3",new GregorianCalendar(2000,3,1)));
        libraryItems.add(new Book("book4","author4",new GregorianCalendar(2000,4,1)));
        libraryItems.add(new Movie("movie1","author1",new GregorianCalendar(2000,4,1),9.2));
        libraryItems.add(new Movie("movie2","author2",new GregorianCalendar(2001,4,1),8.5));
        libraryItems.add(new Movie("movie3","author3",new GregorianCalendar(2002,4,1),7.8));
        availableItems=libraryItems;
        libraryRecords=new ArrayList<LibraryRecord>();
    }

    public void setUserSelection(String userSelection) {
        this.userSelection = userSelection;
    }

    public void libraryMenu(){
        if(currentUser.getLevel().equals("normal")) {
            System.out.println("Please select:");
            System.out.println("1.Lists Books");
            System.out.println("2.Check out Book");
            System.out.println("3.Return Book");
            System.out.println("4.Lists Movies");
            System.out.println("5.Check out Movie");
            System.out.println("6.Return Movie");
            System.out.println("7.My Information");
            System.out.println("9.Quit");
        }
        else{
            System.out.println("1.Check library record");
        }
    }

    public void run(){
        showWelcomeMsg();
        while(true) {
            if(login()) {
                showSystemMenu();
            }
            else{
                System.out.println("Login failed, please try again.");
            }
        }
    }

    private void showWelcomeMsg() {
        Welcome welcome=new Welcome();
        System.out.println(welcome.getWelcomeMsg());
    }

    private void showSystemMenu() {
        boolean systemRun=true;
        while(systemRun){
            libraryMenu();
            if(currentUser.getLevel().equals("normal")) {
                switch (Integer.parseInt(getInput())) {
                    case 1:
                        userSelection = "book";
                        listAvailableItems();
                        break;
                    case 2:
                        userSelection = "book";
                        checkoutItem();
                        break;
                    case 3:
                        userSelection = "book";
                        returnItem();
                        break;
                    case 4:
                        userSelection = "movie";
                        listAvailableItems();
                        break;
                    case 5:
                        userSelection = "movie";
                        checkoutItem();
                        break;
                    case 6:
                        userSelection = "movie";
                        returnItem();
                        break;
                    case 7:
                        showCurrentUserInfo();
                        break;
                    case 9:
                        systemRun = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again:");
                        break;
                }
            }
            else{
                switch (Integer.parseInt(getInput())) {
                    case 1:
                        showLibraryRecord();
                        break;
                    case 9:
                        systemRun = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again:");
                        break;
                }
            }
        }
    }

    public void listAvailableItems() {
        Iterator<LibraryItem> it=availableItems.iterator();
        while (it.hasNext()) {
            LibraryItem item = it.next();
            if(userSelection.equals("book") && (item instanceof Book)){
                System.out.println(item);
            }
            else if(userSelection.equals("movie") && (item instanceof Movie)){
                System.out.println(item);
            }
        }
    }

    public void showLibraryRecord(){
        Iterator<LibraryRecord> it=libraryRecords.iterator();
        while(it.hasNext()){
            LibraryRecord record=it.next();
            System.out.println(record);
        }
    }
    private String getInput() {
        Scanner userInput=new Scanner(System.in);
        return userInput.nextLine();
    }

    public boolean checkoutItem(String ...args){
        System.out.println("Input the "+userSelection+" name you want to borrow:");
        String itemName;
        boolean isTest=(args.length!=0);
        if(isTest) {
            itemName =args[0];
        }
        else{
            itemName =getInput();
        }
        ArrayList<LibraryItem> searchResult = getCheckoutSearchResult(itemName);
        if(searchResult.isEmpty()){
            System.out.println("That "+userSelection+" is not available.");
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
                availableItems.remove(searchResult.get(index));
                checkedoutItems.add(searchResult.get(index));
                currentUser.borrowItem(searchResult.get(index));
                libraryRecords.add(new LibraryRecord(currentUser,searchResult.get(index),"Checkout",new GregorianCalendar()));
                System.out.println("Thank you! Enjoy the "+userSelection+".");
                return true;
            }
            else{
                return false;
            }
        }
    }

    private int getCheckoutIndex(ArrayList<LibraryItem> searchResult,int ...args) {
        int index=1;
        Iterator<LibraryItem> it;
        it=searchResult.iterator();
        System.out.println("Which one you want to borrow?");
        while(it.hasNext()){
            LibraryItem item=it.next();
            System.out.println(index+++"."+item);
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

    public ArrayList<LibraryItem> getCheckoutSearchResult(String itemName) {
        ArrayList<LibraryItem> checkoutSearchResult=new ArrayList<LibraryItem>();
        Iterator<LibraryItem> it=availableItems.iterator();
        while(it.hasNext()){
            LibraryItem item=it.next();
            if(item.nameEquals(itemName) && userSelection.equals("book") && (item instanceof Book)){
                checkoutSearchResult.add(item);
            }
            else if(item.nameEquals(itemName) && userSelection.equals("movie") && (item instanceof Movie)){
                checkoutSearchResult.add(item);
            }
        }
        return checkoutSearchResult;
    }

    public LibraryItem isTheItemBelongsToTheLibrary(String itemName,String authorName){
        Iterator<LibraryItem> it=checkedoutItems.iterator();
        while(it.hasNext()){
            LibraryItem item=it.next();
            if(item.nameAndAuthorEquals(itemName,authorName)){
                return item;
            }
        }
        return null;
    }

    public boolean returnItem(String ...args){
        String itemName;
        String authorName;
        boolean isTest=(args.length!=0);
        if(isTest) {
            itemName =args[0];
            authorName=args[1];
        }
        else{
            System.out.println("Input the "+userSelection+" name you want to return:");
            itemName =getInput();
            System.out.println("Input the "+userSelection+" author name:");
            authorName=getInput();
        }
        LibraryItem returnItem=isTheItemBelongsToTheLibrary(itemName,authorName);
        if(returnItem==null){
            System.out.println("That is not a valid "+userSelection+" to return.");
            return false;
        }
        else{
            availableItems.add(returnItem);
            checkedoutItems.remove(returnItem);
            currentUser.returnItem(returnItem);
            libraryRecords.add(new LibraryRecord(currentUser,returnItem,"Return", new GregorianCalendar()));
            System.out.println("Thank you for returning the "+userSelection+" .");
            return true;
        }

    }


}
