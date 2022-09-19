package com.lti.service;

import com.lti.bean.Course;
import com.lti.bean.Student;

//student service interface
public interface StudentServiceInterface {
	/**
	 * Add student to specified course roster
	 * @param student Student to add a course
	 * @param course Course to add
	 */
	public void applyToCourse(int studentId, int courseId) ;
	/**
	 * Remove student from course
	 * @param student Student to drop course
	 * @param courseID Course to drop
	 * @return Course if successful, else null
	 */
	public void dropCourse(int studentId, int courseId);
	public void viewAppliedCourses(int studentId);
	/**
	 * Makes payment for courses
	 */
	public void makePayment(int studentId);
	/**
	 * Check grades for student
	 * @param student Student to check grades for
	 */
	public void checkGrades(Student student) ;
	
	public void viewAllCourses();

}
