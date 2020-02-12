package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.UserNotLoggedInException;
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

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Forrest Gump", "1994", "Robert Zemeckis", "8.8"));
        movies.add(new Movie("Seven", "1995", "David Fincher", "8.6"));
        movies.add(new Movie("The Shawshank Redemption", "1994", "Frank Darabont", "9.3"));

        List<User> users = new ArrayList<>();
        users.add(new User("123-4567", "password0"));
        users.add(new User("123-4568", "password1"));
        users.add(new User("123-4569", "password2"));
        library = new Library(books, movies, users);
    }

    @Test
    void shouldTestIfTheBookListIsDisplayed() {
        String expected = "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        assertEquals(expected, library.viewBooks());
    }

    @Test
    void shouldTestIfACheckedOutBookIsNotViewableInTheListOfAvailableBooks() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0");
        library.login(user);
        String expected = "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        library.checkoutBook("Harry Potter");

        assertEquals(expected, library.viewBooks());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulCheckout() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0");
        library.login(user);
        assertTrue(library.checkoutBook("Harry Potter"));
    }

    @Test
    void shouldTestIfTheUserIsNotifiedWhenTheRequestedBookIsNotAvailable() throws UserNotLoggedInException {
//        String expected = "Sorry, that book is not available";

//        assertEquals(expected, library.checkout("Shawshank Redemption").getMessage());
        User user = new User("123-4567", "password0");
        library.login(user);
        assertFalse(library.checkoutBook("Shawshank Redemption"));
    }

    @Test
    void shouldTestIfTheReturnedBookAppearsInTheListOfAvailableBooks() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0");
        library.login(user);
        String expected = "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";
        library.checkoutBook("Harry Potter");

        library.returnBook("Harry Potter");

        assertEquals(expected, library.viewBooks());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulReturn() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0");
        library.login(user);

        library.checkoutBook("Harry Potter");

        assertTrue(library.returnBook("Harry Potter"));
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnUnsuccessfulReturnOfTheBook() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0");
        library.login(user);

        assertFalse(library.checkoutBook("Shawshank Redemption"));
    }

    @Test
    void shouldTestIfACheckedOutBookCannotBeCheckedOutAgain() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0");
        library.login(user);

        library.checkoutBook("Harry Potter");

        assertFalse(library.checkoutBook("Harry Potter"));
    }

    @Test
    void shouldTestIfTheMovieListIsDisplayed() {
        String expected = "Forrest Gump | 1994 | Robert Zemeckis | 8.8\n" +
                "Seven | 1995 | David Fincher | 8.6\n" +
                "The Shawshank Redemption | 1994 | Frank Darabont | 9.3";

        assertEquals(expected, library.viewMovies());
    }

    @Test
    void shouldTestIfTheCheckedOutMovieIsNotViewableInTheListOfAvailableMovies() {
        String expected = "Forrest Gump | 1994 | Robert Zemeckis | 8.8\n" +
                "The Shawshank Redemption | 1994 | Frank Darabont | 9.3";

        library.checkoutMovies("Seven");

        assertEquals(expected, library.viewMovies());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulCheckoutOfAMovie() {
        assertTrue(library.checkoutMovies("Seven"));
    }

    @Test
    void shouldTestIfTheUserIsNotifiedWhenTheRequestedMovieIsNotAvailable() {
        assertFalse(library.checkoutMovies("Harry Potter"));
    }

    @Test
    void shouldTestIfTheUserCanLogin() {
        User user = new User("123-4567", "password0");
        assertTrue(library.login(user));
    }

    @Test
    void shouldTestIfTheUserCannotLoginIfTheUserIsNotAMember() {
        User user = new User("145-4567", "password");
        assertFalse(library.login(user));
    }

    @Test
    void shouldTestIfTheUserIsAbleToLoginOnlyWithTheCorrectCredentials() {
        User user = new User("123-4567", "password2121");
        assertFalse(library.login(user));
    }

    @Test
    void shouldTestIfTheUserCanCheckoutTheBookOnlyAfterLoggingIn() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0");
        library.login(user);
        assertTrue(library.checkoutBook("Harry Potter"));
    }

    @Test
    void shouldTestIfTheUserDetailsAreAddedWhenABookIsCheckedOut() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0");
        library.login(user);
        library.checkoutBook("Harry Potter");
        String expected = "123-4567";
        assertEquals(expected, library.getAccountable("Harry Potter"));
    }

    @Test
    void shouldTestIfTheUserCannotReturnABookWithoutLoggingIn() throws UserNotLoggedInException {
        assertThrows(UserNotLoggedInException.class, () -> library.returnBook("Harry Potter"));
    }

    @Test
    void shouldTestIfUserNotLoggedInExceptionIsThrownIfTheUserIsNotLoggedIn() {
        assertThrows(UserNotLoggedInException.class, () -> library.checkoutBook("Harry Potter"));
    }
}