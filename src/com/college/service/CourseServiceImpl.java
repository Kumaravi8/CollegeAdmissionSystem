package com.college.service;

import com.college.dao.CourseDAO;
import com.college.dao.CourseDAOImpl;
import com.college.model.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {

	private CourseDAO courseDAO = new CourseDAOImpl();

	@Override
	public boolean addCourse(Course course) {
		// Additional business logic before insert if needed
		return courseDAO.insertCourse(course);
	}

	@Override
	public Course getCourseById(int courseId) {
		return courseDAO.getCourseById(courseId);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseDAO.getAllCourses();
	}

	@Override
	public boolean updateCourse(Course course) {
		return courseDAO.updateCourse(course);
	}

	@Override
	public boolean deleteCourse(int courseId) {
		return courseDAO.deleteCourse(courseId);
	}
}
