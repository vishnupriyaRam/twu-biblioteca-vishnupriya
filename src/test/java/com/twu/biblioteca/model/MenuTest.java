package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {
    @Test
    void shouldReturnTheListOfMenuItems() {
        Menu menu = new Menu();
        String expected = "1. List available Books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. Quit";

        assertEquals(expected, menu.getMenu());
    }
}