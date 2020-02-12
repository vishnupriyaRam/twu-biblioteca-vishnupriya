package com.twu.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void shouldCheckIfTwoUsersWithTheSameDetailsAreEqual() {
        User user1 = new User("123-4567", "password0");
        User user2 = new User("123-4567", "password0");
        assertEquals(user1, user2);
    }
}