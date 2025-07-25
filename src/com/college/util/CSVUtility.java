package com.college.util;

import com.college.service.StudentService;
import com.college.model.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.List;

public class CSVUtility {

    private StudentService studentService;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    // Constructor accepting StudentService
    public CSVUtility(StudentService studentService) {
        this.studentService = studentService;
    }

    // Export students to CSV
    public void exportStudents(String filePath) {
        List<Student> students = studentService.getAllStudents();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write CSV header
            bw.write("StudentId,Name,DOB,Email,Phone,CourseId,AdmissionStatus");
            bw.newLine();

            // Write student data
            for (Student s : students) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.getStudentId()).append(",");
                sb.append(s.getName()).append(",");
                sb.append(sdf.format(s.getDob())).append(",");
                sb.append(s.getEmail()).append(",");
                sb.append(s.getPhone()).append(",");
                sb.append(s.getCourseId()).append(",");
                sb.append(s.getAdmissionStatus());
                bw.write(sb.toString());
                bw.newLine();
            }

            System.out.println("Students data exported successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }

    // Import students from CSV
    public void importStudents(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                // Skip header
                if (lineNumber == 1) continue;

                String[] data = line.split(",");
                if (data.length < 7) {
                    System.out.println("Invalid data at line " + lineNumber + ", skipping...");
                    continue;
                }

                try {
                    // Parse fields
                    String name = data[1].trim();
                    java.util.Date dob = sdf.parse(data[2].trim());
                    String email = data[3].trim();
                    String phone = data[4].trim();
                    int courseId = Integer.parseInt(data[5].trim());
                    String admissionStatus = data[6].trim();

                    // Check if student already exists by email
                    if (studentService.getStudentByEmail(email) != null) {
                        System.out.println("Duplicate email at line " + lineNumber + ": " + email + ", skipping...");
                        continue;
                    }

                    Student student = new Student(0, name, dob, email, phone, courseId, admissionStatus);
                    boolean added = studentService.addStudent(student);
                    if (!added) {
                        System.out.println("Failed to add student at line " + lineNumber);
                    }
                } catch (Exception e) {
                    System.out.println("Error parsing line " + lineNumber + ": " + e.getMessage());
                }
            }

            System.out.println("CSV import completed.");
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
