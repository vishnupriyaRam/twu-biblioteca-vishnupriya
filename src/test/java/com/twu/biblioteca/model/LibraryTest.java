package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Library;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class LibraryTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;
    private Library library; // TODO - again be careful at using the common stateful variables / fields - because then it'll become hard to parallelize

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
    void shouldTestIfTheBookListIsViewable() { // TODO - is viewable. spec name. shouldTest? - I'll suggest in your free time, go explore how people have been writing / naming their tests. - You'll also make new friends (who might think you're weird) or you can go to github too.
        String firstBook = "Harry Potter | Rowling JK | 2001\n";
        String secondBook = "The Fault in our stars | Green John | 2012\n";
        String thirdBook = "A song of ice and fire | Martin RR George | 1996";
        String expected = firstBook + secondBook + thirdBook;

        library.view();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfACustomerIsAbleToCheckoutABook() { // TODO - naming like a spec
        Library library = new Library();
        String expected = "Thank you! Enjoy the book\n" + "\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        library.checkout("Harry Potter");
        library.view();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulCheckout() {
        Library library = new Library();
        String expected = "Thank you! Enjoy the book";

        library.checkout("Harry Potter"); // TODO - you could probably use nesting to differentiate the scenarios?

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedWhenTheRequestedBookIsNotAvailable() {
        Library library = new Library();
        String expected = "Sorry, that book is not available";

        library.checkout("Shawshank Redemption");

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheCustomerIsAbleToReturnTheBook() {
        Library library = new Library();

        String expected = "Thank you! Enjoy the book\n" + "\n" + "\n" +
                "Thank you for returning the book\n" + "\n" +
                "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";
        library.checkout("Harry Potter");

        library.returnBook("Harry Potter");
        library.view();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulReturn() {
        Library library = new Library();
        String expected = "Thank you! Enjoy the book\n" + "\n" + "\n" + "Thank you for returning the book";

        library.checkout("Harry Potter");
        library.returnBook("Harry Potter");

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnUnsuccessfulReturnOfTheBook() {
        Library library = new Library();
        String expected = "That is not a valid book to return.";

        library.returnBook("2 States");

        assertEquals(expected, outContent.toString().trim());
    }
}