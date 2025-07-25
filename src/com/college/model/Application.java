package com.college.model;

import java.util.Date;

public class Application {
	private int applicationId;
	private int studentId;
	private int courseId;
	private Date applicationDate;
	private String status; 
    private int marks;
	public Application() {
	}

	public Application(int applicationId, int studentId, int courseId, Date applicationDate, String status,int marks) {
		this.applicationId = applicationId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.applicationDate = applicationDate;
		this.status = status;
		this.marks=marks;
	}

	// Getters and Setters

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks=marks;
	}
}
