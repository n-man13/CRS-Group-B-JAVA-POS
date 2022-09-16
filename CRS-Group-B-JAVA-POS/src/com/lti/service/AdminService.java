package com.lti.service;

public class AdminService implements AdminServiceInterface{
	
	public void createCourse() {
		System.out.println("Course created");
		
	}
	
	public void createProfessor() {
		System.out.println("Professor created");

	}
	
	public void updateCourse() {
		System.out.println("Course updated");

	}
	
	public void deleteCourse() {
		System.out.println("Course deleted");

	}
	
	public void listAllCourse() {
		//View list of courses
		System.out.println("Course list");

	}
	
	/*
	 * public void viewStudentPayments() { //View student payments }
	 */
	
	public void approveStudentRegistration() {
		//approve registration of student
		System.out.println("Student registration approved");

	}
	
	
	
}
