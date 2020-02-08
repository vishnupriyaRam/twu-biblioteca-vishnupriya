package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaAppTest {

    private PrintStream originalOut;
    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outContent;
    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        bibliotecaApp = new BibliotecaApp();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        originalIn = System.in;
        System.setIn(new ByteArrayInputStream("1\n3".getBytes()));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void shouldReturnWelcomeMessageToTheUser() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        bibliotecaApp.displayWelcomeMessage();

        assertEquals(expected, outContent.toString().trim());
    }
}