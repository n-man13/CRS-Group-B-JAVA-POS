package com.lti.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.Student;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.NoStudentsEnrolledException;
import com.lti.exception.StudentNotFoundException;
import com.lti.service.ProfessorService;

/**
 * applyToCourseProfessor, recordGrade, viewStudents
 * 
 * @author Nikhil, Luca
 *
 */
@RestController
public class ProfessorController {

	Logger logger = LoggerFactory.getLogger(ProfessorController.class);
	
	@Autowired
	ProfessorService professorService;

	/**
	 * Adds the professor to the course
	 * 
	 * @param courseID    the course
	 * @param professorID the professor to add
	 * @return a response whether the professor was added
	 */
	@RequestMapping(value = "/applyToCourseProfessor/{courseID}/{professorID}", method = RequestMethod.PUT)
	public ResponseEntity applyToCourse(@PathVariable int courseID, @PathVariable int professorID) {
		logger.info("applyToCourse in ProfessorController");
		
		try {
			professorService.applyToCourse(professorID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity("Course not found with id " + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * Records a grade for a student in a course
	 * 
	 * @param courseID  the course
	 * @param studentID the student
	 * @param grade     the grade to record
	 * @return an HTTP response
	 */
	@RequestMapping(value = "/recordGrade/{courseID}/{studentID}/{grade}", method = RequestMethod.PUT)
	public ResponseEntity recordGrade(@PathVariable int courseID, @PathVariable int studentID,
			@PathVariable double grade) {
		logger.info("recordGrade in ProfessorController");
		try {
			professorService.recordGrade(grade, studentID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		} catch (StudentNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getStudentID(), HttpStatus.NOT_FOUND);
		} catch (NoStudentsEnrolledException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * returns a list of students registered to a course
	 * 
	 * @param courseID the course
	 * @return an HTTP response
	 */
	@RequestMapping(value = "/viewStudents/{courseID}", method = RequestMethod.GET)
	public ResponseEntity viewStudents(@PathVariable int courseID) {
		logger.info("viewStudents in ProfessorController");
		try {
			List<Student> students = professorService.viewStudents(courseID);
			return new ResponseEntity(students, HttpStatus.OK);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		} catch (NoStudentsEnrolledException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}

	}
}
