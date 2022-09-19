/**
 * 
 */
package com.lti.dao;

import java.util.ArrayList;

import com.lti.bean.*;

/**
 * @author user101
 *
 */
public interface AdminDAOInterface {
	/**
	 * 
	 * @return list of all courses in DB
	 */
	public ArrayList<Course> getAllCourses();
	
	/**
	 * 
	 * @return list of all professors in DB
	 */
	public ArrayList<Professor> getAllProfessors();
	
	/**
	 * 
	 * @return list of all students in DB
	 */
	public ArrayList<Student> getAllStudents();
}
