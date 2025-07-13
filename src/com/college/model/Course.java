package com.college.model;

public class Course {
	private int courseId;
	private String courseName;
	private int duration; // months or years
	private double fees;

	public Course() {
	}

	public Course(int courseId, String courseName, int duration, double fees) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fees = fees;
	}

	// Getters and Setters
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
}
