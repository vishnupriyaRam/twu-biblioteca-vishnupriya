package com.twu.biblioteca.view;

import com.twu.biblioteca.model.NotificationMessages;

import java.io.PrintStream;

import static com.twu.biblioteca.model.NotificationMessages.*;

// TODO : Output
public class Output {
    private PrintStream out;

    public Output(PrintStream out) {
        this.out = out;
    }

    public void show(String message) {
        out.println(message);
    }

    public void showCheckoutBook(boolean status) {
        if (status)
            out.println(CHECKOUT_SUCCESS.getMessage());
        else
            out.println(CHECKOUT_FAILURE.getMessage());

    }

    public void showReturnBook(boolean status) {
        if (status)
            out.println(RETURN_SUCCESS.getMessage());
        else
            out.println(RETURN_FAILURE.getMessage());
    }

    public void showCheckoutMovie(boolean status) {
        if (status)
            out.println(CHECKOUT_SUCCESS_MOVIE.getMessage());
        else
            out.println(CHECKOUT_FAILURE_MOVIE.getMessage());
    }
}
