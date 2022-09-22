package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Admin;
import com.lti.bean.Student;
import com.lti.exception.StudentNotFoundException;
import com.lti.bean.Course;
import com.lti.bean.Professor;

public interface AdminServiceInterface  {
	public void createCourse(Course course);
	public void createProfessor(Professor professor);
    public void updateCourse(Course course);
    public void deleteCourse(int courseId);
    public void listAllCourse();
	public void approveStudentRegistration(Student student) throws StudentNotFoundException;
	public Admin getAdminByUsername(String username);
	public List <Student> unregisteredStudent();
	public Student getStudentById(int stuedentId);
}
