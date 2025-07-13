package com.college.service;

import com.college.dao.StudentDAO;
import com.college.dao.StudentDAOImpl;
import com.college.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO = new StudentDAOImpl();

	@Override
	public boolean addStudent(Student student) {
		// Business logic if needed before insert
		return studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDAO.getStudentById(studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	public boolean updateStudent(Student student) {
		// Business validation can be added here
		return studentDAO.updateStudent(student);
	}

	@Override
	public boolean deleteStudent(int studentId) {
		return studentDAO.deleteStudent(studentId);
	}
}
