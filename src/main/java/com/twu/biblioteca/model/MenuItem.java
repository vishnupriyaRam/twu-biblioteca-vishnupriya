package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.UserNotLoggedInException;
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
            try {
                output.showCheckoutBook(library.checkoutBook(bookToBeCheckedOut));
            } catch (UserNotLoggedInException e) {
                output.show("User not logged in");
                User user = attemptLogin();
                library.login(user);
            }
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
            try {
                output.showReturnBook(library.returnBook(bookToBeReturned));
            } catch (UserNotLoggedInException e) {
                output.show("User not logged in");
                User user = attemptLogin();
                library.login(user);
            }
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

    public User attemptLogin() {
        output.show("Enter library number: ");
        input.readLine();
        output.show("Enter Password");
        input.readLine();
        return new User("123-4567", "password0");
    }

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
