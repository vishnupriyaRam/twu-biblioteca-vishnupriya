package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class LibraryTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    private Library library;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        library = new Library();
    }

    @AfterEach
    void reset() {
        System.setOut(originalOut);
    }

    @Test
    void shouldTestIfTheBookListIsViewable() {
        String firstBook = "Harry Potter | Rowling JK | 2001\n";
        String secondBook = "The Fault in our stars | Green John | 2012\n";
        String thirdBook = "A song of ice and fire | Martin RR George | 1996";
        String expected = firstBook + secondBook + thirdBook;

        library.view();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfACustomerIsAbleToCheckoutABook() {
        Library library = new Library();
        String expected = NotificationMessages.CHECKOUT_SUCCESS + "\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        library.checkOut("Harry Potter");
        library.view();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulCheckout() {
        Library library = new Library();
        String expected = String.valueOf(NotificationMessages.CHECKOUT_SUCCESS);

        library.checkOut("Harry Potter");

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedWhenTheRequestedBookIsNotAvailable() {
        Library library = new Library();
        String expected = String.valueOf(NotificationMessages.CHECKOUT_FAILURE);

        library.checkOut("Shawshank Redemption");

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheCustomerIsAbleToReturnTheBook() {
        Library library = new Library();

        String expected = NotificationMessages.CHECKOUT_SUCCESS + "\n" +
                NotificationMessages.RETURN_SUCCESS + "\n" +
                "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";
        library.checkOut("Harry Potter");

        library.returnBook("Harry Potter");
        library.view();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulReturn() {
        Library library = new Library();
        String expected = NotificationMessages.CHECKOUT_SUCCESS + "\n" + NotificationMessages.RETURN_SUCCESS;

        library.checkOut("Harry Potter");
        library.returnBook("Harry Potter");

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnUnsuccessfulReturnOfTheBook() {
        Library library = new Library();
        String expected = String.valueOf(NotificationMessages.RETURN_FAILURE);

        library.returnBook("2 States");

        assertEquals(expected, outContent.toString().trim());
    }
}