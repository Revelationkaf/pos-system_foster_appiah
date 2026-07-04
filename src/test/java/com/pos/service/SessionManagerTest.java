package com.pos.service;

import com.pos.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionManagerTest {

    @AfterEach
    void tearDown() {
        SessionManager.logout();
    }

    @Test
    void sessionManagerTracksLoginStateAndUser() {
        User user = new User();
        user.setFullName("Bob");
        user.setRole("cashier");

        SessionManager.setCurrentUser(user);

        assertTrue(SessionManager.isLoggedIn());
        assertEquals("Bob", SessionManager.getCashierName());
        assertSame(user, SessionManager.getCurrentUser());
    }

    @Test
    void logoutClearsCurrentUser() {
        User user = new User();
        user.setFullName("Alice");
        user.setRole("admin");

        SessionManager.setCurrentUser(user);
        SessionManager.logout();

        assertFalse(SessionManager.isLoggedIn());
        assertEquals("Unknown", SessionManager.getCashierName());
    }
}
