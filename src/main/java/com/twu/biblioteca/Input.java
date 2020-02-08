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
                System.out.println("\n");
                library.view();
                System.out.println("\n");
                break;
            case 2:
                String userInput = getBook(in, "Enter book to checkout: ");
                library.checkOut(userInput);
                break;
            case 3:
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

    private String getBook(Scanner scanner, String message) {
        System.out.println(message);
        scanner.nextLine();
        return scanner.nextLine();
    }
}
