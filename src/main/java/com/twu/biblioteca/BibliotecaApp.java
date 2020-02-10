package com.twu.biblioteca;

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
        new BibliotecaApp(new Library(), new Menu()).startApp();
    }
}
