package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.dao.CourseDAOInterface;
import com.lti.dao.CourseRosterDAOInterface;

public class StudentService implements StudentServiceInterface {

	private Student student;
	private static int newestID = 0;
	private CourseRosterDAOInterface courseRosterDAO;
	private CourseDAOInterface courseDAO;

	public void applyToCourse(int studentId, int courseId) {
		
		courseRosterDAO.addStudentRegistration(studentId, courseId);
		
	}

	public void dropCourse(int studentId, int courseID) {
		
		courseRosterDAO.removeStudentRegistration(studentId, courseID);
	}

	public List<Course> viewAppliedCourses(int studentId) {

		return courseRosterDAO.viewStudentCourses(studentId);
	}

	public void makePayment(int studentId, int courseId) {
		
		courseRosterDAO.payFee(studentId, courseId);
	}

	public Map<Course, Double> checkGrades(int studentId) {
		
		return courseRosterDAO.viewGrades(studentId);
	}

}
