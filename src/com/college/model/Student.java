package com.college.model;

import java.util.Date;

public class Student {
	private int studentId;
	private String name;
	private Date dob;
	private String email;
	private String phone;
	private int courseId;
	private String admissionStatus;

	public Student() {
	}

	public Student(int studentId, String name, Date dob, String email, String phone, int courseId,
			String admissionStatus) {
		this.studentId = studentId;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.courseId = courseId;
		this.admissionStatus = admissionStatus;
	}

	// Getters and Setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}
}
