package com.lti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.exception.CourseFullException;
import com.lti.exception.CourseNotFoundException;
import com.lti.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/applyToCourseStudent/{studentID}/{courseID}", method = RequestMethod.PUT)
	public ResponseEntity applyToCourse(@PathVariable int studentID, @PathVariable int courseID) {
		try {
			studentService.applyToCourse(studentID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		} catch (CourseFullException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);

	}

	@RequestMapping(value = "/dropCourse/{studentID}/{courseID}", method = RequestMethod.DELETE)
	public ResponseEntity dropCourse(@PathVariable int studentID, @PathVariable int courseID) {
		try {
			studentService.dropCourse(studentID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/viewAppliedCourses/{studentID}", method = RequestMethod.GET)
	public ResponseEntity viewAppliedCourses(@PathVariable int studentID) {
		studentService.viewAppliedCourses(studentID);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/makePayment/{studentID}/{courseID}", method = RequestMethod.PUT)
	public ResponseEntity makePayment(@PathVariable int studentID, @PathVariable int courseID) {
		try {
			studentService.makePayment(studentID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/checkGrades/{studentID}", method = RequestMethod.GET)
	public ResponseEntity checkGrades(@PathVariable int studentID) {
		studentService.checkGrades(studentID);
		return new ResponseEntity(HttpStatus.OK);
	}
}
