package com.college.service;

import com.college.model.Student;
import java.util.List;

public interface StudentService {
	boolean addStudent(Student student);

	Student getStudentById(int studentId);

	 Student getStudentByEmail(String email);
	 
	List<Student> getAllStudents();

	boolean updateStudent(Student student);

	boolean deleteStudent(int studentId);
}
