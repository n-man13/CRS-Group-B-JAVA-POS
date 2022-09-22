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
	
	/**
	 * call courseDAO to set professorId to course
	 * @param int professorid, int courseid
	 * thorws CourseNotFoundException if courseId doesn't exits
	 */	
	public void applyToCourse(int professorId, int courseId) throws CourseNotFoundException{
		// apply to specific course

		if (!courseDAO.addProfessorToCourse(courseId, professorId)) 
			throw new CourseNotFoundException("This course was not found, Id: " , courseId);
	}
	
	/**
	 * view students that are enrolled in a course
	 * @param int courseid
	 * @return list of students
	 * thorws CourseNotFoundException if courseId doesn't exits
	 * throws NoStudentsEnrolledException if there are not studens
	 */	
	public List<Student> viewStudents(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException{
		
		List <Student> students = registeredCourseDAO.viewAllStudents(courseId);
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		if (students.isEmpty()) throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		return students;
		
	}
	
	/**
	 * records a grade of a student of a particular course
	 * @param int courseid, studentid, grade
	 * throws CourseNotFoundException if courseId doesn't exits
	 * throws StudentNotFoundException if provided studentId doesn't exist
	 * throws NoStudentsEnrolledException if there are not student
	 */	
	public void recordGrade(double grade, int studentId, int courseId) throws StudentNotFoundException, CourseNotFoundException, NoStudentsEnrolledException{
		// record grade for student in class
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		if (registeredCourseDAO.viewAllStudents(courseId).isEmpty()) throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		if (registeredCourseDAO.setGrade(studentId, courseId, grade)) throw new StudentNotFoundException("This student was not found, ID: " , studentId);

	}
	
	/**
	 * returns a professor by providing a username
	 * @param string username
	 * 
	 */	
	@Override
	public Professor getProfessorByUsername(String username) {
		
		return professorDAO.viewProfessor(username);
	}
	
	/**
	 * returns a list of courses that a professor is teaching
	 * @param professorID
	 * 
	 */	
	@Override
	public List<Course> viewProfessorCourses(int professorId) {
		// TODO Auto-generated method stub
		return courseDAO.viewCoursesByProfessor(professorId);
	}

	/**
	 * returns a map of student to grade 
	 * @param int courseId
	 * throws courseNotFoundException if can't 
	 */	
	@Override
	public Map<Student, Double> viewStudentsGrades(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException{
		
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		Map<Student, Double> studentsAndGrades = registeredCourseDAO.viewStudentsAndGrades(courseId);
		if (studentsAndGrades.isEmpty()) throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		return studentsAndGrades;		
		
	}

}
