package com.twu.biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "Rowling JK", "2001"));
        books.add(new Book("The Fault in our stars", "Green John", "2012"));
        books.add(new Book("A song of ice and fire", "Martin RR George", "1996"));
        library = new Library(books);
    }

    @Test
    void shouldTestIfTheBookListIsDisplayed() {
        String expected = "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        assertEquals(expected, library.view());
    }

    @Test
    void shouldTestIfACheckedOutBookIsNotViewableInTheListOfAvailableBooks() {
        String expected = "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        library.checkout("Harry Potter");

        assertEquals(expected, library.view());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulCheckout() {
        String expected = "Thank you! Enjoy the book";

        assertEquals(expected, library.checkout("Harry Potter").getMessage());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedWhenTheRequestedBookIsNotAvailable() {
        String expected = "Sorry, that book is not available";

        assertEquals(expected, library.checkout("Shawshank Redemption").getMessage());
    }

    @Test
    void shouldTestIfTheReturnedBookAppearsInTheListOfAvailableBooks() {
        String expected = "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";
        library.checkout("Harry Potter");

        library.returnBook("Harry Potter");

        assertEquals(expected, library.view());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulReturn() {
        String expected = "Thank you for returning the book";

        library.checkout("Harry Potter");

        assertEquals(expected, library.returnBook("Harry Potter").getMessage());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnUnsuccessfulReturnOfTheBook() {
        String expected = "That is not a valid book to return.";

        assertEquals(expected, library.returnBook("2 States").getMessage());
    }
}