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
public interface CourseDAOInterface {
	
	/**
	 * returns all courses in an ArrayList
	 * @return all courses
	 */
	public ArrayList<Course> viewAllCourses();
	
	/**
	 * 
	 * @param course course to create
	 * @return if course was created
	 */
	public boolean createCourse(Course course);
	
	/**
	 * 
	 * @param courseID the course to modify
	 * @param profID the professor to teach
	 * @return if course was updated
	 */
	public boolean addProfessor(int courseID, int profID);
	
	
	/**
	 * 
	 * @param courseID the course to delete
	 * @return the course that was deleted, else null
	 */
	public Course deleteCourse(int courseID);
}
