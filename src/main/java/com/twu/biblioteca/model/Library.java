package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.exceptions.UserNotLoggedInException;
import com.twu.biblioteca.view.Output;

import java.util.*;
import java.util.stream.Collectors;

import static com.twu.biblioteca.model.NotificationMessages.*;

public class Library {
    private List<Book> booksAvailable;
    private List<Movie> moviesAvailable;
    private Map<Book, User> checkedOut = new HashMap<>();
    private List<Movie> checkedOutMovies = new ArrayList<>();
    private List<User> users;
    private boolean isLoggedIn;
    private User currentUser;
    private LoginListener loginListener;

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

    public void checkoutBook(String title, Output output) throws UserNotLoggedInException {
        if (!isLoggedIn)
            throw new UserNotLoggedInException();

        Book book = getBook(title);
        if (book != null && !checkedOut.containsKey(book)) {
            checkedOut.put(book, currentUser);
            output.show(CHECKOUT_SUCCESS.getMessage());
        } else {
            output.show(CHECKOUT_FAILURE.getMessage());
        }
    }

    public String viewCheckedOutBooks() {
        return checkedOut.entrySet()
                .stream().filter(bookUserEntry -> bookUserEntry.getValue().isEquals(currentUser))
                .map(bookUserEntry -> bookUserEntry.getKey().getDetails())
                .collect(Collectors.joining("\n"));
    }

    public void returnBook(String title, Output output) throws UserNotLoggedInException {
        if (!isLoggedIn)
            throw new UserNotLoggedInException();

        Book book = getBook(title);
        if (checkedOut.containsKey(book)) {
            checkedOut.remove(book);
            output.show(RETURN_SUCCESS.getMessage());
        } else
            output.show(RETURN_FAILURE.getMessage());
    }

    public String getMovies() {
        return moviesAvailable
                .stream()
                .filter(movie -> !checkedOutMovies.contains(movie))
                .map(Movie::getDetails)
                .collect(Collectors.joining("\n"));
    }

    public void checkoutMovies(String title, Output output) {
        Movie movie = getMovie(title);
        if (movie != null && !checkedOutMovies.contains(movie)) {
            checkedOutMovies.add(movie);
            output.show(CHECKOUT_SUCCESS_MOVIE.getMessage());
        } else
            output.show(CHECKOUT_FAILURE_MOVIE.getMessage());
    }

    public boolean login(User user) {
        if (users.contains(user)) {
            isLoggedIn = true;
            currentUser = user;
            if (loginListener != null) loginListener.loginEvent(user);
            return true;
        }
        isLoggedIn = false;
        currentUser = null;
        return false;
    }

    public String getAccountable(String title) {
        Book book = getBook(title);
        return checkedOut.get(book).getLibraryNumber();
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public User hasUser(String number, String password) throws UserNotFoundException {
        for (User user : users) {
            if (user.isValid(number, password))
                return user;
        }
        throw new UserNotFoundException();
    }

    public String getUserDetails() {
        return currentUser.getDetails();
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
