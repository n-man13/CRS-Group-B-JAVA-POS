package com.lti.service;

import com.lti.bean.Course;
import com.lti.bean.Student;

//student service interface
public interface StudentServiceInterface {
	/**
	 * Add student to specified course
	 * @param student Student to add a course
	 * @param course Course to add
	 */
	public void applyToCourse(Student student, Course course) ;
	/**
	 * Remove student from course
	 * @param student Student to drop course
	 * @param courseID Course to drop
	 * @return Course if successful, else null
	 */
	public Course dropCourse(Student student, int courseID);
	public void viewAppliedCourses();
	/**
	 * Makes payment for courses
	 */
	public void makePayment();
	/**
	 * Check grades for student
	 * @param student Student to check grades for
	 */
	public void checkGrades(Student student) ;
	
	public void listAllCourses();

}
