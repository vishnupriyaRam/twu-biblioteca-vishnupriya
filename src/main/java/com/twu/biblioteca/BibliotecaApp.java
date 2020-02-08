package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().startApp();
    }

    public void startApp() {
        displayWelcomeMessage();

        System.out.println("\nList of Books Available currently \n");

        Input input = new Input();
        input.getInput();

    }

    public void displayWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

}
