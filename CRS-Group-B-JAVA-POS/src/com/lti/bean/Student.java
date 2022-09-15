package com.lti.bean;

import java.util.Collection;
/**
 * 
 * Student: Id, courses, alternateCourses, gradeCourses, username, password
 * @author Nikhil, Luca
 *
 */
public class Student {
	
	private int studentID;
	private Collection registeredCourses;
	private Collection alternateCourses;
	private Collection grades; //move elsewhere in the future
	
	
	
	
	/**
	 * @param studentID ID number of the student
	 * 
	 */
	public Student(int studentID) {
		this.studentID = studentID;
		
	}
	/**
	 * @return the registeredCourses
	 */
	public Collection getRegisteredCourses() {
		return registeredCourses;
	}
	/**
	 * @param registeredCourses the registeredCourses to set
	 */
	public void setRegisteredCourses(Collection registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	/**
	 * @return the alternateCourses
	 */
	public Collection getAlternateCourses() {
		return alternateCourses;
	}
	/**
	 * @param alternateCourses the alternateCourses to set
	 */
	public void setAlternateCourses(Collection alternateCourses) {
		this.alternateCourses = alternateCourses;
	}
	/**
	 * @return the iD
	 */
	public int getStudentID() {
		return studentID;
	}
	/**
	 * @return the grades
	 */
	public Collection getGrades() {
		return grades;
	}
	
	

}
