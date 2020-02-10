package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksAvailable;
    private List<Book> checkedOut = new ArrayList<>();

    public Library(List<Book> booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    public void view() {
        booksAvailable.forEach(book -> {
            if (!checkedOut.contains(book))
                book.view();
        });
    }

    public void checkout(String title) {
        Book book = getBook(title);
        if (book != null) {
            checkedOut.add(book);
            System.out.println(NotificationMessages.CHECKOUT_SUCCESS.getMessage());
        } else
            System.out.println(NotificationMessages.CHECKOUT_FAILURE.getMessage());
    }

    public void returnBook(String title) {
        Book book = getBook(title);
        if (checkedOut.contains(book)) {
            checkedOut.remove(book);
            System.out.println(NotificationMessages.RETURN_SUCCESS.getMessage());
        } else
            System.out.println(NotificationMessages.RETURN_FAILURE.getMessage());
    }

    private Book getBook(String title) {
        for (Book book : booksAvailable) {
            if (book.getByName(title))
                return book;
        }
        return null;
    }
}
