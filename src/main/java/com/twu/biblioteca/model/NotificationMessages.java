package com.twu.biblioteca.model;

public enum NotificationMessages {
    CHECKOUT_SUCCESS("\nThank you! Enjoy the book\n"),
    CHECKOUT_FAILURE("\nSorry, that book is not available\n"),
    RETURN_SUCCESS("\nThank you for returning the book\n"),
    RETURN_FAILURE("\nThat is not a valid book to return.\n");

    String message;

    NotificationMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
