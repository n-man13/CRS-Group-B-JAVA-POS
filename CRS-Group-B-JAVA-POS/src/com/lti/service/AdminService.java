package com.lti.service;

import com.lti.bean.Course;

public class AdminService implements AdminServiceInterface{
	
	public Course createCourse(int id, String name, String department, int prereqID) {
		Course newCourse = new Course(id, name, department, prereqID);
		System.out.println("Course created");
		return newCourse;
		
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
