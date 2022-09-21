package com.lti.service;

import java.util.ArrayList;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;

public interface AdminServiceInterface {
	public void createCourse(Course course);
	public void createProfessor(Professor professor);
    public void updateCourse(Course course);
    public void deleteCourse(int courseId);
    public void listAllCourse();
	public void approveStudentRegistration();
	public Admin getAdminByUsername(String username);
}
