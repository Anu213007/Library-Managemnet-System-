package org.librarysystem.service;

import org.junit.jupiter.api.*;
import org.librarysystem.model.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LibraryServiceTest {

    private LibraryService library;

    @BeforeAll
    void setupAll() {
        System.out.println("Running LibraryService tests...");
    }

    @BeforeEach
    void setup() {
        library = new LibraryService();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed.");
    }

    @AfterAll
    void tearDownAll() {
        System.out.println("All LibraryService tests done.");
    }

    @Test
    void testAddBookIncreasesSize() {
        Book book = new Book("B001", "Test Book", "Author A");
        library.addBook(book);

        List<Book> books = library.viewAllBooks();
        assertEquals(1, books.size(), "Library should contain 1 book after adding");
        assertEquals("Test Book", books.get(0).getTitle());
    }

    @Test
    void testSearchByTitleReturnsCorrectBook() {
        Book book = new Book("B002", "Clean Code", "Robert C. Martin");
        library.addBook(book);

        var result = library.searchByTitle("clean code");
        assertTrue(result.isPresent(), "Book should be found (case-insensitive)");
        assertEquals("Clean Code", result.get().getTitle());
    }

    @Test
    void testBorrowBookMarksAsUnavailable() {
        Book book = new Book("B003", "Effective Java", "Joshua Bloch");
        library.addBook(book);

        boolean borrowed = library.borrowBook("B003");
        assertTrue(borrowed, "Borrow should succeed");
        assertFalse(book.isAvailable(), "Book should be marked as unavailable");
    }

    @Test
    void testReturnBookMarksAsAvailable() {
        Book book = new Book("B004", "Java Concurrency", "Goetz");
        library.addBook(book);
        library.borrowBook("B004");

        boolean returned = library.returnBook("B004");
        assertTrue(returned, "Return should succeed");
        assertTrue(book.isAvailable(), "Book should be marked as available again");
    }

    @Test
    void testBorrowingInvalidBookIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("NOT_EXIST");
        }, "Should throw if book ID is not found");
    }

    @Test
    void testDeleteBookRemovesBook() {
        Book book = new Book("B999", "Delete Me", "Unknown");
        library.addBook(book);

        boolean removed = library.deleteBook("B999");

        assertTrue(removed, "Book should be deleted successfully");

        var found = library.searchByTitle("Delete Me");
        assertFalse(found.isPresent(), "Deleted book should not be found anymore");
    }

    @Test
    void testViewAllBooksReturnsCorrectList() {
        Book book1 = new Book("B201", "Book A", "Author A");
        Book book2 = new Book("B202", "Book B", "Author B");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.viewAllBooks();
        assertEquals(2, books.size(), "There should be 2 books");
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }


    @ParameterizedTest  //This will test searchByTitle() for 3 different titles with just one test method.
    @ValueSource(strings = {"clean code", "Effective Java", "THE PRAGMATIC PROGRAMMER"})
    void testSearchByTitleWithMultipleInputs(String inputTitle) {
        library.addBook(new Book("B001", "Clean Code", "Author A"));
        library.addBook(new Book("B002", "Effective Java", "Author B"));
        library.addBook(new Book("B003", "The Pragmatic Programmer", "Author C"));

        var result = library.searchByTitle(inputTitle);
        assertTrue(result.isPresent(), "Book should be found for input: " + inputTitle);
    }

    @ParameterizedTest
    @CsvSource({
            "B101, Test Book A",
            "B102, Test Book B"
    })
    void testBorrowBookWorksForMultipleBooks(String id, String title) {
        Book book = new Book(id, title, "Some Author");
        library.addBook(book);

        boolean borrowed = library.borrowBook(id);
        assertTrue(borrowed, "Should successfully borrow book: " + title);
        assertFalse(book.isAvailable(), "Book should not be available after borrowing");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/book_titles.csv", numLinesToSkip = 0)
    void testAddAndSearchBookFromCsv(String id, String title) {
        Book book = new Book(id, title, "Some Author");
        library.addBook(book);

        var result = library.searchByTitle(title);
        assertTrue(result.isPresent(), "Book should be found: " + title);
    }

    static Stream<String> titleProvider() {
        return Stream.of("Clean Code", "Effective Java", "The Pragmatic Programmer");
    }

    @ParameterizedTest
    @MethodSource("titleProvider")
    void testSearchBookWithMethodSource(String title) {
        library.addBook(new Book("ID1", "Clean Code", "A"));
        library.addBook(new Book("ID2", "Effective Java", "B"));
        library.addBook(new Book("ID3", "The Pragmatic Programmer", "C"));

        var result = library.searchByTitle(title);
        assertTrue(result.isPresent(), "Book should be found for: " + title);
    }




}
