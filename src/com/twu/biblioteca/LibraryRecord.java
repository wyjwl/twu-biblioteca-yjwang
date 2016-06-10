package com.twu.biblioteca;


import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by WYJ on 2016/6/11.
 */
public class LibraryRecord {
    private Person person;
    private LibraryItem item;
    private String state;
    private GregorianCalendar time;

    public LibraryRecord(Person person, LibraryItem item, String state, GregorianCalendar time) {
        this.person = person;
        this.item = item;
        this.state= state;
        this.time = time;
    }

    public Person getPerson() {
        return person;
    }

    public LibraryItem getItem() {
        return item;
    }

    public GregorianCalendar getTime() {
        return time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getTimeFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(time.getTime());
    }
    @Override
    public String toString() {
        return "User=" + person.getUserName() +
                ", item=" + item +
                ", state='" + state + '\'' +
                ", Date=" + getTimeFormat();
    }
}
