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
}