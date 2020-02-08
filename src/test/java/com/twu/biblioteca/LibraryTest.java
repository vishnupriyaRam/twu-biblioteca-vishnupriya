package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    void shouldReturnTheListOfBooksAvailable() {
        Library library = new Library();
        List<Book> books = Arrays.asList(
                new Book("A"),
                new Book("B"),
                new Book("C"));
        assertEquals(books, library.getBooksAvailable());
    }
}