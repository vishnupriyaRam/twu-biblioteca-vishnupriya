package com.twu.biblioteca;

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

    public Book(String title) {
        this.title = title;
        this.author = null;
        this.year = null;
    }

    public void viewBookInfo() {
        System.out.println(title + " | " + author + " | " + year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
