package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotecaAppTest {

    private PrintStream originalOut;
    private BibliotecaApp bibliotecaApp;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "Rowling JK", "2001"));
        books.add(new Book("The Fault in our stars", "Green John", "2012"));
        books.add(new Book("A song of ice and fire", "Martin RR George", "1996"));

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Forrest Gump", "1994", "Robert Zemeckis", "8.8"));
        movies.add(new Movie("Seven", "1995", "David Fincher", "8.6"));
        movies.add(new Movie("The Shawshank Redemption", "1994", "Frank Darabont", "9.3"));

        List<User> users = new ArrayList<>();
        users.add(new User("123-4567", "password0"));
        users.add(new User("123-4568", "password1"));
        users.add(new User("123-4569", "password2"));
        bibliotecaApp = new BibliotecaApp(new Library(books, movies, users), new Menu());
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