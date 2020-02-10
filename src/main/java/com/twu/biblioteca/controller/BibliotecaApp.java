package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.MenuItem;
import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.view.Output;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    Library library;
    Menu menu;
    Input input = new Input();
    Output output = new Output(System.out);

    final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";

    public BibliotecaApp(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;
    }

    public void startApp() {
        displayWelcomeMessage();

        while (true) {
            output.show(menu.getMenu());
            parseInput();
        }
    }

    private void parseInput(){
        int option = getOption();
        MenuItem userChoice = MenuItem.values()[Math.min((option - 1), 4)];
        userChoice.performOperation(library);
    }

    private int getOption(){
        output.show("Enter option: ");
        return Integer.parseInt(input.readLine());
    }

    public void displayWelcomeMessage() {
        output.show(welcomeMessage);
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "Rowling JK", "2001"));
        books.add(new Book("The Fault in our stars", "Green John", "2012"));
        books.add(new Book("A song of ice and fire", "Martin RR George", "1996"));

        new BibliotecaApp(new Library(books), new Menu()).startApp();
    }
}
