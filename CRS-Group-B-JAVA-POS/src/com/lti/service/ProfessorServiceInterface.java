package com.lti.service;
//professor service interface

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lti.bean.*;

public interface ProfessorServiceInterface {
	
	public void applyToCourse(int professorId, int courseId);
	
	public void recordGrade(double grade, int studentId, int courseId);
	
	public List<Student> viewStudents(int courseId);
	
	public Professor getProfessorByUsername(String username);
	
	public List<Course> viewProfessorCourses(int professorId);
	
	public Map<Student, Double> viewStudentsGrades(int courseId);

}
