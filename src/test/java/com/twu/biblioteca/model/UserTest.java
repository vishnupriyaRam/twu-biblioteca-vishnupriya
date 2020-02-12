package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void shouldCheckIfTwoUsersWithTheSameDetailsAreEqual() {
        User user1 = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        User user2 = new User("123-4568", "password1", "Harry", "harry@gmail.com", "8989898989");
        assertEquals(user1, user2);
    }
}