package com.lti.service;

import java.util.List;
import java.util.Map;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.exception.AllCoursesPaidException;
import com.lti.exception.CourseFullException;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.UsernameUsedException;

//student service interface
public interface StudentServiceInterface {
	
	/**
	 * calls DAO method to register student in registeredcourse
	 * 
	 * @param int courseId
	 * @param int studentId
	 * @throws courseNotFoundException if courseId doesn't exist
	 * @throws CourseFullException     if there are more then 10 students
	 */
	public void applyToCourse(int studentId, int courseId) throws CourseNotFoundException, CourseFullException;
	
	/**
	 * calls DAO method to remove student in registeredCourse
	 * 
	 * @param int courseId, studentId
	 * @throws courseNotFoundException if courseId doesn't exist
	 */
	public void dropCourse(int studentId, int courseId) throws CourseNotFoundException;
	
	/**
	 * calls DAO method to view all courses student have applied
	 * 
	 * @param int courseId, studentId
	 * @return a list of courses where the student is enrolled
	 */
	public  List<Course> viewAppliedCourses(int studentId);
	
	/**
	 * calls DAO method to payFee
	 * 
	 * @param int courseId
	 * @param int studentId
	 * @throws courseNotFoundException if courseId doesn't exist
	 */
	public void makePayment(int studentId, int courseId) throws CourseNotFoundException;
	
	/**
	 * calls DAO method to view grades for a student
	 * 
	 * @param int studentId
	 * @return Returns a map course to grade
	 */
	public Map<Course, Double> checkGrades(int studentId);
	
	/**
	 * calls DAO method to view unpaid courses
	 * 
	 * @param int studentId
	 * @return Map <Course, Double>
	 * @throws allCoursed AllCoursesPaidException
	 */
	public List<Course> viewUnpayedCourses(int studentId) throws AllCoursesPaidException;
	
	/**
	 * gets a student by username
	 * 
	 * @param string username
	 * @return student
	 * 
	 */
	public Student getStudentByUsername(String username) throws StudentNotFoundException;
	
	/**
	 * creates a student
	 * 
	 * @param student
	 * @return
	 * @throws UsernameUsedException if user already exists
	 */
	public void createStudent(Student student) throws UsernameUsedException;
}
