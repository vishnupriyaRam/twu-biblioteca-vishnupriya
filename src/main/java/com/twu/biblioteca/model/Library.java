package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    public NotificationMessages checkout(String title) {
        Book book = getBook(title);
        if (book != null) {
            checkedOut.add(book);
            return NotificationMessages.CHECKOUT_SUCCESS;
        } else
            return NotificationMessages.CHECKOUT_FAILURE;
    }

    public NotificationMessages returnBook(String title) {
        Book book = getBook(title);
        if (checkedOut.contains(book)) {
            checkedOut.remove(book);
            return NotificationMessages.RETURN_SUCCESS;
        } else
            return NotificationMessages.RETURN_FAILURE;
    }

    private Book getBook(String title) {
        for (Book book : booksAvailable) {
            if (book.getByName(title))
                return book;
        }
        return null;
    }
}
