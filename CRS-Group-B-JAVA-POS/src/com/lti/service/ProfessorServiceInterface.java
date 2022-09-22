package com.lti.service;
//professor service interface

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lti.bean.*;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.NoStudentsEnrolledException;
import com.lti.exception.StudentNotFoundException;

public interface ProfessorServiceInterface {
	
	/**
	 * call courseDAO to set professorId to course
	 * @param int professorid, int courseid
	 * thorws CourseNotFoundException if courseId doesn't exits
	 */	
	public void applyToCourse(int professorId, int courseId) throws CourseNotFoundException;
	
	/**
	 * records a grade of a student of a particular course
	 * @param int courseid, studentid, grade
	 * throws CourseNotFoundException if courseId doesn't exits
	 * throws StudentNotFoundException if provided studentId doesn't exist
	 * throws NoStudentsEnrolledException if there are not student
	 */	
	public void recordGrade(double grade, int studentId, int courseId) throws StudentNotFoundException, CourseNotFoundException, NoStudentsEnrolledException;
	
	/**
	 * view students that are enrolled in a course
	 * @param int courseid
	 * @return list of students
	 * thorws CourseNotFoundException if courseId doesn't exits
	 * throws NoStudentsEnrolledException if there are not studens
	 */	
	public List<Student> viewStudents(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException;
	
	/**
	 * returns a professor by providing a username
	 * @param string username
	 * 
	 */	
	public Professor getProfessorByUsername(String username);
	
	/**
	 * returns a list of courses that a professor is teaching
	 * @param professorID
	 * 
	 */	
	public List<Course> viewProfessorCourses(int professorId);
	
	/**
	 * gets a map of student to grade calls method courseDAO 
	 * @param int courseId
	 * @return map of student to grade 
	 * throws courseNotFoundException if courseId doesn't exist
	 * throws NoStudentsEnrolledException if there 
	 */	
	public Map<Student, Double> viewStudentsGrades(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException;

}
