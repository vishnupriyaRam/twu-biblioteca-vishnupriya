package com.twu.biblioteca.model;

public enum NotificationMessages {
    CHECKOUT_SUCCESS("Thank you! Enjoy the book"),
    CHECKOUT_FAILURE("Sorry, that book is not available"),
    RETURN_SUCCESS("Thank you for returning the book"),
    RETURN_FAILURE("That is not a valid book to return.");

    String message;

    NotificationMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
