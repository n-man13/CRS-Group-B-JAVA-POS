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
	private Collection courses;
	
	
	/**
	 * @return the courses
	 */
	public Collection getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Collection courses) {
		this.courses = courses;
	}
	/**
	 * @return the profID
	 */
	public int getProfID() {
		return profID;
	}
	
	
}
