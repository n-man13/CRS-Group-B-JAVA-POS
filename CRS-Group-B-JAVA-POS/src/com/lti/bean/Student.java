package com.lti.bean;

import java.util.*;
/**
 * 
 * Student: Id, courses, alternateCourses, gradeCourses, username, password
 * @author Nikhil, Luca
 *
 */
public class Student {
	
	private int studentID;
	private ArrayList<Course> registeredCourses;
	private ArrayList<Course> alternateCourses;
	private ArrayList<Double> grades; //move elsewhere in the future
	
	
	
	
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
	public ArrayList<Course> getRegisteredCourses() {
		return registeredCourses;
	}
	/**
	 * @param registeredCourses the registeredCourses to set
	 */
	public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	/**
	 * @return the alternateCourses
	 */
	public ArrayList<Course> getAlternateCourses() {
		return alternateCourses;
	}
	/**
	 * @param alternateCourses the alternateCourses to set
	 */
	public void setAlternateCourses(ArrayList<Course> alternateCourses) {
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
	public ArrayList<Double> getGrades() {
		return grades;
	}
	
	

}
