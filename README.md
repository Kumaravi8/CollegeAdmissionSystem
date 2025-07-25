# 🎓 College Admission Management System

## 📖 Overview

**College Admission Management System** is a Java-based console application designed to manage **students**, **courses**, and **admission applications** efficiently.  
It supports **CRUD operations** and includes advanced features like **merit list generation** and **CSV import/export** of student data.

This project was developed as part of an internship at **Elevate Labs** and demonstrates key concepts of **object-oriented programming**, **JDBC database interaction**, and **file handling** in Java.

---

## 🗂️ Folder Structure

src/
└── com/
└── college/
├── controller/
│ └── AdmissionController.java
├── dao/
│ ├── ApplicationDAO.java
│ ├── ApplicationDAOImpl.java
│ ├── CourseDAO.java
│ ├── CourseDAOImpl.java
│ ├── StudentDAO.java
│ └── StudentDAOImpl.java
├── dto/
│ ├── ApplicationDTO.java
│ ├── CourseDTO.java
│ └── StudentDTO.java
├── main/
│ └── AppLauncher.java
├── model/
│ ├── Application.java
│ ├── Course.java
│ └── Student.java
├── service/
│ ├── ApplicationService.java
│ ├── ApplicationServiceImpl.java
│ ├── CourseService.java
│ ├── CourseServiceImpl.java
│ ├── StudentService.java
│ └── StudentServiceImpl.java
└── util/
├── CSVUtility.java
└── DBConnection.java


---

## 🚀 Features

- Add, View, Update, Delete Students  
- Add, View, Update, Delete Courses  
- Add, View, Update, Delete Applications  
- View merit list based on marks cutoff  
- Import and Export student data via CSV  
- JDBC-based database connectivity  
- Console-driven user interaction  

---

## 🧰 Tools & Technologies Used

- Java SE (JDK 8 or above)  
- JDBC (MySQL)  
- Eclipse IDE  
- MySQL (as backend DB)  
- File I/O for CSV  
- OOP Concepts (Encapsulation, Abstraction, Inheritance)  
- Scanner (for user input)

---

## ▶️ How to Run

### 🏗️ Step 1: Setup Database
- Create MySQL database: `college_db`
- Add tables: `students`, `courses`, `applications` as per your schema.

### ⚙️ Step 2: Configure DB
- Open `com.college.util.DBConnection.java`
- Update your `JDBC URL`, `username`, and `password`.

### 🧩 Step 3: Import Project
- Open **Eclipse**
- Import as an **Existing Java Project**
- Build and resolve dependencies

### 🚦 Step 4: Run the Application
- Run `AppLauncher.java` (inside `com.college.main`) as a Java Application
- Use the CLI menu to interact

---

## 📋 Sample Menu Options

==== College Admission Management System ====

Add Student

View Student by ID

View All Students

Update Student

Delete Student

Add Course

View Course by ID

View All Courses

Update Course

Delete Course

Add Application

View Application by ID

View All Applications

Update Application

Delete Application

View Merit List by Marks Cutoff

Import Students from CSV

Export Students to CSV

Exit



---

## 👨‍💻 Author

**Abhishek Kumar**  
🎓 BCA Final Year Student  
🏫 Oxford Business College  
🛠 Internship Project at **Elevate Labs (2025)**  

---

## 📸 Screenshots
<img width="464" height="822" alt="image" src="https://github.com/user-attachments/assets/42a381cb-feef-465c-b0b3-67a7fdac341a" />


<img width="768" height="626" alt="image" src="https://github.com/user-attachments/assets/2f1a81d8-9736-4b7a-bad8-ee3720f03dfc" />
<img width="1505" height="729" alt="image" src="https://github.com/user-attachments/assets/ab360aed-1c17-4490-93f6-34ea69b1c728" />
