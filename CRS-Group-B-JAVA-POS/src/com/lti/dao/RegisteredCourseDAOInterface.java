/**
 * 
 */
package com.lti.dao;

import java.util.ArrayList;
import java.util.Map;

import com.lti.bean.*;

/**
 * @author user101
 *
 */
public interface RegisteredCourseDAOInterface {
	// view one, view all, create, update, delete
	/**
	 * 
	 * @param studentID the id of the student
	 * @return the courses registered by the student
	 */
	public ArrayList<Course> viewStudentCourses(int studentID);
	/**
	 * 
	 * @param courseID the course to view
	 * @return the students registered to this course
	 */
	public ArrayList<Student> viewAllStudents(int courseID);
	
	/**
	 * Gives a list of all courses yet to be paid
	 * @param studentID the student
	 * @return list of all unpaid courses
	 */
	public ArrayList<Course> viewUnpaidCourses(int studentID);
	
	/**
	 * 
	 * @param courseID the course to look up
	 * @return a map of students to their grades in the specified class
	 */
	public Map<Student, Double> viewStudentsAndGrades(int courseID);
	
	/**
	 * 
	 * @param studentID the student to look at
	 * @return a map of courses to their grades by the student
	 */
	public Map<Course, Double> viewGrades(int studentID);
	
	/**
	 * 
	 * @param studentID the student to add
	 * @param courseID the course to add
	 * @return if the student was registered or not
	 */
	public boolean addStudentRegistration(int studentID, int courseID);
	
	/**
	 * 
	 * @param studentID the id of the student that has paid
	 * @param courseID the course that has benn paid for
	 * @return if the update was successful
	 */
	public boolean payFee(int studentID, int courseID);
	
	/**
	 * 
	 * @param studentID the id of the student
	 * @param courseID the id of the course
	 * @param grade the grade to be added
	 * @return if the grade was set
	 */
	public boolean setGrade(int studentID, int courseID, double grade);
	
	/**
	 * 
	 * @param studentID the student to remove from class
	 * @param courseID the id of the class
	 * @return if the student was removed
	 */
	public boolean removeStudentRegistration(int studentID, int courseID);
}
