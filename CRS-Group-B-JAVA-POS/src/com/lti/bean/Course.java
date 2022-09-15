package com.lti.bean;

import java.util.Collection;

/**
 * Course: Id, Students, professor, department, prerequisites
 * @author Nikhil, Luca
 *
 */
public class Course {
	private int courseID;
	private Collection students;
	private Professor prof;
	private String department;
	private int prereqCourseID;
	
	/**
	 * 
	 * @param courseID
	 */
	public Course(int courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return courseID;
	}
	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	/**
	 * @return the students
	 */
	public Collection getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(Collection students) {
		this.students = students;
	}
	/**
	 * @return the prof
	 */
	public Professor getProf() {
		return prof;
	}
	/**
	 * @param prof the prof to set
	 */
	public void setProf(Professor prof) {
		this.prof = prof;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the prereqCourseID
	 */
	public int getPrereqCourseID() {
		return prereqCourseID;
	}
	/**
	 * @param prereqCourseID the prereqCourseID to set
	 */
	public void setPrereqCourseID(int prereqCourseID) {
		this.prereqCourseID = prereqCourseID;
	}
	
	
}
