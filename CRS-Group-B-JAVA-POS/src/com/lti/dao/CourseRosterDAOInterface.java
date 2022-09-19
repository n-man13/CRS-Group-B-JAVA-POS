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
	public ArrayList<Course> viewAllCourses(Student student);
	
	public ArrayList<Student> viewAllStudents(Course course);
	
	public ArrayList<Course> viewAllPaidCourses(Student student);
	
	public Map<Course, Double> viewGrades(Student student);
	
	public boolean addStudent(Student student, Course course, boolean paid);
	
	public boolean coursePaid(Student student, Course course);
	
	public boolean setGrade(Student student, Course course);
	
	public boolean removeStudent(Student student, Course course);
}
