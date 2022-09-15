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
	private Collection<Course> registeredCourses;
	private Collection<Course> alternateCourses;
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
	public Collection<Course> getRegisteredCourses() {
		return registeredCourses;
	}
	/**
	 * @param registeredCourses the registeredCourses to set
	 */
	public void setRegisteredCourses(Collection<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	/**
	 * @return the alternateCourses
	 */
	public Collection<Course> getAlternateCourses() {
		return alternateCourses;
	}
	/**
	 * @param alternateCourses the alternateCourses to set
	 */
	public void setAlternateCourses(Collection<Course> alternateCourses) {
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
