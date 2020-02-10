package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;

import java.io.PrintStream;

public class Output {
    private Menu menu;
    private Library library;
    private PrintStream out;

    public Output(Library library, Menu menu, PrintStream out) {
        this.menu = menu;
        this.library = library;
        this.out = out;
    }

    void show(String message) {
        out.println(message);
    }
}
