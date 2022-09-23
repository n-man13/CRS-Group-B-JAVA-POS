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
	
	/**
	 * call courseDAO to create a course
	 * @param course
	 */
	public void createCourse(Course course);
	
	/**
	 * call professorDAO to create a professor
	 * @param course
	 * @throws UsernameUsedException if username already exists
	 */
	public void createProfessor(Professor professor) throws UsernameUsedException;
    
	/**
	 * call courseDAO to create a course
	 * @param course
	 * @throws CourseNotFoundException if courseID provided doesn't exist
	 */
	public void updateCourse(Course course) throws CourseNotFoundException;
    
	/**
	 * call courseDAO to delete a course
	 * @param int courseID
	 * @throws CourseNotFoundException if courseID provided doesn't exist
	 */
	public void deleteCourse(int courseId) throws CourseNotFoundException;
    
	/**
	 * call courseDAO to view all course
	 * @param 
	 * @return list of courses
	 */
	public void listAllCourse();
	
	/**
	 * call studentDAO to set student attribute registrationApproved to true
	 * @param student
	 * @throws StudentNotFoundException if student provided doesn't exist
	 */
	public void approveStudentRegistration(Student student) throws StudentNotFoundException;
	
	/**
	 * call adminDAO to get admin by username
	 * @param String username
	 * 
	 */	
	public Admin getAdminByUsername(String username);
	
	/**
	 * call studentDAO to get list of students that are not registered yet
	 * @param 
	 * @return list of students
	 * @throws allstudentRegisteredexception if list is empty
	 */	
	public List <Student> unregisteredStudent() throws AllStudentRegisteredException;
	
	/**
	 * call student to get student by id
	 * @param int id
	 * @return student
	 * @throws StudentNotFoundException if student was not found
	 */	
	public Student getStudentById(int studentId) throws StudentNotFoundException;
}
