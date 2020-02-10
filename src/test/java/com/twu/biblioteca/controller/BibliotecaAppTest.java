package com.twu.biblioteca.controller;

import com.twu.biblioteca.controller.BibliotecaApp;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotecaAppTest {

    private PrintStream originalOut;
    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        bibliotecaApp = new BibliotecaApp(new Library(), new Menu());
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    void shouldReturnWelcomeMessageToTheUser() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        bibliotecaApp.displayWelcomeMessage();

        assertEquals(expected, outContent.toString().trim());
    }
}