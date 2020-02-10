package com.twu.biblioteca.model; // TODO - model package is missing

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BookTest { // TODO - can these tests execute in parallel? - Why would I want it? Faster execution.
    private PrintStream originalOut; // TODO - this is shared.
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out; // TODO - this smell exists because we are trying to mock out a global dependency, and hence have to be sure of its lifecycle. If this was parameterized, we could be more carefree.
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test // TODO - return? Test names to read as specs, will have less to zero tech words in them. "RETURN"
    void shouldReturnTheListOfBooksAvailable() {
        Book book = new Book("Harry Potter", "Rowling JK", "2001");
        String expected = "Harry Potter | Rowling JK | 2001"; // TODO - isn't the expected wrong in this case? - Incorrect spec.
        book.view();

        assertEquals(expected, outContent.toString().trim()); // TODO - why trim? But you can't change the actual? - That will hide potential bugs
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