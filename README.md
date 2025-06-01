# 📚 Terminal-Based Bookstore Management System

## Description

This is a terminal-based **Bookstore Management System** developed in Java. It allows users to register, log in, and manage a list of books with validation and storage in a MySQL database. The system is designed for learning purposes and demonstrates core concepts like user authentication, JDBC database connectivity, and data validation.

---

## 🔧 Features

- ✅ **User Registration & Login**  
  Securely create or log in to a user account using email and password.

- 📘 **Book Management**  
  After logging in, users can:
  - Add books with title, author, ISBN, and publication year.
  - Input is validated to ensure accuracy and consistency.

- 🛡️ **Input Validation**
  - ISBN format: `XXX-X-XXXXXX-XXXX-X`
  - Publication year range: 1450–2023
  - Title, author, and ISBN must be non-null and non-empty.

- 🗃️ **MySQL Integration**
  - User data and book records are stored in a MySQL database (`userdb`).
  - JDBC is used for database connectivity and operations.

- 💻 **Terminal-Based UI**
  - Intuitive prompts guide users through the system using standard input and output.

---

## 📁 Technologies Used

- **Java (JDK 17+)**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **VS Code** (or any Java-compatible IDE)

---
