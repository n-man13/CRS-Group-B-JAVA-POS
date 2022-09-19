package com.lti.service;

import java.util.ArrayList;

import com.lti.bean.Course;
import com.lti.bean.Professor;

public interface AdminServiceInterface {
	public Course createCourse(int id, String name, String department, int prereqID);
	public Professor createProfessor(int profID);	
    public void updateCourse(Course course, String name, String department, Professor prof, int prereqID);
    public Course deleteCourse(ArrayList<Course> courses, int courseID);
    public void listAllCourse();
	public void approveStudentRegistration();
}
