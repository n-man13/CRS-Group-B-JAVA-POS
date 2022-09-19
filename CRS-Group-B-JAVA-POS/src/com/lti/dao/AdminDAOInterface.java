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
	 * @param course course to create
	 * @return if course created successfully
	 */
	public boolean createCourse(Course course);
	
	/**
	 * 
	 * @param course course to update
	 * @return if course updated successfully
	 */
	public boolean updateCourse(Course course);
	
	/**
	 * 
	 * @param course course to create
	 * @return course deleted successfully, else null
	 */
	public Course deleteCourse(Course course);
	
	/**
	 * 
	 * @return list of all courses in DB
	 */
	public ArrayList<Course> listAllCourses();
	
	
}
