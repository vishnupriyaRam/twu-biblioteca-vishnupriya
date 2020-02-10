package com.twu.biblioteca.model;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Book {
    public final String title;
    public final String author;
    public final String year; // TODO - year as a string, sort of weird?

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // TODO - new feature - books later than year 2000 (recent books only feature)
//    public boolean isRecent() {
//        if(year != null) {
//            return Integer.parseInt(year) > 2000;
//        } else {
//            throw new OperationNotSupportedException();
//        }
//    }

    public void view() {
        String delimiter = " | ";
        System.out.println(title + delimiter + author + delimiter + year);
    }

    public boolean getByName(String title) {
        return this.title.equals(title);
    }
}
