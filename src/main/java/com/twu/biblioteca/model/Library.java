package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.UserNotLoggedInException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;


public class Library {
    private List<Book> booksAvailable;
    private List<Movie> moviesAvailable;
    private List<Book> checkedOutBooks = new ArrayList<>();
    private HashMap<Book, User> checkedOut = new HashMap<>();
    private List<Movie> checkedOutMovies = new ArrayList<>();
    private List<User> users;
    private boolean isLoggedIn;
    private User currentUser;

    public Library(List<Book> booksAvailable, List<Movie> moviesAvailable, List<User> users) {
        this.booksAvailable = booksAvailable;
        this.moviesAvailable = moviesAvailable;
        this.users = users;
    }

    public String viewBooks() {
        StringJoiner list = new StringJoiner("\n");

        booksAvailable.forEach(book -> {
            if (!checkedOut.containsKey(book)) {
                list.add(book.getDetails());
            }
        });
        return list.toString();
    }

    // TODO - what are different ways to not break CSQ here?
    // TODO - is this a valid usecase to break CQS? - Think about it.
    public boolean checkoutBook(String title) throws UserNotLoggedInException {
        if (isLoggedIn) {
            Book book = getBook(title);
            if (book != null && !checkedOut.containsKey(book)) {
                checkedOut.put(book, currentUser);
                return true;
            } else
                return false;
        }
        throw new UserNotLoggedInException();
    }

    public boolean returnBook(String title) throws UserNotLoggedInException {
        if (isLoggedIn) {
            Book book = getBook(title);
            if (checkedOut.containsKey(book)) {
                checkedOut.remove(book);
                return true;
            } else
                return false;
        } else
            throw new UserNotLoggedInException();
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
            return true;
        } else
            return false;
    }

    public boolean login(User user) {
        if (users.contains(user)) {
            isLoggedIn = true;
            currentUser = user;
            return true;
        }
        isLoggedIn = false;
        currentUser = null;
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

    public String getAccountable(String title) {
        Book book = getBook(title);
        return checkedOut.get(book).getLibraryNumber();
    }
}
