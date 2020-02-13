package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.exceptions.UserNotLoggedInException;
import com.twu.biblioteca.view.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


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
        users.add(new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898"));
        users.add(new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989"));
        users.add(new User("123-4569", "password2", "Golding", "golding@gmail.com", "7878787878"));
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
        User user = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        library.login(user);
        String expected = "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";

        library.checkoutBook("Harry Potter", mock(Output.class));

        assertEquals(expected, library.viewBooks());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulCheckout() throws UserNotLoggedInException {
        Output output = mock(Output.class);
        User user = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        library.login(user);
        library.checkoutBook("Harry Potter", output);

        verify(output).show("Thank you! Enjoy the book");

    }

    @Test
    void shouldTestIfTheUserIsNotifiedWhenTheRequestedBookIsNotAvailable() throws UserNotLoggedInException {
        Output output = mock(Output.class);
        User user = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        library.login(user);

        library.checkoutBook("Shawshank Redemption", output);

        verify(output).show("Sorry, that book is not available");
    }

    @Test
    void shouldTestIfTheReturnedBookAppearsInTheListOfAvailableBooks() throws UserNotLoggedInException {
        Output output = mock(Output.class);
        User user = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        library.login(user);
        String expected = "Harry Potter | Rowling JK | 2001\n" +
                "The Fault in our stars | Green John | 2012\n" +
                "A song of ice and fire | Martin RR George | 1996";
        library.checkoutBook("Harry Potter", mock(Output.class));

        library.returnBook("Harry Potter", output);

        assertEquals(expected, library.viewBooks());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulReturn() throws UserNotLoggedInException {
        Output output = mock(Output.class);
        User user = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        library.login(user);

        library.checkoutBook("Harry Potter", output);
        library.returnBook("Harry Potter", output);

        verify(output).show("Thank you for returning the book");
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnUnsuccessfulCheckoutOfTheBook() throws UserNotLoggedInException {
        Output output = mock(Output.class);
        User user = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        library.login(user);

        library.checkoutBook("Shawshank Redemption", output);

        verify(output).show("Sorry, that book is not available");
    }

    @Test
    void shouldTestIfACheckedOutBookCannotBeCheckedOutAgain() throws UserNotLoggedInException {
        Output output = mock(Output.class);
        User user = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        library.login(user);

        library.checkoutBook("Harry Potter", output);

        library.checkoutBook("Harry Potter", output);

        verify(output).show("Sorry, that book is not available");

    }

    @Test
    void shouldTestIfTheMovieListIsDisplayed() {
        String expected = "Forrest Gump | 1994 | Robert Zemeckis | 8.8\n" +
                "Seven | 1995 | David Fincher | 8.6\n" +
                "The Shawshank Redemption | 1994 | Frank Darabont | 9.3";

        assertEquals(expected, library.getMovies());
    }

    @Test
    void shouldTestIfTheCheckedOutMovieIsNotViewableInTheListOfAvailableMovies() {
        String expected = "Forrest Gump | 1994 | Robert Zemeckis | 8.8\n" +
                "The Shawshank Redemption | 1994 | Frank Darabont | 9.3";

        library.checkoutMovie("Seven", mock(Output.class));

        assertEquals(expected, library.getMovies());
    }

    @Test
    void shouldTestIfTheUserIsNotifiedOnSuccessfulCheckoutOfAMovie() {
        Output output = mock(Output.class);

        library.checkoutMovie("Seven", output);

        verify(output).show("Thank you! Enjoy the movie");
    }

    @Test
    void shouldTestIfTheUserIsNotifiedWhenTheRequestedMovieIsNotAvailable() {
        Output output = mock(Output.class);

        library.checkoutMovie("test", output);

        verify(output).show("Sorry, that movie is not available");
    }

    @Test
    void shouldTestIfTheUserCanLogin() {
        User user = new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898");
        assertTrue(library.login(user));
    }

    @Test
    void shouldTestIfTheUserCannotLoginIfTheUserIsNotAMember() {
        User user = new User("123-4567", "password", "Henry", "henry@gmail.com", "9898989898");
        assertFalse(library.login(user));
    }

    @Test
    void shouldTestIfTheUserIsAbleToLoginOnlyWithTheCorrectCredentials() {
        User user = new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898");
        assertTrue(library.login(user));
    }

    @Test
    void shouldTestIfTheUserCanCheckoutTheBookOnlyAfterLoggingIn() throws UserNotLoggedInException {
        Output output = mock(Output.class);
        User user = new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898");
        library.login(user);

        library.checkoutBook("Harry Potter", output);

        verify(output).show("Thank you! Enjoy the book");
    }

    @Test
    void shouldTestIfTheUserDetailsAreAddedWhenABookIsCheckedOut() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898");
        library.login(user);
        library.checkoutBook("Harry Potter", mock(Output.class));
        String expected = "123-4567";

        assertEquals(expected, library.getAccountable("Harry Potter"));
    }

    @Test
    void shouldTestIfTheUserCannotReturnABookWithoutLoggingIn() {
        Output output = mock(Output.class);
        assertThrows(UserNotLoggedInException.class, () -> library.returnBook("Harry Potter", output));
    }

    @Test
    void shouldTestIfUserNotLoggedInExceptionIsThrownIfTheUserIsNotLoggedIn() {
        assertThrows(UserNotLoggedInException.class, () -> library.checkoutBook("Harry Potter", mock(Output.class)));
    }

    @Test
    void shouldTestIfUserIsAbleToViewCheckedOutBooks() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898");
        library.login(user);
        library.checkoutBook("Harry Potter", mock(Output.class));
        String expected = "Harry Potter | Rowling JK | 2001";

        assertEquals(expected, library.getCheckedOutBooks());
    }

    @Test
    void shouldTestIfTheUserIsAbleToViewOnlyTheBooksCheckedOutByThem() throws UserNotLoggedInException {
        User user = new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898");
        library.login(user);
        library.checkoutBook("Harry Potter", mock(Output.class));
        User user2 = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        library.login(user2);
        library.checkoutBook("A song of ice and fire", mock(Output.class));
        String expected = "A song of ice and fire | Martin RR George | 1996";

        assertEquals(expected, library.getCheckedOutBooks());
    }

    @Test
    void shouldTestIfAUserHasTheGivenNameAndPassword() throws UserNotFoundException {
        User user = new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898");
        User newUser = library.hasUser("123-4567", "password0");
        assertEquals(user, newUser);
    }

    @Test
    void shouldTestIfTheUserDetailsAreDisplayed() {
        User user = new User("123-4567", "password0", "Henry", "henry@gmail.com", "9898989898");
        String expected = "Henry\nhenry@gmail.com\n9898989898";

        assertEquals(expected, user.getDetails());
    }
}