package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class Library {
    private List<Book> booksAvailable;
    private List<Movie> moviesAvailable;
    private List<Book> checkedOutBooks = new ArrayList<>();
    private List<Movie> checkedOutMovies = new ArrayList<>();


    public Library(List<Book> booksAvailable, List<Movie> moviesAvailable) {
        this.booksAvailable = booksAvailable;
        this.moviesAvailable = moviesAvailable;
    }

    public String viewBooks() {
        StringJoiner list = new StringJoiner("\n");

        booksAvailable.forEach(book -> {
            if (!checkedOutBooks.contains(book)) {
                list.add(book.getDetails());
            }
        });
        return list.toString();
    }

    // TODO - what are different ways to not break CSQ here?
    // TODO - is this a valid usecase to break CQS? - Think about it.
    public boolean checkout(String title) {
        Book book = getBook(title);
        if (book != null && !checkedOutBooks.contains(book)) {
            checkedOutBooks.add(book);
            return true;
        } else
            return false;
    }

    public boolean returnBook(String title) {
        Book book = getBook(title);
        if (checkedOutBooks.contains(book)) {
            checkedOutBooks.remove(book);
            return true;
        }
        return false;
    }

    public String viewMovies() {
        StringJoiner list = new StringJoiner("\n");

        moviesAvailable.forEach(movie -> {
                    if (!checkedOutMovies.contains(movie))
                        list.add(movie.getDetails());
                }
        );
        return list.toString();
    }

    public boolean checkoutMovies(String title) {
        Movie movie = getMovie(title);
        if (movie != null && !checkedOutMovies.contains(movie)) {
            checkedOutMovies.add(movie);
            System.out.println("Hereeee");
            return true;
        }
        return false;
    }

    private Book getBook(String title) { // TODO - its private, so its still okay....
        for (Book book : booksAvailable) {
            if (book.hasSameName(title))
                return book;
        }
        return null; // TODO - don't return nulls? so what's the problem with nulls?
    }

    private Movie getMovie(String title) {
        for (Movie movie : moviesAvailable) {
            if (movie.hasSameName(title))
                return movie;
        }
        return null;
    }


}
