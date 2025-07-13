package com.college.service;

import com.college.model.Course;
import java.util.List;

public interface CourseService {
	boolean addCourse(Course course);

	Course getCourseById(int courseId);

	List<Course> getAllCourses();

	boolean updateCourse(Course course);

	boolean deleteCourse(int courseId);
}
