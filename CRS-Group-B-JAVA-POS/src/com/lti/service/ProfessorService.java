package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	private RegisteredCourseDAOInterface registeredCourseDAO = new RegisteredCourseDAO();

	/**
	 * call courseDAO to set professorId to course
	 * 
	 * @param professorId the professor to apply
	 * @param courseId    the course to teach
	 * @throws CourseNotFoundException if courseId doesn't exits
	 */
	public void applyToCourse(int professorId, int courseId) throws CourseNotFoundException {
		// apply to specific course
		if (courseDAO.viewCourse(courseId).getProf() != 0)
			throw new CourseNotFoundException("This course is already being taught, ID: ", courseId);
		if (courseDAO.viewCourse(courseId).getProf() == professorId)
			throw new CourseNotFoundException("You are already enrolled in this course, ID: ", courseId);
		if (!courseDAO.addProfessorToCourse(courseId, professorId))
			throw new CourseNotFoundException("This course was not found, Id: ", courseId);
	}

	/**
	 * view students that are enrolled in a course
	 * 
	 * @param courseId the course to view
	 * @return Returns a list of students
	 * @throws CourseNotFoundException     if courseId doesn't exits
	 * @throws NoStudentsEnrolledException if there are not students
	 */
	public List<Student> viewStudents(int courseId) throws CourseNotFoundException, NoStudentsEnrolledException {

		List<Student> students = registeredCourseDAO.viewAllStudents(courseId);
		if (courseDAO.viewCourse(courseId) == null)
			throw new CourseNotFoundException("This course was not found, ID: ", courseId);
		if (students.isEmpty())
			throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		return students;

	}

	/**
	 * records a grade of a student of a particular course
	 * 
	 * @param courseId  the course to set the grade
	 * @param studentId the student to set the grade for
	 * @param grade     the grade to record
	 * @throws CourseNotFoundException     if courseId doesn't exits
	 * @throws StudentNotFoundException    if provided studentId doesn't exist
	 * @throws NoStudentsEnrolledException if there are not student
	 */
	public void recordGrade(double grade, int studentId, int courseId)
			throws StudentNotFoundException, CourseNotFoundException, NoStudentsEnrolledException {
		// record grade for student in class
		if (courseDAO.viewCourse(courseId) == null)
			throw new CourseNotFoundException("This course was not found, ID: ", courseId);
		if (registeredCourseDAO.viewAllStudents(courseId).isEmpty())
			throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		if (registeredCourseDAO.setGrade(studentId, courseId, grade))
			throw new StudentNotFoundException("This student was not found, ID: ", studentId);

	}

	/**
	 * returns a professor by providing a username
	 * 
	 * @param username the username of the professor
	 * @return Returns a professor, null if username doesn't exist
	 */
	@Override
	public Professor getProfessorByUsername(String username) {

		return professorDAO.viewProfessor(username);
	}

	/**
	 * calls courseDAO to get courses that a particular professor is teaching
	 * 
	 * @param professorID the id of the professor
	 * @return Returns a list of courses that a professor is teaching
	 */
	@Override
	public List<Course> viewProfessorCourses(int professorId) {
		// TODO Auto-generated method stub
		return courseDAO.viewCoursesByProfessor(professorId);
	}

	/**
	 * gets a map of student to grade calls method courseDAO
	 * 
	 * @param courseId    the id of the course
	 * @param professorId the id of the professor
	 * @return Returns a map of student to grade
	 * @throws CourseNotFoundException     if courseId doesn't exist
	 * @throws NoStudentsEnrolledException if there
	 */
	@Override
	public Map<Student, Double> viewStudentsGrades(int professorId, int courseId)
			throws CourseNotFoundException, NoStudentsEnrolledException {
		List<Course> courses = courseDAO.viewCoursesByProfessor(professorId);
		/*
		 * int i = 0; for (Course c : courses) { if (c.getCourseID() != courseId) i++; }
		 * if (i == courses.size())
		 */
		List<Course> result = courseDAO.viewCoursesByProfessor(professorId).stream()
				.filter(c -> c.getCourseID() == courseId).collect(Collectors.toList());
		if (result.isEmpty())
			throw new CourseNotFoundException("You are not enrolled in this course, ID: ", courseId);
		if (courseDAO.viewCourse(courseId) == null)
			throw new CourseNotFoundException("This course was not found, ID: ", courseId);
		Map<Student, Double> studentsAndGrades = registeredCourseDAO.viewStudentsAndGrades(courseId);
		if (studentsAndGrades.isEmpty())
			throw new NoStudentsEnrolledException("This course has no students, ID: ", courseId);
		return studentsAndGrades;

	}

}
