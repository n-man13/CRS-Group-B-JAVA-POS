package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.dao.CourseDAO;
import com.lti.dao.CourseDAOInterface;
import com.lti.dao.RegisteredCourseDAO;
import com.lti.dao.RegisteredCourseDAOInterface;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOInterface;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOInterface;
import com.lti.exception.AllCoursesPaidException;
import com.lti.exception.CourseFullException;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.UsernameUsedException;

public class StudentService implements StudentServiceInterface {
	

	private RegisteredCourseDAOInterface registeredCourseDAO = new RegisteredCourseDAO();
	private CourseDAOInterface courseDAO = new CourseDAO();
	private StudentDAOInterface studentDAO = new StudentDAO();
	private UserDAOInterface userDAO = new UserDAO();
	/**
	 * calls DAO method 
	 * @param int courseId
	 * @return map of student to grade 
	 * throws courseNotFoundException if courseId doesn't exist
	 * throws NoStudentsEnrolledException if there 
	 */	
	public void applyToCourse(int studentId, int courseId) throws CourseNotFoundException, CourseFullException {
		
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		if (registeredCourseDAO.viewAllStudents(courseId).size() >= 10) throw new CourseFullException("This course is full, ID: ", courseId);
		registeredCourseDAO.addStudentRegistration(studentId, courseId);
		
	}

	public void dropCourse(int studentId, int courseId) throws CourseNotFoundException{
		List <Course> courses = registeredCourseDAO.viewStudentCourses(studentId);
		int i = 0;
		for (Course c : courses) {
			if (c.getCourseID() != courseId) i++;
		}
		if (courses.size() == i) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		registeredCourseDAO.removeStudentRegistration(studentId, courseId);
	}

	public List<Course> viewAppliedCourses(int studentId) {
		
		return registeredCourseDAO.viewStudentCourses(studentId);
	}

	public void makePayment(int studentId, int courseId) {
		
		registeredCourseDAO.payFee(studentId, courseId);
	}

	public Map<Course, Double> checkGrades(int studentId) {
		
		return registeredCourseDAO.viewGrades(studentId);
	}

	
	public List<Course> viewUnpayedCourses(int studentId) throws AllCoursesPaidException{
		
		List <Course> courses = registeredCourseDAO.viewUnpaidCourses(studentId);
		if (courses.isEmpty()) throw new AllCoursesPaidException("There are no more courses to pay, student ID: ", studentId);
		return registeredCourseDAO.viewUnpaidCourses(studentId);
	}

	public Student getStudentByUsername(String username) {
		
		return studentDAO.viewStudent(username);
		
	}

	@Override
	public void createStudent(Student student) throws UsernameUsedException {
		if (userDAO.viewUser(student.getUsername()) != null) throw new UsernameUsedException("Username already taken, username: ", student.getUsername());
		student.setRegistered(false);
		studentDAO.createStudent(student);
				
	}

}
