package com.college.controller;

import com.college.model.*;
import com.college.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AdmissionController {

	private StudentService studentService = new StudentServiceImpl();
	private CourseService courseService = new CourseServiceImpl();
	private ApplicationService applicationService = new ApplicationServiceImpl();

	private Scanner sc = new Scanner(System.in);
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public void start() {
		int choice;
		do {
			System.out.println("\n==== College Admission Management System ====");
			System.out.println("1. Add Student");
			System.out.println("2. View Student by ID");
			System.out.println("3. View All Students");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Add Course");
			System.out.println("7. View Course by ID");
			System.out.println("8. View All Courses");
			System.out.println("9. Update Course");
			System.out.println("10. Delete Course");
			System.out.println("11. Add Application");
			System.out.println("12. View Application by ID");
			System.out.println("13. View All Applications");
			System.out.println("14. Update Application");
			System.out.println("15. Delete Application");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				viewStudentById();
				break;
			case 3:
				viewAllStudents();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 6:
				addCourse();
				break;
			case 7:
				viewCourseById();
				break;
			case 8:
				viewAllCourses();
				break;
			case 9:
				updateCourse();
				break;
			case 10:
				deleteCourse();
				break;
			case 11:
				addApplication();
				break;
			case 12:
				viewApplicationById();
				break;
			case 13:
				viewAllApplications();
				break;
			case 14:
				updateApplication();
				break;
			case 15:
				deleteApplication();
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}

		} while (choice != 0);

		sc.close();
	}

	// --- Student methods ---

	private void addStudent() {
		try {
			System.out.print("Enter student name: ");
			String name = sc.nextLine();

			System.out.print("Enter DOB (dd-MM-yyyy): ");
			Date dob = sdf.parse(sc.nextLine());

			System.out.print("Enter email: ");
			String email = sc.nextLine();

			System.out.print("Enter phone: ");
			String phone = sc.nextLine();

			System.out.print("Enter course ID: ");
			int courseId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter admission status: ");
			String status = sc.nextLine();

			Student student = new Student(0, name, dob, email, phone, courseId, status);
			boolean inserted = studentService.addStudent(student);
			if (inserted)
				System.out.println("Student added successfully!");
			else
				System.out.println("Failed to add student.");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void viewStudentById() {
		System.out.print("Enter student ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		Student student = studentService.getStudentById(id);
		if (student != null) {
			System.out.println("ID: " + student.getStudentId());
			System.out.println("Name: " + student.getName());
			System.out.println("DOB: " + sdf.format(student.getDob()));
			System.out.println("Email: " + student.getEmail());
			System.out.println("Phone: " + student.getPhone());
			System.out.println("Course ID: " + student.getCourseId());
			System.out.println("Admission Status: " + student.getAdmissionStatus());
		} else {
			System.out.println("Student not found.");
		}
	}

	private void viewAllStudents() {
		List<Student> students = studentService.getAllStudents();
		if (students.isEmpty()) {
			System.out.println("No students found.");
		} else {
			for (Student s : students) {
				System.out.println("------------------------");
				System.out.println("ID: " + s.getStudentId());
				System.out.println("Name: " + s.getName());
				System.out.println("DOB: " + sdf.format(s.getDob()));
				System.out.println("Email: " + s.getEmail());
				System.out.println("Phone: " + s.getPhone());
				System.out.println("Course ID: " + s.getCourseId());
				System.out.println("Admission Status: " + s.getAdmissionStatus());
			}
		}
	}

	private void updateStudent() {
		try {
			System.out.print("Enter student ID to update: ");
			int id = sc.nextInt();
			sc.nextLine();

			Student existing = studentService.getStudentById(id);
			if (existing == null) {
				System.out.println("Student not found.");
				return;
			}

			System.out.print("Enter new name (" + existing.getName() + "): ");
			String name = sc.nextLine();
			if (!name.isEmpty())
				existing.setName(name);

			System.out.print("Enter new DOB (dd-MM-yyyy) (" + sdf.format(existing.getDob()) + "): ");
			String dobStr = sc.nextLine();
			if (!dobStr.isEmpty())
				existing.setDob(sdf.parse(dobStr));

			System.out.print("Enter new email (" + existing.getEmail() + "): ");
			String email = sc.nextLine();
			if (!email.isEmpty())
				existing.setEmail(email);

			System.out.print("Enter new phone (" + existing.getPhone() + "): ");
			String phone = sc.nextLine();
			if (!phone.isEmpty())
				existing.setPhone(phone);

			System.out.print("Enter new course ID (" + existing.getCourseId() + "): ");
			String courseIdStr = sc.nextLine();
			if (!courseIdStr.isEmpty())
				existing.setCourseId(Integer.parseInt(courseIdStr));

			System.out.print("Enter new admission status (" + existing.getAdmissionStatus() + "): ");
			String status = sc.nextLine();
			if (!status.isEmpty())
				existing.setAdmissionStatus(status);

			boolean updated = studentService.updateStudent(existing);
			if (updated)
				System.out.println("Student updated successfully!");
			else
				System.out.println("Failed to update student.");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void deleteStudent() {
		System.out.print("Enter student ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();

		boolean deleted = studentService.deleteStudent(id);
		if (deleted)
			System.out.println("Student deleted successfully.");
		else
			System.out.println("Failed to delete student or student not found.");
	}

	// --- Course methods ---

	private void addCourse() {
		try {
			System.out.print("Enter course name: ");
			String name = sc.nextLine();

			System.out.print("Enter duration (months): ");
			int duration = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter fees: ");
			double fees = sc.nextDouble();
			sc.nextLine();

			Course course = new Course(0, name, duration, fees);
			boolean inserted = courseService.addCourse(course);
			if (inserted)
				System.out.println("Course added successfully!");
			else
				System.out.println("Failed to add course.");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void viewCourseById() {
		System.out.print("Enter course ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		Course course = courseService.getCourseById(id);
		if (course != null) {
			System.out.println("ID: " + course.getCourseId());
			System.out.println("Name: " + course.getCourseName());
			System.out.println("Duration: " + course.getDuration() + " months");
			System.out.println("Fees: " + course.getFees());
		} else {
			System.out.println("Course not found.");
		}
	}

	private void viewAllCourses() {
		List<Course> courses = courseService.getAllCourses();
		if (courses.isEmpty()) {
			System.out.println("No courses found.");
		} else {
			for (Course c : courses) {
				System.out.println("------------------------");
				System.out.println("ID: " + c.getCourseId());
				System.out.println("Name: " + c.getCourseName());
				System.out.println("Duration: " + c.getDuration() + " months");
				System.out.println("Fees: " + c.getFees());
			}
		}
	}

	private void updateCourse() {
		try {
			System.out.print("Enter course ID to update: ");
			int id = sc.nextInt();
			sc.nextLine();

			Course existing = courseService.getCourseById(id);
			if (existing == null) {
				System.out.println("Course not found.");
				return;
			}

			System.out.print("Enter new name (" + existing.getCourseName() + "): ");
			String name = sc.nextLine();
			if (!name.isEmpty())
				existing.setCourseName(name);

			System.out.print("Enter new duration (months) (" + existing.getDuration() + "): ");
			String durationStr = sc.nextLine();
			if (!durationStr.isEmpty())
				existing.setDuration(Integer.parseInt(durationStr));

			System.out.print("Enter new fees (" + existing.getFees() + "): ");
			String feesStr = sc.nextLine();
			if (!feesStr.isEmpty())
				existing.setFees(Double.parseDouble(feesStr));

			boolean updated = courseService.updateCourse(existing);
			if (updated)
				System.out.println("Course updated successfully!");
			else
				System.out.println("Failed to update course.");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void deleteCourse() {
		System.out.print("Enter course ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();

		boolean deleted = courseService.deleteCourse(id);
		if (deleted)
			System.out.println("Course deleted successfully.");
		else
			System.out.println("Failed to delete course or course not found.");
	}

	// --- Application methods ---

	private void addApplication() {
		try {
			System.out.print("Enter student ID: ");
			int studentId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter course ID: ");
			int courseId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter application date (dd-MM-yyyy): ");
			Date appDate = sdf.parse(sc.nextLine());

			System.out.print("Enter status (Pending/Approved/Rejected): ");
			String status = sc.nextLine();

			Application app = new Application(0, studentId, courseId, appDate, status);
			boolean inserted = applicationService.addApplication(app);
			if (inserted)
				System.out.println("Application added successfully!");
			else
				System.out.println("Failed to add application.");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void viewApplicationById() {
		System.out.print("Enter application ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		Application app = applicationService.getApplicationById(id);
		if (app != null) {
			System.out.println("Application ID: " + app.getApplicationId());
			System.out.println("Student ID: " + app.getStudentId());
			System.out.println("Course ID: " + app.getCourseId());
			System.out.println("Application Date: " + sdf.format(app.getApplicationDate()));
			System.out.println("Status: " + app.getStatus());
		} else {
			System.out.println("Application not found.");
		}
	}

	private void viewAllApplications() {
		List<Application> apps = applicationService.getAllApplications();
		if (apps.isEmpty()) {
			System.out.println("No applications found.");
		} else {
			for (Application app : apps) {
				System.out.println("------------------------");
				System.out.println("Application ID: " + app.getApplicationId());
				System.out.println("Student ID: " + app.getStudentId());
				System.out.println("Course ID: " + app.getCourseId());
				System.out.println("Application Date: " + sdf.format(app.getApplicationDate()));
				System.out.println("Status: " + app.getStatus());
			}
		}
	}

	private void updateApplication() {
		try {
			System.out.print("Enter application ID to update: ");
			int id = sc.nextInt();
			sc.nextLine();

			Application existing = applicationService.getApplicationById(id);
			if (existing == null) {
				System.out.println("Application not found.");
				return;
			}

			System.out.print("Enter new student ID (" + existing.getStudentId() + "): ");
			String studentIdStr = sc.nextLine();
			if (!studentIdStr.isEmpty())
				existing.setStudentId(Integer.parseInt(studentIdStr));

			System.out.print("Enter new course ID (" + existing.getCourseId() + "): ");
			String courseIdStr = sc.nextLine();
			if (!courseIdStr.isEmpty())
				existing.setCourseId(Integer.parseInt(courseIdStr));

			System.out.print(
					"Enter new application date (dd-MM-yyyy) (" + sdf.format(existing.getApplicationDate()) + "): ");
			String dateStr = sc.nextLine();
			if (!dateStr.isEmpty())
				existing.setApplicationDate(sdf.parse(dateStr));

			System.out.print("Enter new status (" + existing.getStatus() + "): ");
			String status = sc.nextLine();
			if (!status.isEmpty())
				existing.setStatus(status);

			boolean updated = applicationService.updateApplication(existing);
			if (updated)
				System.out.println("Application updated successfully!");
			else
				System.out.println("Failed to update application.");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void deleteApplication() {
		System.out.print("Enter application ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();

		boolean deleted = applicationService.deleteApplication(id);
		if (deleted)
			System.out.println("Application deleted successfully.");
		else
			System.out.println("Failed to delete application or application not found.");
	}
}
