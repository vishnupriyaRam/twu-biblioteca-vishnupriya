package com.twu.biblioteca.model;

import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.view.Output;

import java.util.Scanner;

public enum MenuItem implements MenuController {

    LIST_BOOKS("List available Books") {
        @Override
        public void performOperation(Library library) {
            output.show(library.view());
        }
    },
    CHECKOUT("Checkout a book") {
        @Override
        public void performOperation(Library library) {
            String bookToBeCheckedOut = input.getBook(in, "Enter book to checkout: ");
            output.showCheckout(library.checkout(bookToBeCheckedOut));
        }
    },
    RETURN("Return a book") {
        @Override
        public void performOperation(Library library) {
            String bookToBeReturned = input.getBook(in, "Enter book to be returned: ");
            output.showReturn(library.returnBook(bookToBeReturned));
        }
    },
    QUIT("Quit") {
        @Override
        public void performOperation(Library library) {
            output.show("Thanks for using the application");
            System.exit(0);
        }
    },
    INVALID("\n") {
        @Override
        public void performOperation(Library library) {
            output.show("Please select a valid option!");
        }
    };

    private String menuItem;
    Input input;
    Output output = new Output(System.out);

    Scanner in = new Scanner(System.in);

    MenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String toString() {
        return menuItem;
    }

    public String viewItem() {
        return menuItem;
    }


}
