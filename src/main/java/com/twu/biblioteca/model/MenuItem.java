package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.exceptions.UserNotLoggedInException;
import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.view.Output;

public enum MenuItem implements MenuOperator {
    LIST_BOOKS("List available Books") {
        @Override
        public void performOperation(Library library) {
            output.show(library.getBooks());
        }
    },
    LIST_MOVIES("List available Movies") {
        @Override
        public void performOperation(Library library) {
            output.show(library.getMovies());
        }
    },
    CHECKOUT_BOOK("Checkout a book") {
        @Override
        public void performOperation(Library library) throws UserNotLoggedInException {
            output.show("Enter book to checkout: ");
            String bookToBeCheckedOut = input.readLine();
            try {
                library.checkoutBook(bookToBeCheckedOut, output);
            } catch (UserNotLoggedInException e) {
                output.show("User not logged in");
                User user = attemptLogin(library);
                if (user != null) {
                    library.login(user);
                    library.checkoutBook(bookToBeCheckedOut, output);
                } else output.show("Invalid credentials");
            }
        }
    },
    VIEW_CHECKED_OUT("View checked out books") {
        @Override
        public void performOperation(Library library) {
            output.show(library.getCheckedOutBooks());
        }
    },
    CHECKOUT_MOVIE("Checkout a movie") {
        @Override
        public void performOperation(Library library) {
            output.show("Enter movie to checkout");
            String movieToBeCheckedOut = input.readLine();
            library.checkoutMovie(movieToBeCheckedOut, output);
        }
    },
    RETURN("Return a book") {
        @Override
        public void performOperation(Library library) throws UserNotLoggedInException {
            output.show("Enter book to be returned: ");
            String bookToBeReturned = input.readLine();
            try {
                library.returnBook(bookToBeReturned, output);
            } catch (UserNotLoggedInException e) {
                output.show("User not logged in");
                User user = attemptLogin(library);
                if (user != null) {
                    library.login(user);
                    library.returnBook(bookToBeReturned, output);
                } else output.show("Invalid credentials");
            }
        }
    },
    VIEW_USER_DETAILS("View user details") {
        @Override
        public void performOperation(Library library) {
            output.show(library.getUserDetails());
        }
    },
    QUIT("Quit") {
        @Override
        public void performOperation(Library library) {
            output.show("Thanks for using the application");
            System.exit(0);
        }
    },
    INVALID("") {
        @Override
        public void performOperation(Library library) {
            output.show("Please select a valid option!");
        }
    };

    User attemptLogin(Library library) {
        output.show("Enter library number: ");
        String number = input.readLine();
        output.show("Enter Password");
        String password = input.readLine();
        try {
            return library.hasUser(number, password);
        } catch (UserNotFoundException e) {
            output.show("User credentials invalid");
        }
        return null;
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
