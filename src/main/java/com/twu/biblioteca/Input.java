package com.twu.biblioteca;

import java.util.Scanner;

public class Input {
    Library library = new Library();
    Menu menu = new Menu();

    void getInput() {
        Scanner in = new Scanner(System.in);
        menu.viewMenu();
        int userOption = getMenu(in);

        if (userOption == 1) {
            library.view();
        }
    }

    private int getMenu(Scanner scanner) {
        System.out.println("Choose an option: ");
        return scanner.nextInt();
    }
}
