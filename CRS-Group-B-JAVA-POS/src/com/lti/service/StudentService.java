package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.dao.CourseDAOInterface;
import com.lti.dao.CourseRosterDAOInterface;

public class StudentService implements StudentServiceInterface {

	private Student student;
	private static int newestID = 0;
	private CourseRosterDAOInterface courseRosterDAO;
	private CourseDAOInterface courseDAO;

	public StudentService() {
		
	}

	public StudentService(int studentID) {

	}

	public void applyToCourse(int studentId, int courseId) {
		
		List<Course> allCourses = courseDAO.viewAllCourses();
		for (Course c : allCourses) {
			System.out.println("Id: " + c.getCourseID() +
			"\nName: " + c.getName() + 
			"\nDepartment: " + c.getDepartment() +
			"\nPrerequisite" + c.getPrereqCourseID());
		}
		System.out.println("Please enter the course ID to apply");
		courseRosterDAO.addStudent(studentId, courseId);
		
		
//		ArrayList<Course> courses = student.getRegisteredCourses();
//		System.out.println("Currently registered in the following: " + courses);
//
//		courses.add(course);
//		System.out.println("Now registered in the following: " + courses);
//
//		student.setRegisteredCourses(courses);

		// adds course from applied list

	}

	public void dropCourse(int studentId, int courseID) {
//		Course c = null;
//		ArrayList<Course> myCourses = student.getRegisteredCourses();
//		for (int i = 0; i < myCourses.size(); i++) {
//			if (myCourses.get(i).getCourseID() == courseID) {
//				myCourses.remove(i);
//				System.out.println("Course dropped");
//				return c;
//			}
//		}
//		System.err.println("Course not found"); // throw exception
//		return c;
		// remove course from applied list
	}

	public void viewAppliedCourses(int studentId) { // obsolete method
		// view list of applied courses
	}

	public void makePayment(int studentId) {
		// make payment
	}

	public void checkGrades(Student student) {
		for (Course c : student.getRegisteredCourses()) {
			c.getCourseID(); // replace with grade finder
		}
		// view grades
	}

	public void viewAllCourses() {
		// view all courses
	}
}
