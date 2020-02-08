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
        } else if (userOption == 2) {
            System.out.println("Thanks for using the application");
            return;
        } else {
            System.out.println("Please select a valid option!");
        }
    }

    private int getMenu(Scanner scanner) {
        System.out.println("Choose an option: ");
        return scanner.nextInt();
    }
}
