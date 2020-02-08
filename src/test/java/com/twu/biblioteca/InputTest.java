package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class InputTest {

    private InputStream originalIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void shouldTestIfTheUserIsAbleToChooseAMenuOption() {
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input();
        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Quit\n" +
                "Choose an option: \n" + "\n" + "\n" +
                "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        input.getInput();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserCannotChooseAnInvalidOption() {
        String data = "6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input();
        String expected = "Please select a valid option!";

        input.getInput();

        assertEquals(expected, outContent.toString().replace("1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Quit\n" +
                "Choose an option: ", "").trim());
    }

    @Test
    void shouldTestIfTheUserIsAbleToQuitTheApplication() {
        String data = "3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input();
        String expected = "";

        input.getInput();

        assertEquals(expected, outContent.toString().replace("1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Quit\n" +
                "Choose an option: " + "Please select a valid option!", "").trim());
    }

    @Test
    void shouldTestIfTheUserIsAbleToContinueUsingTheAppUntilQuitIsChosen() {
        String data = "1\n3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input();
        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Quit\n" +
                "Choose an option: \n" + "\n" + "\n" +
                "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        input.getInput();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsAbleToCheckoutTheBook() {
        String data = "2\nHarry Potter\n1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input();

        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Quit\n" +
                "Choose an option: \n" +
                "Enter book to checkout:";
        input.getInput();

        assertEquals(expected, outContent.toString().trim());
    }
}