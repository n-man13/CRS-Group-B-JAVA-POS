package com.lti.service;

import java.util.List;
import java.util.Map;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.exception.AllCoursesPaidException;
import com.lti.exception.CourseFullException;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.UsernameUsedException;

//student service interface
public interface StudentServiceInterface {
	/**
	 * Add student to specified course roster
	 * @param student Student to add a course
	 * @param course Course to add
	 */
	public void applyToCourse(int studentId, int courseId) throws CourseNotFoundException, CourseFullException;
	/**
	 * Remove student from course
	 * @param student Student to drop course
	 * @param courseID Course to drop
	 * @return Course if successful, else null
	 */
	public void dropCourse(int studentId, int courseId) throws CourseNotFoundException;
	
	public  List<Course> viewAppliedCourses(int studentId);
	/**
	 * Makes payment for courses
	 */
	public void makePayment(int studentId, int courseId) throws AllCoursesPaidException;
	/**
	 * Check grades for student
	 * @param student Student to check grades for
	 */
	public Map<Course, Double> checkGrades(int studentId);
	
	public List<Course> viewUnpayedCourses(int studentId);
	
	public Student getStudentByUsername(String username);
	
	public void createStudent(Student student) throws UsernameUsedException;
}
