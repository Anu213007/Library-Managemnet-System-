package org.librarysystem.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.librarysystem.model.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @Mock
    private List<User> users; // Mocked list of users

    @InjectMocks
    private LoginService loginService; // Injects mock users into LoginService

    @Test
    void testSuccessfulLogin() {
        // Setup: correct username & password
        User user = new User("john", "1234", "student");

        // When users.stream() is called, return stream containing this user
        when(users.stream()).thenReturn(Stream.of(user));

        Optional<User> result = loginService.login("john", "1234");

        // Test output
        assertTrue(result.isPresent());
        assertEquals("student", result.get().getRole());

        // Verify stream called exactly once
        verify(users, times(1)).stream();
    }

    @Test
    void testLoginFailsWrongPassword() {
        User user = new User("john", "1234", "student");

        when(users.stream()).thenReturn(Stream.of(user));

        Optional<User> result = loginService.login("john", "wrongpass");

        assertTrue(result.isEmpty());

        verify(users).stream(); // Default is times(1)
    }

    @Test
    void testLoginFailsForNonExistentUser() {
        when(users.stream()).thenReturn(Stream.empty());

        Optional<User> result = loginService.login("unknown", "nopass");

        assertFalse(result.isPresent());

        verify(users).stream(); // Still gets called, even if no users
    }

    @Test
    void testVerifyNeverCalledForFakeUser() {
        // Let's say this time, we never log in, so no login should happen
        // So we don't call login at all

        // Just verify that login was never called on our service
        verify(users, never()).stream(); // No login attempt, stream() not called
    }
}
