package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class Library {
    private List<Book> booksAvailable;
    private List<Movie> moviesAvailable;
    private List<Book> checkedOut = new ArrayList<>();


    public Library(List<Book> booksAvailable, List<Movie> moviesAvailable) {
        this.booksAvailable = booksAvailable;
        this.moviesAvailable = moviesAvailable;
    }

    public String viewBooks() {
        StringJoiner list = new StringJoiner("\n");

        booksAvailable.forEach(book -> {
            if (!checkedOut.contains(book)) {
                list.add(book.getDetails());
            }
        });
        return list.toString();
    }

    // TODO - what are different ways to not break CSQ here?
    // TODO - is this a valid usecase to break CQS? - Think about it.
    public boolean checkout(String title) {
        Book book = getBook(title);
        if (book != null && !checkedOut.contains(book)) {
            checkedOut.add(book);
            return true;
        } else
            return false;
    }

    public boolean returnBook(String title) {
        Book book = getBook(title);
        if (checkedOut.contains(book)) {
            checkedOut.remove(book);
            return true;
        } else
            return false;
    }

    private Book getBook(String title) { // TODO - its private, so its still okay....
        for (Book book : booksAvailable) {
            if (book.hasSameName(title))
                return book;
        }
        return null; // TODO - don't return nulls? so what's the problem with nulls?
    }

    public String viewMovies() {
        StringJoiner list = new StringJoiner("\n");

        moviesAvailable.forEach(book ->
                list.add(book.getDetails())
        );
        return list.toString();
    }
}
