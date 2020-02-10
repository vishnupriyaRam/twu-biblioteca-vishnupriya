package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldDisplayListOfBooksAvailable() {
        Book book = new Book("Harry Potter", "Rowling JK", "2001");
        String expected = "Harry Potter | Rowling JK | 2001";

        assertEquals(expected, book.getDetails());
    }

    @Test
    void shouldTestIfTwoBooksAreSame() {
        Book book1 = new Book("Harry Potter", "Rowling JK", "2001");

        assertTrue(book1.hasSameName("Harry Potter"));
    }

}