
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



