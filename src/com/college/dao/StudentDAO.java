package com.college.dao;

import com.college.model.Student;
import java.util.List;

public interface StudentDAO {
	boolean insertStudent(Student student);
	Student getStudentByEmail(String email);
	Student getStudentById(int studentId);

	List<Student> getAllStudents();

	boolean updateStudent(Student student);

	boolean deleteStudent(int studentId);
}
