package com.college.dao;

import com.college.model.Course;
import com.college.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean insertCourse(Course course) {
        String sql = "INSERT INTO courses(course_name, duration, fees) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getCourseName());
            ps.setInt(2, course.getDuration());
            ps.setDouble(3, course.getFees());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setDuration(rs.getInt("duration"));
                course.setFees(rs.getDouble("fees"));
                return course;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setDuration(rs.getInt("duration"));
                course.setFees(rs.getDouble("fees"));
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public boolean updateCourse(Course course) {
        String sql = "UPDATE courses SET course_name=?, duration=?, fees=? WHERE course_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getCourseName());
            ps.setInt(2, course.getDuration());
            ps.setDouble(3, course.getFees());
            ps.setInt(4, course.getCourseId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCourse(int courseId) {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, courseId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
