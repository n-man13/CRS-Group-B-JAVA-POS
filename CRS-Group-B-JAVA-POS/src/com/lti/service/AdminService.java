package com.lti.service;

import java.util.ArrayList;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.dao.CourseDAOInterface;

public class AdminService implements AdminServiceInterface{
	
	public Course createCourse(int id, String name, String department, int prereqID) {
		Course newCourse = new Course(id, name, department, prereqID);
		CourseDAOInterface course = new CourseDAO();
		course.createCourse(newCourse);
		System.out.println("Course created");
		return newCourse;
		
	}
	
	public Professor createProfessor(int profID) {
		Professor prof = new Professor(profID);
		System.out.println("Professor created");
		return prof;

	}
	
	public void updateCourse(Course course, String name, String department, Professor prof, int prereqID) {
		course.setName(name);
		course.setDepartment(department);
		course.setProf(prof);
		course.setPrereqCourseID(prereqID);
		System.out.println("Course updated");

	}
	
	public Course deleteCourse(ArrayList<Course> courses, int courseID) {
		Course c = null;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseID() == courseID) {
				c = courses.remove(i);
				System.out.println("Course deleted");
				return c;
			}
		}
		System.out.println("Course not found");
		return c;
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
