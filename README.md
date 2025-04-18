# Student Management System (Java + MySQL)

A simple **Java-based console application** to manage students in an educational institute. This project uses **MySQL** for storing student records and **JDBC** for database connectivity.

---

## Features

- Add new student
- View all students
- Update existing student data
- Delete student
- Search student by roll number
- MySQL database integration via JDBC

---

## Technologies Used

- Java
- MySQL
- JDBC (MySQL Connector)

---

## Sample Output

--- Student Management System ---
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Search Student
6. Exit
Enter your choice:

---

## Database

  **Create the MySQL database and table**:
   ```sql
   CREATE DATABASE studentdb;

   USE studentdb;

   CREATE TABLE students (
       roll_no INT PRIMARY KEY,
       name VARCHAR(50),
       course VARCHAR(50),
       age INT
   );
