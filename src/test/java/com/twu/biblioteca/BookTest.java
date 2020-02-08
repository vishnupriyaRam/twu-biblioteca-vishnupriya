package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    void shouldReturnTheListOfBooksAvailable() {
        Book book = new Book("Harry Potter", "Rowling JK", "2001");
        String expected = "Harry Potter | Rowling JK | 2001";
        book.viewBookInfo();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTwoBooksAreSame() {
        Book book1 = new Book("Harry Potter", "Rowling JK", "2001");
        Book book2 = new Book("Harry Potter", "Rowling JK", "2001");

        assertEquals(book1, book2);
    }

    @Test
    void shouldTestIfTheBookIsSameAsAnotherBookWithSameTitle() {
        Book book1 = new Book("Harry Potter", "Rowling JK", "2001");
        Book book2 = new Book("Harry Potter");

        assertEquals(book1, book2);
    }
}