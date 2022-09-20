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
	private String name;
	private ArrayList<Course> registeredCourses = new ArrayList<Course>();
	private ArrayList<Course> alternateCourses = new ArrayList<Course>();
	private ArrayList<Double> grades = new ArrayList<Double>(); //move elsewhere in the future
	private boolean registered = false;
	private int coursesPaid = 0;
	
	
	
	/**
	 * @param studentID ID number of the student
	 * 
	 */
	public Student(int studentID) {
		this.studentID = studentID;
		
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
	/**
	 * @return the registered
	 */
	public boolean isRegistered() {
		return registered;
	}
	/**
	 * @param registered the registered to set
	 */
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	/**
	 * @return the coursesPaid
	 */
	public int getCoursesPaid() {
		return coursesPaid;
	}
	/**
	 * @param coursesPaid the coursesPaid to set
	 */
	public void setCoursesPaid(int coursesPaid) {
		this.coursesPaid = coursesPaid;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", registeredCourses=" + registeredCourses + ", alternateCourses="
				+ alternateCourses + ", grades=" + grades + "]";
	}
	
	

}
