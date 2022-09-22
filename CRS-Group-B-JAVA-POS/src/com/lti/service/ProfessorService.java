package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lti.bean.*;
import com.lti.dao.CourseDAO;
import com.lti.dao.CourseDAOInterface;
import com.lti.dao.ProfessorDAO;
import com.lti.dao.ProfessorDAOInterface;
import com.lti.dao.RegisteredCourseDAO;
import com.lti.dao.RegisteredCourseDAOInterface;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.StudentNotFoundException;

public class ProfessorService implements ProfessorServiceInterface {
	
	private ProfessorDAOInterface professorDAO = new ProfessorDAO();
	private CourseDAOInterface courseDAO = new CourseDAO();
	private RegisteredCourseDAOInterface registeredCourseDAO =  new RegisteredCourseDAO();
	
	public void applyToCourse(int professorId, int courseId) throws CourseNotFoundException{
		// apply to specific course
		courseDAO.addProfessorToCourse(courseId, professorId);
	}

	public List<Student> viewStudents(int courseId) throws CourseNotFoundException{
		
		return registeredCourseDAO.viewAllStudents(courseId);
		
	}

	public void recordGrade(double grade, int studentId, int courseId) throws StudentNotFoundException, CourseNotFoundException{
		// record grade for student in class
		registeredCourseDAO.setGrade(studentId, courseId, grade);

	}

	@Override
	public Professor getProfessorByUsername(String username) {
		
		return professorDAO.viewProfessor(username);
	}

	@Override
	public List<Course> viewProfessorCourses(int professorId) {
		// TODO Auto-generated method stub
		return courseDAO.viewCoursesByProfessor(professorId);
	}

	@Override
	public Map<Student, Double> viewStudentsGrades(int courseId) {
		
		return registeredCourseDAO.viewStudentsAndGrades(courseId);
				
		
	}

}
