package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.exceptions.UserNotLoggedInException;
import com.twu.biblioteca.view.Output;

import java.util.*;

import static com.twu.biblioteca.model.NotificationMessages.*;

//TODO: class structure
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

    public String viewCheckedOutBooks() {
        StringJoiner list = new StringJoiner("\n");

        for (Map.Entry<Book, User> entry : checkedOut.entrySet()) {
            if (currentUser.isEquals(entry.getValue()))
                list.add(entry.getKey().getDetails());
        }
        return list.toString();
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
        for (User user: users) {
            if(user.isValid(number, password))
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
