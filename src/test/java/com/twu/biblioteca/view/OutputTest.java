package com.twu.biblioteca.view;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OutputTest {

    @Test
    void shouldDisplayAMessage() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Output output = new Output(mockPrintStream);
        String message = "test message";
        String expectedMessage = "test message";

        output.show(message);

        verify(mockPrintStream).println(expectedMessage);
    }

    @Test
    void shouldDisplayASuccessMessageForReturnedBook() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Output output = new Output(mockPrintStream);
        String expectedMessage = "Thank you for returning the book";

        output.showReturnBook(true);

        verify(mockPrintStream).println(expectedMessage);
    }

    @Test
    void shouldDisplayAFailureMessageForReturnedBook() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Output output = new Output(mockPrintStream);
        String expectedMessage = "That is not a valid book to return.";

        output.showReturnBook(false);

        verify(mockPrintStream).println(expectedMessage);
    }
}