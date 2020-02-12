package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.UserNotLoggedInException;

public interface MenuOperator {
    void performOperation(Library library) throws UserNotLoggedInException;
}
