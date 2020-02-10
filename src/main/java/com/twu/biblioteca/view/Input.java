package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.MenuItem;

import java.util.Scanner;

// TODO - list down responsibilities of the INPUT class.
public class Input {
    Library library;
    Menu menu;

    public Input(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;
    }

    public void getInput() {
        Scanner in = new Scanner(System.in);
        System.out.println(menu.getMenu());
        String userOption = getMenu(in);
        int option = Integer.parseInt(userOption);
        MenuItem userChoice = MenuItem.values()[Math.min((option - 1), 4)];

        userChoice.performOperation(library);
    }

    private String getMenu(Scanner scanner) {
        System.out.println("Choose an option: ");
        return scanner.nextLine();
    }

    private String getBook(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
