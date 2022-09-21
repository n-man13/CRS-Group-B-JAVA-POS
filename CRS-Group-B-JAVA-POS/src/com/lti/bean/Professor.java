package com.lti.bean;

import java.util.*;

/**
 * 
 * Professor: Id, courses, username, password
 * @author Nikhil, Luca
 *
 */
public class Professor extends User {
	private int profID;
	private String name;
	private ArrayList<Course> courses;
	
	
	
	
	/**
	 * @param profID
	 * @param name
	 */
	public Professor(int profID, String name) {
		super();
		this.name = name;
		courses = new ArrayList<Course>();
	}
	/**
	 * 
	 * @param name
	 */
	public Professor(String name) {
		super();
		this.name = name;
		courses = new ArrayList<Course>();
	}
	
	public Professor() {
		super();
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
