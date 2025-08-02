
```markdown
# 📚 Library Management System (Console-Based)

A simple console-based Java application to manage a library system, including librarian and student roles, book management, and user login functionalities.

---

### ✅ Features

- 🔐 Role-based login system (Librarian & Student)
- 📘 Add, delete, view books (Librarian)
- 📚 View, search, borrow, and return books (Student)
- 📄 Console interaction via clean menus
- 🧪 Unit tested using JUnit 5 and Mockito

---

### 🧪 Testing

This project was created as part of the **Software Verification & Testing** course assigned by *Nazia Nishat* ma’am.

Testing has been performed with:

- **JUnit 5** for unit testing services.
- **Mockito** for mocking dependencies and verifying method behaviors.

**Highlights:**
- ✅ Parameterized tests (`@ValueSource`, `@CsvSource`, `@MethodSource`, etc.)
- ✅ Behavior verification with `verify(times())` and `verify(never())`
- ✅ Coverage includes `LoginService` and `LibraryService` methods such as:
  - `addBook()`
  - `searchByTitle()`
  - `borrowBook()`
  - `returnBook()`
  - `login()`
- 🚫 No use of `try-catch` in `Main.java` to keep testing deterministic.

---

### 📟 Project Output

```

\==== Welcome ====

1. Login as Librarian
2. Login as Student
3. Exit
   Choose option: 1
   Username: librarian1
   Password: lib123
   Logged in as: librarian1 (librarian)

\=== Librarian Menu ===

1. Add Book
2. Delete Book
3. View All Books
4. Logout
   Choose option: 1
   Book ID: B004
   Title: Head First Java
   Author: Kathy Sierra
   Book added successfully.

\=== Librarian Menu ===
Choose option: 3

All Books:
\[B001] Clean Code by Robert C. Martin - Available
\[B002] Effective Java by Joshua Bloch - Available
\[B003] The Pragmatic Programmer by Andrew Hunt - Available
\[B004] Head First Java by Kathy Sierra - Available

Choose option: 4
Logged out.

\==== Welcome ====

1. Login as Librarian
2. Login as Student
3. Exit
   Choose option: 2
   Username: student1
   Password: stud123
   Logged in as: student1 (student)

\=== Student Menu ===

1. View All Books
2. Search Book by Title
3. Borrow Book
4. Return Book
5. Logout
   Choose option: 2
   Enter book title to search: Clean Code
   \[B001] Clean Code by Robert C. Martin - Available

\=== Student Menu ===
Choose option: 3
Enter book ID to borrow: B001
Book borrowed successfully.

\=== Student Menu ===
Choose option: 4
Enter book ID to return: B001
Book returned successfully.

Choose option: 5
Logged out.

```

---

### 🚀 How to Run

1. Clone this repository  
2. Open in **IntelliJ** or **VS Code**
3. Run the `Main.java` file
4. Login credentials:
   - Librarian → `librarian1 / lib123`
   - Student → `student1 / stud123`

---

### 📁 Project Structure

```

org.librarysystem
├── model
│   ├── Book.java
│   └── User.java
├── service
│   ├── LibraryService.java
│   └── LoginService.java
├── test
│   ├── LibraryServiceTest.java
│   └── LoginServiceTest.java
└── Main.java

```


