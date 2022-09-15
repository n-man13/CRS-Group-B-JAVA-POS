package com.lti.bean;

import java.util.Collection;

/**
 * 
 * Professor: Id, courses, username, password
 * @author Nikhil, Luca
 *
 */
public class Professor {
	private int profID;
	private Collection<Course> courses;
	
	
	/**
	 * @return the courses
	 */
	public Collection<Course> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}
	/**
	 * @return the profID
	 */
	public int getProfID() {
		return profID;
	}
	
	
}
