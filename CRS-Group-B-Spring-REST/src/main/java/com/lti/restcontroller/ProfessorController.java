package com.lti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.exception.CourseNotFoundException;
import com.lti.exception.NoStudentsEnrolledException;
import com.lti.exception.StudentNotFoundException;
import com.lti.service.ProfessorService;



@RestController
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	
	@RequestMapping(value = "/applyToCourseProfessor/{courseID}/{professorID}", method = RequestMethod.PUT)
	public ResponseEntity applyToCourse(@PathVariable int courseID, @PathVariable int professorID) {

		try {
			professorService.applyToCourse(professorID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity("Course not found with id " + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/recordGrade/{courseID}/{studentID}/{grade}", method = RequestMethod.PUT)
	public ResponseEntity recordGrade(@PathVariable int courseID, @PathVariable int studentID, @PathVariable double grade) {
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
	
	@RequestMapping(value = "/viewStudents/{courseID}", method = RequestMethod.GET)
	public ResponseEntity viewStudents(@PathVariable int courseID) {
		try {
			professorService.viewStudents(courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		} catch (NoStudentsEnrolledException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
