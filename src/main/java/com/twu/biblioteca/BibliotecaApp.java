package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().startApp();
    }

    public void startApp() {
        Library library = new Library();
        Menu menu = new Menu();
        displayWelcomeMessage();

        Input input = new Input(library, menu);

        while (true) input.getInput();
    }

    public void displayWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        System.out.println(welcomeMessage);
    }
}
