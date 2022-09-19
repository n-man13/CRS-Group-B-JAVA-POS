package com.lti.service;

import java.util.ArrayList;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.dao.CourseDAOInterface;
import com.lti.dao.ProfessorDAOInterface;

public class AdminService implements AdminServiceInterface{
	private CourseDAOInterface courseDAO;
	private ProfessorDAOInterface profDAO;
	
	public Course createCourse(int id, String name, String department, int prereqID) {
		Course newCourse = new Course(id, name, department, prereqID);
		
		courseDAO.createCourse(newCourse);
		System.out.println("Course created");
		return newCourse;
		
	}
	
	public Professor createProfessor(String name) {
		Professor prof = new Professor(name);
		int id = profDAO.createProfessor(prof);
		System.out.println("Professor created");
		prof = new Professor(id, name);
		return prof;
	}
	
	public void updateCourse(Course course, String name, String department, Professor prof, int prereqID) { //TODO:
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
