package org.librarysystem.model;

/**
 * The {@code User} class represents a user of the library system.
 * Each user has a unique username, password, and a role which can be
 * either "librarian" or "student".
 *
 * <p>This class is used to authenticate users and determine their access
 * level in the system (e.g., librarians can manage books, students can borrow/return).
 */
public class User {
    private final String username;  // Username used for login (e.g., librarian1)
    private final String password;  // Password for login (e.g., lib123)
    private final String role;      // User role: "librarian" or "student"

    /**
     * Constructs a new {@code User} with the given username, password, and role.
     *
     * @param username the username for this user
     * @param password the password for this user
     * @param role     the role of this user ("librarian" or "student")
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public String getRole() { return role; }

    /**
     * Returns a simple string representation of the user,
     * showing the username and role.
     *
     * @return a string like: librarian1 (librarian)
     */
    @Override
    public String toString() {
        return username + " (" + role + ")";
    }
}
