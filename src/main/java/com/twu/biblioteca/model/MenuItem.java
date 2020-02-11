package com.twu.biblioteca.model;

import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.view.Output;

public enum MenuItem implements MenuOperator {

    LIST_BOOKS("List available Books") {
        @Override
        public void performOperation(Library library) {
            output.show(library.viewBooks());
        }
    },
    LIST_MOVIES("List available Movies") {
        @Override
        public void performOperation(Library library) {
            output.show(library.viewMovies());
        }
    },
    CHECKOUT_BOOK("Checkout a book") {
        @Override
        public void performOperation(Library library) {
            output.show("Enter book to checkout: ");
            String bookToBeCheckedOut = input.readLine();
            output.showCheckout(library.checkout(bookToBeCheckedOut));
        }
    },

    CHECKOUT_MOVIE("Checkout a movie") {
        @Override
        public void performOperation(Library library) {
            output.show("Enter movie to checkout");
            String movieToBeCheckedOut = input.readLine();
            output.showCheckoutMovie(library.checkoutMovies(movieToBeCheckedOut));
        }
    },
    RETURN("Return a book") {
        @Override
        public void performOperation(Library library) {
            output.show("Enter book to be returned: ");
            String bookToBeReturned = input.readLine();
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
    Input input = new Input();
    Output output = new Output(System.out);

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
