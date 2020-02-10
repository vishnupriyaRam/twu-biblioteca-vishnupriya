package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void reset() {
        System.setOut(originalOut);
    }

    @Test
    void shouldReturnTheListOfMenuItems() {
        Menu menu = new Menu();
        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. Quit";

        assertEquals(expected, menu.viewMenu());
    }
}