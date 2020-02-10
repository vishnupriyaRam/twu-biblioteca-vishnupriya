package com.twu.biblioteca.model;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Book {
    public final String title;
    public final String author;
    public final String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void view() {
        String delimiter = " | ";
        System.out.println(title + delimiter + author + delimiter + year);
    }

    public boolean getByName(String title) {
        return this.title.equals(title);
    }
}
