package org.librarysystem;

import org.librarysystem.model.Book;
import org.librarysystem.model.User;
import org.librarysystem.service.LibraryService;
import org.librarysystem.service.LoginService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Entry point of the Library Management System.
 * Handles user login, role-based menus, and interaction with LibraryService.
 */
public class Main {
    private static final LibraryService library = new LibraryService();
    private static final Scanner scanner = new Scanner(System.in);
    private static User loggedInUser = null;

    // Create user list and pass to LoginService constructor
    private static final List<User> users = new ArrayList<>();
    private static final LoginService loginService;

    static {
        // Default users: 1 librarian and 1 student
        users.add(new User("librarian1", "lib123", "librarian"));
        users.add(new User("student1", "stud123", "student"));
        loginService = new LoginService(users);
    }

    /**
     * Main application loop.
     * Prompts user to log in and redirects to the appropriate menu.
     */
    public static void main(String[] args) {
        // Sample books added at startup
        library.addBook(new Book("B001", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("B002", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("B003", "The Pragmatic Programmer", "Andrew Hunt"));

        while (true) {
            System.out.println("\n==== Welcome ====");
            System.out.println("1. Login as Librarian");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    if (login("librarian")) {
                        librarianMenu();
                    } else {
                        System.out.println("Login failed. Invalid librarian credentials.");
                    }
                }
                case "2" -> {
                    if (login("student")) {
                        studentMenu();
                    } else {
                        System.out.println("Login failed. Invalid student credentials.");
                    }
                }
                case "3" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Handles login input and verifies credentials using LoginService.
     *
     * @param expectedRole either "librarian" or "student"
     * @return true if login is successful and role matches, false otherwise
     */
    private static boolean login(String expectedRole) {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        var userOpt = loginService.login(username, password);
        if (userOpt.isPresent() && userOpt.get().getRole().equalsIgnoreCase(expectedRole)) {
            loggedInUser = userOpt.get();
            System.out.println("Logged in as: " + loggedInUser);
            return true;
        }
        return false;
    }

    /**
     * Displays librarian menu and handles actions: add, delete, view books, logout.
     */
    private static void librarianMenu() {
        while (true) {
            System.out.println("\n=== Librarian Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. View All Books");
            System.out.println("4. Exit to Main Menu");
            System.out.print("Choose option: ");

            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> addBook();
                case 2 -> deleteBook();
                case 3 -> viewAllBooks();
                case 4 -> {
                    loggedInUser = null;
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Displays student menu and handles actions: view/search/borrow/return books, logout.
     */
    private static void studentMenu() {
        while (true) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book by Title (Case-insensitive, e.g., 'clean code')");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit to Main Menu");
            System.out.print("Choose option: ");

            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> viewAllBooks();
                case 2 -> searchBook();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> {
                    loggedInUser = null;
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Prompts for book details and adds it to the library.
     */
    private static void addBook() {
        System.out.print("Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        library.addBook(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    /**
     * Prompts for a book ID and attempts to delete it.
     */
    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String id = scanner.nextLine();
        boolean removed = library.deleteBook(id);
        if (removed) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    /**
     * Displays all books currently in the library.
     */
    private static void viewAllBooks() {
        System.out.println("\nAll Books:");
        for (var book : library.viewAllBooks()) {
            System.out.println(book);
        }
    }

    /**
     * Prompts for a book title and searches the library.
     */
    private static void searchBook() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        var bookOpt = library.searchByTitle(title);
        if (bookOpt.isPresent()) {
            System.out.println(bookOpt.get());
        } else {
            System.out.println("Book not found.");
        }
    }

    /**
     * Prompts for a book ID and attempts to borrow it.
     */
    private static void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        String id = scanner.nextLine();
        if (library.borrowBook(id)) {
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is unavailable or not found.");
        }
    }

    /**
     * Prompts for a book ID and attempts to return it.
     */
    private static void returnBook() {
        System.out.print("Enter book ID to return: ");
        String id = scanner.nextLine();
        if (library.returnBook(id)) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed or not found.");
        }
    }
}
