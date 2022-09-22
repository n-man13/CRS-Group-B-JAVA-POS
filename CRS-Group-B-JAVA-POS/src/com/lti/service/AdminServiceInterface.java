package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Admin;
import com.lti.bean.Student;
import com.lti.exception.AllStudentRegisteredException;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.UsernameUsedException;
import com.lti.bean.Course;
import com.lti.bean.Professor;

public interface AdminServiceInterface  {
	public void createCourse(Course course);
	public void createProfessor(Professor professor) throws UsernameUsedException;
    public void updateCourse(Course course) throws CourseNotFoundException;
    public void deleteCourse(int courseId) throws CourseNotFoundException;
    public void listAllCourse();
	public void approveStudentRegistration(Student student) throws StudentNotFoundException;
	public Admin getAdminByUsername(String username);
	public List <Student> unregisteredStudent() throws AllStudentRegisteredException;
	public Student getStudentById(int stuedentId) throws StudentNotFoundException;
}
