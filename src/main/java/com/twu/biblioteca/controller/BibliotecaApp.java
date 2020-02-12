package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.exceptions.UserNotLoggedInException;
import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.Input;
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

    public void startApp() throws UserNotLoggedInException, UserNotFoundException {
        displayWelcomeMessage();

        while (true) {
            output.show(menu.getMenu());
            parseInput();
        }
    }

    public void displayWelcomeMessage() {
        output.show(welcomeMessage);
    }

    public static void main(String[] args) throws UserNotLoggedInException, UserNotFoundException {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "Rowling JK", "2001"));
        books.add(new Book("The Fault in our stars", "Green John", "2012"));
        books.add(new Book("A song of ice and fire", "Martin RR George", "1996"));

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Forrest Gump", "1994", "Robert Zemeckis", "8.8"));
        movies.add(new Movie("Seven", "1995", "David Fincher", "8.6"));
        movies.add(new Movie("The Shawshank Redemption", "1994", "Frank Darabont", "9.3"));

        List<User> users = new ArrayList<>();
        users.add(new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898"));
        users.add(new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989"));
        users.add(new User("123-4569", "password2", "Golding", "golding@gmail.com", "7878787878"));

        Library library = new Library(books, movies, users);
        new BibliotecaApp(library, new Menu(library)).startApp();
    }

    private void parseInput() throws UserNotLoggedInException, UserNotFoundException {
        int option = getOption();
        MenuItem userChoice = MenuItem.values()[Math.min((option - 1), 7)];
        userChoice.performOperation(library);
    }

    private int getOption() {
        output.show("Enter option: ");
        return Integer.parseInt(input.readLine());
    }
}
