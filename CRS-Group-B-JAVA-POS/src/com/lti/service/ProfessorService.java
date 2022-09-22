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
import com.lti.exception.NoStudentsEnrolledException;
import com.lti.exception.StudentNotFoundException;

public class ProfessorService implements ProfessorServiceInterface {
	
	private ProfessorDAOInterface professorDAO = new ProfessorDAO();
	private CourseDAOInterface courseDAO = new CourseDAO();
	private RegisteredCourseDAOInterface registeredCourseDAO =  new RegisteredCourseDAO();
	
	public void applyToCourse(int professorId, int courseId) throws CourseNotFoundException{
		// apply to specific course

		if (!courseDAO.addProfessorToCourse(courseId, professorId)) 
			throw new CourseNotFoundException("This course was not found, Id: " , courseId);
	}

	public List<Student> viewStudents(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException{
		
		List <Student> students = registeredCourseDAO.viewAllStudents(courseId);
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		if (students.isEmpty()) throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		return students;
		
	}

	public void recordGrade(double grade, int studentId, int courseId) throws StudentNotFoundException, CourseNotFoundException, NoStudentsEnrolledException{
		// record grade for student in class
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		if (registeredCourseDAO.viewAllStudents(courseId).isEmpty()) throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		if (registeredCourseDAO.setGrade(studentId, courseId, grade)) throw new StudentNotFoundException("This student was not found, ID: " , studentId);

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
	public Map<Student, Double> viewStudentsGrades(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException{
		
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		Map<Student, Double> studentsAndGrades = registeredCourseDAO.viewStudentsAndGrades(courseId);
		if (studentsAndGrades.isEmpty()) throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		return studentsAndGrades;		
		
	}

}
