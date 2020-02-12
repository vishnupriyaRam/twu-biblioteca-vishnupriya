package com.twu.biblioteca.model;

import java.util.Map;
import java.util.Objects;

public class User {
    private final String libraryNumber;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;


    public User(String libraryNumber, String password, String name, String email, String phone) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    boolean isEquals(User user) {
        return libraryNumber.equals(user.libraryNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return libraryNumber.equals(user.libraryNumber) &&
                password.equals(user.password) &&
                name.equals(user.name) &&
                email.equals(user.email) &&
                phone.equals(user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber, password, name, email, phone);
    }

    public boolean isValid(String number, String password) {
        return this.libraryNumber.equals(number) && this.password.equals(password);
    }
}
