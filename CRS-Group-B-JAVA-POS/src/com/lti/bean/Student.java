package com.lti.bean;

import java.util.*;
/**
 * 
 * Student: Id, courses, alternateCourses, gradeCourses, username, password
 * @author Nikhil, Luca
 *
 */
public class Student extends User {
	
	private int studentID;
	private ArrayList<Course> registeredCourses = new ArrayList<Course>();
	private ArrayList<Course> alternateCourses = new ArrayList<Course>();
	private ArrayList<Double> grades = new ArrayList<Double>(); //move elsewhere in the future
	
	
	
	
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
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", registeredCourses=" + registeredCourses + ", alternateCourses="
				+ alternateCourses + ", grades=" + grades + "]";
	}
	
	

}
