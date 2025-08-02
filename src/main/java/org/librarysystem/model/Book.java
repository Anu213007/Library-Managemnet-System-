package org.librarysystem.model;

/**
 * The {@code Book} class represents a book in the library system.
 * It contains information such as book ID, title, author, and availability status.
 *
 * <p>This class is used by the {@link org.librarysystem.service.LibraryService}
 * to perform actions like adding, borrowing, returning, and deleting books.
 *
 * <p>Each book is identified by a unique ID and is considered "available"
 * by default when it is created.
 */
public class Book {
    private final String id;       // Unique identifier for the book (e.g., B001)
    private String title;          // Title of the book
    private String author;         // Author of the book
    private boolean available;     // Availability status (true = available)

    /**
     * Constructs a new Book object with the given ID, title, and author.
     * The book is marked as available by default.
     *
     * @param id     the unique ID of the book
     * @param title  the title of the book
     * @param author the author of the book
     */
    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns a nicely formatted string representation of the book.
     * Useful for printing to the console.
     *
     * @return a string like: [B001] Clean Code by Robert C. Martin - Available
     */
    @Override
    public String toString() {
        return "[" + id + "] " + title + " by " + author + " - " + (available ? "Available" : "Borrowed");
    }
}
