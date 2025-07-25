College Admission Management System
Overview
College Admission Management System is a Java-based console application designed to manage students, courses, and admission applications efficiently.
It supports CRUD operations and provides functionalities such as merit list generation and CSV import/export of student data.

This project was developed as part of an internship at Elevate Labs and demonstrates key concepts of object-oriented programming, database interaction, and file handling.

Folder Structure
src/
└── com/
    └── college/
        ├── controller/
        │   └── AdmissionController.java
        ├── dao/
        │   ├── ApplicationDAO.java
        │   ├── ApplicationDAOImpl.java
        │   ├── CourseDAO.java
        │   ├── CourseDAOImpl.java
        │   ├── StudentDAO.java
        │   └── StudentDAOImpl.java
        ├── dto/
        │   ├── ApplicationDTO.java
        │   ├── CourseDTO.java
        │   └── StudentDTO.java
        ├── main/
        │   └── AppLauncher.java
        ├── model/
        │   ├── Application.java
        │   ├── Course.java
        │   └── Student.java
        ├── service/
        │   ├── ApplicationService.java
        │   ├── ApplicationServiceImpl.java
        │   ├── CourseService.java
        │   ├── CourseServiceImpl.java
        │   ├── StudentService.java
        │   └── StudentServiceImpl.java
        └── util/
            ├── CSVUtility.java
            └── DBConnection.java
Features
Add, View, Update, Delete Students

Add, View, Update, Delete Courses

Add, View, Update, Delete Applications

View merit list based on marks cutoff

Import and Export student data via CSV files

Database connectivity via JDBC

Simple, menu-driven console interface

Tools and Technologies Used
Java SE (JDK 8 or above)

JDBC for database interaction (MySQL)

Eclipse IDE for development

MySQL as backend database

File I/O for CSV import/export

OOP concepts (Encapsulation, Abstraction, Inheritance)

Console-based user input with Scanner

How to Run
Setup Database:
Create MySQL database named college_db and required tables (students, courses, applications) according to your schema.

Configure Database Connection:
Update database credentials and URL in com.college.util.DBConnection.java.

Import Project in Eclipse:

Open Eclipse IDE

Import the project as an existing Java project

Build the project to resolve dependencies

Run Main Class:
Run com.college.main.AppLauncher as a Java Application.

Use the Console Menu:
Follow on-screen instructions to perform operations like adding students, courses, applications, importing/exporting CSV, and generating merit lists.

Sample Menu Options

==== College Admission Management System ====
1. Add Student
2. View Student by ID
3. View All Students
4. Update Student
5. Delete Student
6. Add Course
7. View Course by ID
8. View All Courses
9. Update Course
10. Delete Course
11. Add Application
12. View Application by ID
13. View All Applications
14. Update Application
15. Delete Application
16. View Merit List by Marks Cutoff
17. Import Students from CSV
18. Export Students to CSV
0. Exit
Author
Abhishek Kumar
BCA Final Year Student
Oxford Business College
Internship Project at Elevate Labs (2025)

<img width="468" height="831" alt="image" src="https://github.com/user-attachments/assets/6ba6a8fe-c5a3-41a5-bdab-d8aef17b0077" />
<img width="635" height="553" alt="image" src="https://github.com/user-attachments/assets/f023407f-79c5-4281-9aa2-e2d2faf3aa3f" />
<img width="1211" height="580" alt="image" src="https://github.com/user-attachments/assets/b64de934-4cc8-4540-9727-579b12f56ab5" />


