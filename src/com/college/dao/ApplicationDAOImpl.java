package com.college.dao;

import com.college.model.Application;
import com.college.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAOImpl implements ApplicationDAO {

	@Override
	public boolean insertApplication(Application application) {
		String sql = "INSERT INTO applications(student_id, course_id, application_date, status) VALUES (?, ?, ?, ?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, application.getStudentId());
			ps.setInt(2, application.getCourseId());
			ps.setDate(3, new java.sql.Date(application.getApplicationDate().getTime()));
			ps.setString(4, application.getStatus());

			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Application getApplicationById(int applicationId) {
		String sql = "SELECT * FROM applications WHERE application_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, applicationId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Application application = new Application();
				application.setApplicationId(rs.getInt("application_id"));
				application.setStudentId(rs.getInt("student_id"));
				application.setCourseId(rs.getInt("course_id"));
				application.setApplicationDate(rs.getDate("application_date"));
				application.setStatus(rs.getString("status"));
				return application;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Application> getAllApplications() {
		List<Application> applications = new ArrayList<>();
		String sql = "SELECT * FROM applications";
		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Application application = new Application();
				application.setApplicationId(rs.getInt("application_id"));
				application.setStudentId(rs.getInt("student_id"));
				application.setCourseId(rs.getInt("course_id"));
				application.setApplicationDate(rs.getDate("application_date"));
				application.setStatus(rs.getString("status"));
				applications.add(application);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applications;
	}

	@Override
	public boolean updateApplication(Application application) {
		String sql = "UPDATE applications SET student_id=?, course_id=?, application_date=?, status=? WHERE application_id=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, application.getStudentId());
			ps.setInt(2, application.getCourseId());
			ps.setDate(3, new java.sql.Date(application.getApplicationDate().getTime()));
			ps.setString(4, application.getStatus());
			ps.setInt(5, application.getApplicationId());

			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteApplication(int applicationId) {
		String sql = "DELETE FROM applications WHERE application_id = ?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, applicationId);
			int rows = ps.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
