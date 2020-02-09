package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksAvailable = new ArrayList<>();
    private List<Book> checkedOut = new ArrayList<>();

    public Library() {
        addBooks();
    }

    public void view() {
        booksAvailable.forEach(book -> {
            if (!checkedOut.contains(book))
                book.viewBookInfo();
        });
    }

    private void addBooks() {
        booksAvailable.add(new Book("Harry Potter", "Rowling JK", "2001"));
        booksAvailable.add(new Book("The Fault in our stars", "Green John", "2012"));
        booksAvailable.add(new Book("A song of ice and fire", "Martin RR George", "1996"));
    }

    public void checkOut(String title) {
        Book book = getBook(title);
        if (book != null) {
            checkedOut.add(book);
            System.out.println(NotificationMessages.CHECKOUT_SUCCESS.getMessage());
        } else
            System.out.println(NotificationMessages.CHECKOUT_FAILURE.getMessage());
    }

    private Book getBook(String title) {
        Book bookNeeded = new Book(title);
        for (Book book : booksAvailable) {
            if (book.equals(bookNeeded))
                return book;
        }
        return null;
    }

    public void returnBook(String title) {
        Book book = getBook(title);
        if (checkedOut.contains(book)) {
            checkedOut.remove(book);
            System.out.println(NotificationMessages.RETURN_SUCCESS.getMessage());
        } else
            System.out.println(NotificationMessages.RETURN_FAILURE.getMessage());
    }
}
