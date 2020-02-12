package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MenuTest {
    @Test
    void shouldReturnTheListOfMenuItems() {
        Library library = mock(Library.class);
        Menu menu = new Menu(library);
        String expected = "1. List available Books\n" +
                "2. List available Movies\n" +
                "3. Checkout a book\n" +
                "4. View checked out books\n" +
                "5. Checkout a movie\n" +
                "6. Return a book\n" +
                "7. Quit";

        assertEquals(expected, menu.getMenu());
    }
}