package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.dao.CourseDAO;
import com.lti.dao.CourseDAOInterface;
import com.lti.dao.RegisteredCourseDAOInterface;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOInterface;

public class StudentService implements StudentServiceInterface {

	private RegisteredCourseDAOInterface courseRosterDAO;
	private CourseDAOInterface courseDAO = new CourseDAO();
	private StudentDAOInterface studentDAO = new StudentDAO();

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

	
	public List<Course> viewUnpayedCourses(int studentId) {
		
		return courseRosterDAO.viewAllPaidCourses(studentId);
	}

	public Student getStudentByUsername(String username) {
		
		return studentDAO.viewStudent(username);
		
	}

}
