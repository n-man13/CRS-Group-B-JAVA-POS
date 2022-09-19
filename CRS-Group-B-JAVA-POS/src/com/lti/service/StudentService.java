package com.lti.service;

import java.util.ArrayList;

import com.lti.bean.Course;
import com.lti.bean.Student;

public class StudentService implements StudentServiceInterface {

	private Student student;
	private static int newestID = 0;

	public StudentService() {
		student = new Student(++newestID);
	}

	public StudentService(int studentID) {

	}

	public void applyToCourse(Student student, Course course) {
		ArrayList<Course> courses = student.getRegisteredCourses();
		System.out.println("Currently registered in the following: " + courses);

		courses.add(course);
		System.out.println("Now registered in the following: " + courses);

		student.setRegisteredCourses(courses);

		// adds course from applied list

	}

	public Course dropCourse(Student student, int courseID) {
		Course c = null;
		ArrayList<Course> myCourses = student.getRegisteredCourses();
		for (int i = 0; i < myCourses.size(); i++) {
			if (myCourses.get(i).getCourseID() == courseID) {
				myCourses.remove(i);
				System.out.println("Course dropped");
				return c;
			}
		}
		System.err.println("Course not found"); // throw exception
		return c;
		// remove course from applied list
	}

	public void viewAppliedCourses() { // obsolete method
		// view list of applied courses
	}

	public void makePayment() {
		// make payment
	}

	public void checkGrades(Student student) {
		for (Course c : student.getRegisteredCourses()) {
			c.getCourseID(); // replace with grade finder
		}
		// view grades
	}

	public void listAllCourses() {
		// view all courses
	}
}
