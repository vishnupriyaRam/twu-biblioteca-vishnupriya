package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


class InputTest {

    private InputStream originalIn;
    Library library;
    Menu menu;

    @BeforeEach
    void setUp() {
        originalIn = System.in;

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
    }

    @Test
    void shouldTestIfTheUserIsAbleToChooseAMenuOption() {
        Library library = mock(Library.class);
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, menu);

        input.getInput();

        verify(library, times(1)).view();
    }

    @Test
    void shouldTestIfTheUserCannotChooseAnInvalidOption() {
        Library library = mock(Library.class);
        String data = "6";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, menu);

        input.getInput();

        verify(library, times(0)).view();
        verify(library, times(0)).checkout(null);
        verify(library, times(0)).returnBook(null);
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
        Library library = mock(Library.class);
        String data = "1\n1\n1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, menu);

        input.getInput();

        verify(library, times(1)).view();

    }

    @Test
    void shouldTestIfTheUserIsAbleToCheckoutTheBook() {
        Library library = mock(Library.class);
        String data = "2\nHarry Potter";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, menu);

        input.getInput();

        verify(library, times(1)).checkout("Harry Potter");
    }

    @Test
    void shouldTestIfTheUserIsAbleToReturnTheBook() {
        Library library = mock(Library.class);
        String data = "3\nHarry Potter";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Input input = new Input(library, menu);

        input.getInput();

        verify(library, times(1)).returnBook("Harry Potter");
    }
}