package com.twu.biblioteca;

public class BibliotecaApp {
    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public static void main(String[] args) {
        System.out.println(welcomeMessage);

        System.out.println("\nList of Books Available currently \n");
        Library library = new Library();
        System.out.println(library.getBooksAvailable());
    }
}
