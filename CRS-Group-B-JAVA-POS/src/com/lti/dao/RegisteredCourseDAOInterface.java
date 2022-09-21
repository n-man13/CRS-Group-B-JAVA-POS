/**
 * 
 */
package com.lti.dao;

import java.util.ArrayList;
import java.util.Map;

import com.lti.bean.*;

/**
 * @author user101
 *
 */
public interface RegisteredCourseDAOInterface {
	// view one, view all, create, update, delete
	public ArrayList<Course> viewStudentCourses(int studentID);
	
	public ArrayList<Student> viewAllStudents(int courseID);
	
	public ArrayList<Course> viewAllPaidCourses(int studentID);
	
	public Map<Student, Double> viewStudentsAndGrades(int courseID);
	
	public Map<Course, Double> viewGrades(int studentID);
	
	public boolean addStudentRegistration(int studentID, int courseID);
	
	public boolean payFee(int studentID, int courseID);
	
	public boolean setGrade(int studentID, int courseID, double grade);
	
	public boolean removeStudentRegistration(int studentID, int courseID);
}
