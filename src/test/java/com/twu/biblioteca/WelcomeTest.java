package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WelcomeTest {
    @Test
    public void shouldReturnWelcomeMessageToTheUser() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(expected, Welcome.getWelcomeMessage());
    }
}