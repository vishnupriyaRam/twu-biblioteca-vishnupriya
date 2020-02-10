package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class InputTest {

    private InputStream originalIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    Library library;
    Menu menu;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "Rowling JK", "2001"));
        books.add(new Book("The Fault in our stars", "Green John", "2012"));
        books.add(new Book("A song of ice and fire", "Martin RR George", "1996"));

        library = new Library(books);
        menu = new Menu();
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
        Input input = new Input(library, menu);
        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. Quit\n" +
                "Choose an option: \n" +
                "\n" +
                "\n" +
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
        Input input = new Input(library, menu);
        String expected = "Please select a valid option!";

        input.getInput();

        assertEquals(expected, outContent.toString().replace("1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. Quit\n" +
                "Choose an option: ", "").trim());
    }

//    @Test
//    void shouldTestIfTheUserIsAbleToQuitTheApplication() {
//        String data = "4";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        Input input = new Input(library, menu);
//        String expected = "";
//
//
//        input.getInput();
//
//        assertEquals(expected, outContent.toString().replace("1. List available Books\n" +
//                "2. Checkout a book\n" +
//                "3. Return a book\n" +
//                "4. Quit\n" +
//                "Choose an option: " + "Please select a valid option!", "").trim());
//    }

    @Test
    void shouldTestIfTheUserIsAbleToContinueUsingTheAppUntilQuitIsChosen() {
        String data = "1\n4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, menu);
        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. Quit\n" +
                "Choose an option: \n" + "\n" + "\n" +
                "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        input.getInput();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsAbleToCheckoutTheBook() {
        String data = "2\nHarry Potter";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, menu);

        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. Quit\n" +
                "Choose an option: \n" +
                "Enter book to checkout: \n" +
                "\n" +
                "Thank you! Enjoy the book";
        input.getInput();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsAbleToReturnTheBook() {
        String data = "3\nHarry Potter";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, menu);

        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. Quit\n" +
                "Choose an option: \n" +
                "Enter book to be returned: \n" +
                "\n" +
                "That is not a valid book to return.";
        input.getInput();

        assertEquals(expected, outContent.toString().trim());
    }
}