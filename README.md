

````markdown
# 📚 Library Management System (Java Console App)

A simple **Java console-based Library Management System** that allows users to log in as either a **librarian** or **student**. Librarians can manage books, and students can view, search, borrow, and return books.

This project follows clean OOP principles, includes **JUnit 5 testing with Mockito**, and demonstrates separation of concerns using packages like `model`, `service`, and `test`.

---

## 🚀 Features

### 👨‍🏫 Librarian
- 🔐 Login with username & password
- ➕ Add books
- ❌ Delete books by ID
- 📖 View all books
- 🔚 Logout

### 👩‍🎓 Student
- 🔐 Login with username & password
- 📖 View all books
- 🔎 Search books by title (case-insensitive)
- 📚 Borrow books by ID
- 📥 Return books by ID
- 🔚 Logout

---

## 🧪 Unit Testing

Includes complete **JUnit 5** test coverage for:
- `LibraryService` methods (add, search, borrow, return)
- `LoginService` using `@Mock`, `@InjectMocks`, and `verify(times())` / `verify(never())` from **Mockito**
- Parameterized tests with:
  - `@ValueSource`
  - `@CsvSource`
  - `@CsvFileSource`
  - `@MethodSource`

---

## 👤 Default Users

| Role      | Username     | Password |
|-----------|--------------|----------|
| Librarian | `librarian1` | `lib123` |
| Student   | `student1`   | `stud123` |

---

## 🧾 Book Examples (Pre-loaded)

```bash
ID     | Title                   | Author
------------------------------------------------
B001   | Clean Code              | Robert C. Martin
B002   | Effective Java          | Joshua Bloch
B003   | The Pragmatic Programmer | Andrew Hunt
````

---

## 📂 Project Structure

```
org.librarysystem/
├── model/
│   ├── Book.java
│   └── User.java
├── service/
│   ├── LibraryService.java
│   └── LoginService.java
├── test/
│   ├── LibraryServiceTest.java
│   └── LoginServiceTest.java
└── Main.java
```

---

## ✅ Requirements

* Java 17 or later
* IDE (like IntelliJ IDEA, Eclipse, VS Code)
* JUnit 5 (for testing)
* Mockito (for mocking)

---

## 📦 How to Run

1. Clone the repo:

   ```bash
   git clone https://github.com/your-username/library-system.git
   cd library-system
   ```

2. Open the project in your favorite IDE.

3. Run `Main.java`.

4. Follow the on-screen prompts to log in as a librarian or student.

---

## 🧠 Learning Outcomes

* Java OOP: classes, objects, encapsulation
* Console input/output handling
* Role-based logic flow
* Java collections (List, Optional, Stream)
* Unit testing with JUnit 5
* Mockito for mocking and behavior verification
* Clean code practices

---

## 📟 Project Output

==== Welcome ====
1. Login as Librarian
2. Login as Student
3. Exit
Choose option: 1
Username: librarian1
Password: lib123
Logged in as: librarian1 (librarian)

=== Librarian Menu ===
1. Add Book
2. Delete Book
3. View All Books
4. Logout
Choose option: 1
Book ID: B004
Title: Head First Java
Author: Kathy Sierra
Book added successfully.

=== Librarian Menu ===
1. Add Book
2. Delete Book
3. View All Books
4. Logout
Choose option: 3

All Books:
[B001] Clean Code by Robert C. Martin - Available  
[B002] Effective Java by Joshua Bloch - Available  
[B003] The Pragmatic Programmer by Andrew Hunt - Available  
[B004] Head First Java by Kathy Sierra - Available

Choose option: 4
Logged out.

==== Welcome ====
1. Login as Librarian
2. Login as Student
3. Exit
Choose option: 2
Username: student1
Password: stud123
Logged in as: student1 (student)

=== Student Menu ===
1. View All Books
2. Search Book by Title
3. Borrow Book
4. Return Book
5. Logout
Choose option: 2
Enter book title to search: Clean Code
[B001] Clean Code by Robert C. Martin - Available

=== Student Menu ===
Choose option: 3
Enter book ID to borrow: B001
Book borrowed successfully.

=== Student Menu ===
Choose option: 4
Enter book ID to return: B001
Book returned successfully.

Choose option: 5
Logged out.
