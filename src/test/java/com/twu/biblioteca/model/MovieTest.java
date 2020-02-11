package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void shouldTestIfTheMovieDetailsAreViewable() {
        Movie movie = new Movie("Forrest Gump", "1994", "Robert Zemeckis", "8.8");
        String expected = "Forrest Gump | 1994 | Robert Zemeckis | 8.8";

        assertEquals(expected, movie.getDetails());
    }

    @Test
    void shouldTestIfTheMovieCanBeFetchedUsingTheTitle() {
        Movie movie = new Movie("Forrest Gump", "1994", "Robert Zemeckis", "8.8");

        assertTrue(movie.hasSameName("Forrest Gump"));
    }
}