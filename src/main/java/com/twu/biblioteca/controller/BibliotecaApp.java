package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    Library library;
    Menu menu;


    final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";

    public BibliotecaApp(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;
    }

    public void startApp() {
        displayWelcomeMessage();

        Input input = new Input(library, menu);

        while (true) input.getInput();
    }

    public void displayWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "Rowling JK", "2001"));
        books.add(new Book("The Fault in our stars", "Green John", "2012"));
        books.add(new Book("A song of ice and fire", "Martin RR George", "1996"));

        new BibliotecaApp(new Library(books), new Menu()).startApp();
    }
}
