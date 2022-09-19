package com.lti.service;

import com.lti.bean.Course;

public interface AdminServiceInterface {
	public Course createCourse(int id, String name, String department, int prereqID);
	public void createProfessor();	
    public void updateCourse();
    public void deleteCourse();
    public void listAllCourse();
	public void approveStudentRegistration();
}
