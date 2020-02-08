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
                new Book("A"),
                new Book("B"),
                new Book("C"));

        assertEquals(books, library.getBooksAvailable());
    }
}