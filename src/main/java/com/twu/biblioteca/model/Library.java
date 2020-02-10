package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


//todo checkout and return displays boolean. message not getting displayed

public class Library {
    private List<Book> booksAvailable;
    private List<Book> checkedOut = new ArrayList<>();

    public Library(List<Book> booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    public String view() {
        StringJoiner list = new StringJoiner("\n");

        booksAvailable.forEach(book -> {
            if (!checkedOut.contains(book)) {
                list.add(book.view());
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

    public Book getBook(String title) { // TODO - its private, so its still okay....
        for (Book book : booksAvailable) {
            if (book.hasSameName(title))
                return book;
        }
        return null; // TODO - don't return nulls? so what's the problem with nulls?
    }
}
