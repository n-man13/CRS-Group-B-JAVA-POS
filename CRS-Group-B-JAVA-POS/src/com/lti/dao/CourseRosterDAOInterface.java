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
public interface CourseRosterDAOInterface {
	// view one, view all, create, update, delete
	public ArrayList<Course> viewAllCourses(int studentID);
	
	public ArrayList<Student> viewAllStudents(int courseID);
	
	public ArrayList<Course> viewAllPaidCourses(int studentID);
	
	public Map<Course, Double> viewGrades(int studentID);
	
	public boolean addStudent(int studentID, int courseID);
	
	public boolean coursePaid(int studentID, int courseID);
	
	public boolean setGrade(int studentID, int courseID);
	
	public boolean removeStudent(int studentID, int courseID);
}
