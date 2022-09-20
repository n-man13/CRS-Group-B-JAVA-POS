package com.lti.bean;

import java.util.*;

/**
 * Course: Id, Students, professor, department, prerequisites
 * @author Nikhil, Luca
 *
 */
public class Course {
	private int courseID;
	private String name;
	private ArrayList<Student> students;
	private Professor prof;
	private String department;
	private String description;
	private int prereqCourseID;
	private Map<Student, Double> studentGrades;
	/**
	 * 
	 * @param courseID
	 */
	public Course(int courseID) {
		this.courseID = courseID;
	}
	
	public Course(int courseID, String name, String department, int prereqCourseID) {
		this.courseID = courseID;
		this.name = name;
		this.department = department;
		this.prereqCourseID = prereqCourseID;
		
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
	 * @return the students
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(ArrayList<Student> students) {
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

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", students=" + students + ", prof=" + prof + ", department="
				+ department + ", prereqCourseID=" + prereqCourseID + "]";
	}

	public Map<Student, Double> getStudentGrades() {
		return studentGrades;
	}

	public void setStudentGrades(Map<Student, Double> studentGrades) {
		this.studentGrades = studentGrades;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
