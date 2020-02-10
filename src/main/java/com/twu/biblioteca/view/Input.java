package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.MenuItem;

import java.util.Scanner;

// TODO - list down responsibilities of the INPUT class.
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
        MenuItem userChoice = MenuItem.values()[option - 1];

        switch (userChoice) {
            case LIST_BOOKS:
                view();
                break;
            case CHECKOUT:
                checkout(in);
                break;
            case RETURN:
                returnBook(in);
                break;
            case QUIT:
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
        System.out.println(library.view());
    }

    private void checkout(Scanner in) {
        String bookToBeCheckedOut = getBook(in, "Enter book to checkout: ");
        System.out.println(library.checkout(bookToBeCheckedOut).getMessage());
    }

    private void returnBook(Scanner in) {
        String bookToBeReturned = getBook(in, "Enter book to be returned: ");
        System.out.println(library.returnBook(bookToBeReturned).getMessage());
    }

    private void quit() {
        System.out.println("Thanks for using the application");
        System.exit(0);
    }

    private void invalid() {
        System.out.println("Please select a valid option!");
    }
}
