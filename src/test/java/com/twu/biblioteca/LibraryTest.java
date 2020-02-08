package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;


class LibraryTest {
    @Test
    void shouldReturnTheListOfBooksAvailable() {
        Library library = new Library();
        List<Book> books = asList(
                new Book("Harry Potter", "Rowling JK", "2001"),
                new Book("The Fault in our stars", "Green John", "2012"),
                new Book("A song of ice and fire", "Martin RR George", "1996"));

        assertEquals(books, library.getBooksAvailable());
    }
}