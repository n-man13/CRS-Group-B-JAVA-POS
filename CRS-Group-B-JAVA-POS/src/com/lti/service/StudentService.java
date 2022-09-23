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
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.UsernameUsedException;

public class StudentService implements StudentServiceInterface {
	

	private RegisteredCourseDAOInterface registeredCourseDAO = new RegisteredCourseDAO();
	private CourseDAOInterface courseDAO = new CourseDAO();
	private StudentDAOInterface studentDAO = new StudentDAO();
	private UserDAOInterface userDAO = new UserDAO();
	/**
	 * calls DAO method to register student in registeredcourse
	 * @param int courseId, studentId
	 * @return
	 * @throws courseNotFoundException if courseId doesn't exist
	 * @throws CourseFullException if there are more then 10 students
	 */	
	public void applyToCourse(int studentId, int courseId) throws CourseNotFoundException, CourseFullException {
		
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		if (registeredCourseDAO.viewAllStudents(courseId).size() >= 10) throw new CourseFullException("This course is full, ID: ", courseId);
		registeredCourseDAO.addStudentRegistration(studentId, courseId);
		
	}
	
	/**
	 * calls DAO method to remove student in registeredCourse
	 * @param int courseId, studentId
	 * @return
	 * @throws courseNotFoundException if courseId doesn't exist
	 */	
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
	
	/**
	 * calls DAO method to view all courses student have applied
	 * @param int courseId, studentId
	 * @return
	 */	
	public List<Course> viewAppliedCourses(int studentId) {
		
		return registeredCourseDAO.viewStudentCourses(studentId);
	}
	
	/**
	 * calls DAO method to payFee
	 * @param int courseId, studentId
	 * @return
	 * @throws courseNotFoundException if courseId doesn't exist
	 */	
	public void makePayment(int studentId, int courseId) throws CourseNotFoundException{
		
		List <Course> courses = registeredCourseDAO.viewStudentCourses(studentId);
		int i = 0;
		for (Course c : courses) {
			if (c.getCourseID() != courseId) i++;
		}
		if (courses.size() == i) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		registeredCourseDAO.payFee(studentId, courseId);
	}

	/**
	 * calls DAO method to view grades for a student
	 * @param int studentId
	 * @return map <course, double>
	 */	
	public Map<Course, Double> checkGrades(int studentId) {
		
		
		return registeredCourseDAO.viewGrades(studentId);
	}

	/**
	 * calls DAO method to view unpaid courses
	 * @param int studentId
	 * @return map <course, double>
	 * @throws allCoursed AllCoursesPaidException
	 */	
	public List<Course> viewUnpayedCourses(int studentId) throws AllCoursesPaidException{
		
		List <Course> courses = registeredCourseDAO.viewUnpaidCourses(studentId);
		if (courses.isEmpty()) throw new AllCoursesPaidException("There are no more courses to pay, student ID: ", studentId);
		return registeredCourseDAO.viewUnpaidCourses(studentId);
	}
	
	/**
	 * gets a student by username
	 * @param string username
	 * @return student
	 * 
	 */	
	public Student getStudentByUsername(String username) throws StudentNotFoundException{
		
		Student student = studentDAO.viewStudent(username);
		
		if (student == null)
			throw new StudentNotFoundException("The student does not exist", 0);
		return student;
		
	}
	
	/**
	 * creates a student
	 * @param student
	 * @return 
	 * @throws UsernameUsedException if user already exists
	 */	
	@Override
	public void createStudent(Student student) throws UsernameUsedException {
		if (userDAO.viewUser(student.getUsername()) != null) throw new UsernameUsedException("Username already taken, username: ", student.getUsername());
		student.setRegistered(false);
		studentDAO.createStudent(student);
				
	}

}
