package com.twu.biblioteca.view;

import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    public String readLine() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
