package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {
    @Test
    void shouldReturnTheListOfMenuItems() {
        Menu menu = new Menu();
        String expected = "1. List available Books\n" +
                "2. List available Movies\n" +
                "3. Checkout a book\n" +
                "4. Checkout a movie\n" +
                "5. Return a book\n" +
                "6. Quit";

        assertEquals(expected, menu.getMenu());
    }
}