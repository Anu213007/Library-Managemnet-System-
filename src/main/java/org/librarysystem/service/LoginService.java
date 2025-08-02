package org.librarysystem.service;

import org.librarysystem.model.User;

import java.util.List;
import java.util.Optional;

/**
 * The {@code LoginService} handles user authentication
 * by validating username and password from a list of users.
 */
public class LoginService {

    private final List<User> users;

    /**
     * Constructor with dependency injection.
     * Useful for injecting a mock list of users during testing.
     *
     * @param users list of users (librarians and students)
     */
    public LoginService(List<User> users) {
        this.users = users;
    }

    /**
     * Attempts to log in with a username and password.
     *
     * @param username the username to authenticate
     * @param password the password to authenticate
     * @return Optional containing the authenticated user, or empty if credentials are invalid
     */
    public Optional<User> login(String username, String password) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();
    }
}
