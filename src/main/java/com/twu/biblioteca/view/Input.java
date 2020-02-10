package com.twu.biblioteca.view;

import java.util.Scanner;

// TODO - list down responsibilities of the INPUT class.
public class Input {

    Scanner scanner = new Scanner(System.in);

    public String readLine() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
