package com.lti.service;

import com.lti.bean.Student;

public class StudentService implements StudentServiceInterface {
	
	private Student student;
	private static int newestID = 0;
	
	public StudentService() {
		student = new Student(++newestID);
	}
	public void applyToCourse() {
		//adds course from applied list

	}
	
	public void dropCourse() {
		//remove course from applied list
	}
	
	public void viewAppliedCourses() {
		//view list of applied courses
	}
	
	public void makePayment() {
		//make payment
	}
	
	public void checkGrades() {
		// view grades
	}
	
	public void listAllCourses() {
		//view all courses 
	}
}
