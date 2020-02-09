package com.twu.biblioteca;

import java.util.Scanner;

public class Input {
    Library library;
    Menu menu;

    public Input(Library library, Menu menu) {
        this.library = library;
        this.menu = menu;

    }

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
                String bookToBeCheckedOut = getBook(in, "Enter book to checkout: ");
                library.checkOut(bookToBeCheckedOut);
                break;
            case 3:
                String bookToBeReturned = getBook(in, "Enter book to be returned: ");
                library.returnBook(bookToBeReturned);
                break;
            case 4:
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
