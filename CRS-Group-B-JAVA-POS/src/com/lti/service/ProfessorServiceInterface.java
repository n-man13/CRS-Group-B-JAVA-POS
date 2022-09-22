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
	
	public void applyToCourse(int professorId, int courseId) throws CourseNotFoundException;
	
	public void recordGrade(double grade, int studentId, int courseId) throws StudentNotFoundException, CourseNotFoundException, NoStudentsEnrolledException;
	
	public List<Student> viewStudents(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException;
	
	public Professor getProfessorByUsername(String username);
	
	public List<Course> viewProfessorCourses(int professorId);
	
	public Map<Student, Double> viewStudentsGrades(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException;

}
