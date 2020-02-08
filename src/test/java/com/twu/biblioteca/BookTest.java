package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldTestIfTwoBooksAreSame() {
        Book book1 = new Book("Harry Potter", "Rowling JK", "2001");
        Book book2 = new Book("Harry Potter", "Rowling JK", "2001");

        assertEquals(book1, book2);
    }

    @Test
    void shouldReturnTheTitleOfTheBook() {
        Book book = new Book("Harry Potter", "Rowling JK", "2001");
        String expected = "Harry Potter | Rowling JK | 2001";
        assertEquals(expected, book.toString());
    }
}