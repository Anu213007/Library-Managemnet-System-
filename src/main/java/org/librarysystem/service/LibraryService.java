package org.librarysystem.service;

import org.librarysystem.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The {@code LibraryService} class handles all core book operations
 * such as adding, viewing, borrowing, returning, deleting, and searching books.
 */
public class LibraryService {

    // A list to store all books in the library
    private final List<Book> books = new ArrayList<>();

    /**
     * Adds a new book to the library.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Returns the full list of books in the library.
     *
     * @return a list of all books
     */
    public List<Book> viewAllBooks() {
        return books;
    }

    /**
     * Searches for a book by its title (case-insensitive).
     *
     * @param title the title to search
     * @return an Optional containing the matching book if found
     */
    public Optional<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title.trim()))
                .findFirst();
    }

    /**
     * Allows a user to borrow a book using its ID.
     * If the book is already borrowed, returns false.
     * If the book is not found, throws an exception.
     *
     * @param id the book ID
     * @return true if borrowed successfully, false if already borrowed
     */
    public boolean borrowBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                if (!book.isAvailable()) {
                    return false;
                }
                book.setAvailable(false);
                return true;
            }
        }
        throw new IllegalArgumentException("Book with ID " + id + " not found.");
    }

    /**
     * Allows a user to return a book by its ID.
     * Only borrowed books can be returned.
     *
     * @param id the book ID
     * @return true if returned successfully, false otherwise
     */
    public boolean returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a book from the library by its ID.
     *
     * @param id the book ID to delete
     * @return true if deleted, false if the book wasn't found
     */
    public boolean deleteBook(String id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
