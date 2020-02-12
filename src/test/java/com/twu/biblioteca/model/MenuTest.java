package com.twu.biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MenuTest {

    Library library;

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
    void shouldReturnTheListOfMenuItems() {
        Library library = mock(Library.class);
        Menu menu = new Menu(library);
        String expected = "1. List available Books\n" +
                "2. List available Movies\n" +
                "3. Checkout a book\n" +
                "4. Checkout a movie\n" +
                "5. Return a book\n" +
                "6. Quit";

        assertEquals(expected, menu.getMenu());
    }

    @Test
    void shouldReturnTheLoggedInMenu() {
        Menu menu = new Menu(library);
        User user = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        String expected = "1. List available Books\n" +
                "2. List available Movies\n" +
                "3. Checkout a book\n" +
                "4. View checked out books\n" +
                "5. Checkout a movie\n" +
                "6. Return a book\n" +
                "7. Quit";

        library.login(user);

        assertEquals(expected, menu.getMenu());
    }
}