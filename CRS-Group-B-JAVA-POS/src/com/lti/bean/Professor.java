package com.lti.bean;

import java.util.*;

/**
 * 
 * Professor: Id, courses, username, password
 * @author Nikhil, Luca
 *
 */
public class Professor {
	private int profID;
	private ArrayList<Course> courses;
	
	
	
	
	/**
	 * @param profID
	 */
	public Professor(int profID) {
		super();
		this.profID = profID;
		courses = new ArrayList<Course>();
	}
	/**
	 * @return the courses
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	/**
	 * @return the profID
	 */
	public int getProfID() {
		return profID;
	}
	
	
}
