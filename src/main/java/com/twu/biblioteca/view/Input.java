package com.twu.biblioteca.view;

import java.util.Scanner;

//TODO: need to find a way to test this
public class Input {

    Scanner scanner = new Scanner(System.in);

    public String readLine() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
