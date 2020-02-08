package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksAvailable = new ArrayList<>();

    public Library() {
        addBooks();
    }

    public List<Book> getBooksAvailable(){
        return booksAvailable;
    }

    private void addBooks() {
        booksAvailable.add(new Book("A"));
        booksAvailable.add(new Book("B"));
        booksAvailable.add(new Book("C"));
    }
}
