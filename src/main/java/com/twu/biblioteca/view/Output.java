package com.twu.biblioteca.view;

import com.twu.biblioteca.model.NotificationMessages;

import java.io.PrintStream;

public class Output {
    private PrintStream out;

    public Output(PrintStream out) {
        this.out = out;
    }

    public void show(String message) {
        out.println(message);
    }

    public void showCheckout(boolean status) {
        if (status)
            out.println(NotificationMessages.CHECKOUT_SUCCESS.getMessage());
        else
            out.println(NotificationMessages.CHECKOUT_FAILURE.getMessage());
    }

    public void showReturn(boolean status) {
        if (status)
            out.println(NotificationMessages.RETURN_SUCCESS.getMessage());
        else
            out.println(NotificationMessages.RETURN_FAILURE.getMessage());
    }
}
