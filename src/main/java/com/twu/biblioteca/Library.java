package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksAvailable = new ArrayList<>();

    public Library() {
        addBooks();
    }

    public void view() {
        this.booksAvailable.forEach(Book::viewBookInfo);
    }

    private void addBooks() {
        booksAvailable.add(new Book("Harry Potter", "Rowling JK", "2001"));
        booksAvailable.add(new Book("The Fault in our stars", "Green John", "2012"));
        booksAvailable.add(new Book("A song of ice and fire", "Martin RR George", "1996"));
    }
}
