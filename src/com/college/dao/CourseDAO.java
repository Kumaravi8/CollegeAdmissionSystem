package com.college.dao;

import com.college.model.Course;
import java.util.List;

public interface CourseDAO {
	boolean insertCourse(Course course);

	Course getCourseById(int courseId);

	List<Course> getAllCourses();

	boolean updateCourse(Course course);

	boolean deleteCourse(int courseId);
}
