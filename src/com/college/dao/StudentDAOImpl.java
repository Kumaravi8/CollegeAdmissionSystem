package com.college.dao;

import com.college.model.Student;
import com.college.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public boolean insertStudent(Student student) {
		String sql = "INSERT INTO students(name, dob, email, phone, course_id, admission_status) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, student.getName());
			ps.setDate(2, new java.sql.Date(student.getDob().getTime()));
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPhone());
			ps.setInt(5, student.getCourseId());
			ps.setString(6, student.getAdmissionStatus());

			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Student getStudentByEmail(String email) {
	    String sql = "SELECT * FROM students WHERE email = ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	         
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            Student student = new Student();
	            student.setStudentId(rs.getInt("student_id"));
	            student.setName(rs.getString("name"));
	            student.setDob(rs.getDate("dob"));
	            student.setEmail(rs.getString("email"));
	            student.setPhone(rs.getString("phone"));
	            student.setCourseId(rs.getInt("course_id"));
	            student.setAdmissionStatus(rs.getString("admission_status"));
	            return student;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;  // if not found
	}

	@Override
	public Student getStudentById(int studentId) {
		String sql = "SELECT * FROM students WHERE student_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setName(rs.getString("name"));
				student.setDob(rs.getDate("dob"));
				student.setEmail(rs.getString("email"));
				student.setPhone(rs.getString("phone"));
				student.setCourseId(rs.getInt("course_id"));
				student.setAdmissionStatus(rs.getString("admission_status"));
				return student;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM students";
		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setName(rs.getString("name"));
				student.setDob(rs.getDate("dob"));
				student.setEmail(rs.getString("email"));
				student.setPhone(rs.getString("phone"));
				student.setCourseId(rs.getInt("course_id"));
				student.setAdmissionStatus(rs.getString("admission_status"));
				students.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public boolean updateStudent(Student student) {
		String sql = "UPDATE students SET name=?, dob=?, email=?, phone=?, course_id=?, admission_status=? WHERE student_id=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, student.getName());
			ps.setDate(2, new java.sql.Date(student.getDob().getTime()));
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPhone());
			ps.setInt(5, student.getCourseId());
			ps.setString(6, student.getAdmissionStatus());
			ps.setInt(7, student.getStudentId());

			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int studentId) {
		String sql = "DELETE FROM students WHERE student_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, studentId);
			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
