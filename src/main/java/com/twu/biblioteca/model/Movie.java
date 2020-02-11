package com.twu.biblioteca.model;

public class Movie {
    private final String title;
    private final String year;
    private final String director;
    private final String rating;

    public Movie(String title, String year, String director, String rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getDetails() {
        String separator = " | ";
        return title + separator + year + separator + director + separator + rating;
    }

    public boolean hasSameName(String title) {
        return this.title.equals(title);
    }
}
