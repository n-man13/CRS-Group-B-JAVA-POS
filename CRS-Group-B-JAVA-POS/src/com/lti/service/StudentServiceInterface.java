package com.lti.service;

import com.lti.bean.Course;
import com.lti.bean.Student;

//student service interface
public interface StudentServiceInterface {
	public void applyToCourse(Student student, Course course) ;
	
	public void dropCourse();
	public void viewAppliedCourses();
	
	public void makePayment();
	public void checkGrades() ;
	
	public void listAllCourses();

}
