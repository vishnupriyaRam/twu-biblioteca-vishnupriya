package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;


class LibraryTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    private Library library;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        library = new Library();
    }

    @AfterEach
    void reset() {
        System.setOut(originalOut);
    }

    @Test
    void shouldTestIfTheBookListIsViewable() {
        String firstBook = "Harry Potter | Rowling JK | 2001\n";
        String secondBook = "The Fault in our stars | Green John | 2012\n";
        String thirdBook = "A song of ice and fire | Martin RR George | 1996";
        String expected = firstBook + secondBook + thirdBook;

        library.view();

        assertEquals(expected, outContent.toString().trim());
    }
}