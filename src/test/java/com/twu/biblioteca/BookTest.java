package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldTestIfTwoBooksAreSame() {
        Book book1 = new Book("Harry Potter");
        Book book2 = new Book("Harry Potter");

        assertEquals(book1, book2);
    }

    @Test
    void shouldReturnTheTitleOfTheBook() {
        Book book = new Book("Harry Potter");
        String expected = "Harry Potter";
        assertEquals(expected, book.toString());
    }
}