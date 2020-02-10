package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;

import java.util.Scanner;

public class Input {
    Library library;
    Menu menu;

    public Input(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;

    }

    public void getInput() {
        Scanner in = new Scanner(System.in);
        menu.viewMenu();
        String userOption = getMenu(in);
        int option = Integer.parseInt(userOption);

        switch (option) {
            case 1:
                view();
                break;
            case 2:
                checkout(in);
                break;
            case 3:
                returnBook(in);
                break;
            case 4:
                quit();
                break;
            default:
                invalid();
                break;
        }
    }

    private String getMenu(Scanner scanner) {
        System.out.println("Choose an option: ");
        return scanner.nextLine();
    }

    private String getBook(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private void view() {
        System.out.println("\n");
        library.view();
        System.out.println("\n");
    }

    private void checkout(Scanner in) {
        String bookToBeCheckedOut = getBook(in, "Enter book to checkout: ");
        library.checkOut(bookToBeCheckedOut);
    }

    private void returnBook(Scanner in) {
        String bookToBeReturned = getBook(in, "Enter book to be returned: ");
        library.returnBook(bookToBeReturned);
    }

    private void quit() {
        System.out.println("Thanks for using the application");
        System.exit(0);
    }

    private void invalid(){
        System.out.println("Please select a valid option!");
    }
}
