package com.twu.biblioteca;

import java.util.Scanner;

public class Input {
    Library library = new Library();
    Menu menu = new Menu();

    void getInput() {
        Scanner in = new Scanner(System.in);
        menu.viewMenu();
        int userOption = getMenu(in);

        switch (userOption) {
            case 1:
                System.out.println("\nList of Books Available currently \n");
                library.view();
                break;
            case 2:
                System.out.println("Thanks for using the application");
                System.exit(0);
                break;
            default:
                System.out.println("Please select a valid option!");
                break;
        }
    }

    private int getMenu(Scanner scanner) {
        System.out.println("Choose an option: ");
        return scanner.nextInt();
    }
}
