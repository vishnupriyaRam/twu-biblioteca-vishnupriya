package com.twu.biblioteca.model;

public class Book {
    public final String title;
    public final String author;
    public final String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String view() {
        String delimiter = " | ";
        return title + delimiter + author + delimiter + year;
    }

    public boolean hasSameName(String title) {
        return this.title.equals(title);
    }
}
