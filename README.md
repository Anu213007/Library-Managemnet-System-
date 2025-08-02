

```markdown
# 🧪 Library Management System — Java Console App (Testing Project)

A console-based Java application created to demonstrate **unit testing techniques** using **JUnit 5** and **Mockito**.

---

## 🎯 Project Overview

This project was built as part of the **Software Verification & Testing** course  
**Assigned by Nazia Nishat Ma’am**,  
Department of Software Engineering, **Metropolitan University, Sylhet**.

It simulates a simple **library system** with:

- 📘 Book management (add, delete, view)
- 🔐 Role-based login system (Librarian and Student)
- 📚 Book borrowing and returning

🧪 **Main purpose**: Practice modern **Java unit testing** and **mocking** strategies.

---

## ✅ Features

- 🔐 Role-based login: `Librarian` & `Student`
- 🧑‍🏫 Librarian:
  - Add new books
  - Delete books
  - View all books
- 🎓 Student:
  - View all books
  - Search books by title
  - Borrow & return books
- 🔄 Simple navigation menus
- 📄 Predefined credentials (see below)

---

## 🔐 Login Credentials

| Role      | Username     | Password  |
|-----------|--------------|-----------|
| Librarian | `librarian1` | `lib123`  |
| Student   | `student1`   | `stud123` |

---

## 🧪 Testing Summary

| Component        | Tested Features                                                      |
|------------------|----------------------------------------------------------------------|
| `LibraryService` | `addBook()`, `searchByTitle()`, `borrowBook()`, `returnBook()`       |
| `LoginService`   | `login()` with valid, invalid, and missing credentials               |

### ✔️ Techniques Used

- **JUnit 5** for unit testing
- **Mockito** for mocking `List<User>` and verifying behavior
- **Parameterized testing** with:
  - `@ValueSource`
  - `@CsvSource`
  - `@CsvFileSource`
  - `@MethodSource`
- **Assertions**: `assertTrue()`, `assertFalse()`, `assertEquals()`, `assertThrows()`
- **Behavior verification**: `verify(times())`, `verify(never())`

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

## 🚀 How to Run

1. Clone this repository  
2. Open the project in IntelliJ / VS Code  
3. Run `Main.java` to start the program  
4. Run `LibraryServiceTest` & `LoginServiceTest` to test the logic  

---

## 🙋‍♀️ Author

**Fahmida Rahman Anu**  
B.Sc. in Software Engineering  
Metropolitan University, Sylhet  
Batch: 2022 — 2025  
Course: *Software Verification & Testing*

---
