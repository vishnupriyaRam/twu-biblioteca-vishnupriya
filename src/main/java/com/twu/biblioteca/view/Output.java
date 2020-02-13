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
}
