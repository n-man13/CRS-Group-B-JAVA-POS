package com.lti.restcontroller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.Course;
import com.lti.exception.CourseFullException;
import com.lti.exception.CourseNotFoundException;
import com.lti.service.StudentService;
import com.lti.bean.*;

@RestController
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;
	
	/**
	 * Method to applyToCourseStudent
	 * 
	 * @param user the user that resets the password
	 * @return ResponseEntity the ResponseEntity if the login is successful or not
	 */
	@RequestMapping(value = "/applyToCourseStudent/{studentID}/{courseID}", method = RequestMethod.PUT)
	public ResponseEntity applyToCourse(@PathVariable int studentID, @PathVariable int courseID) {
		logger.info("applayToCourse in StudentController");
		try {
			studentService.applyToCourse(studentID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		} catch (CourseFullException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);

	}
	
	/**
	 * Method to dropCourse
	 * 
	 * @param studentID the ID of the student
	 * @param courseID the id of the course
	 * @return ResponseEntity the ResponseEntity if dropping the course is successful or not
	 */
	@RequestMapping(value = "/dropCourse/{studentID}/{courseID}", method = RequestMethod.DELETE)
	public ResponseEntity dropCourse(@PathVariable int studentID, @PathVariable int courseID) {
		logger.info("dropCourse in StudentController");
		try {
			studentService.dropCourse(studentID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * Method to viewAppliedCoures for a student
	 * 
	 * @param studentID the ID of the student
	 * @return ResponseEntity the ResponseEntity if viewAppiedCourses is successful
	 */
	@RequestMapping(value = "/viewAppliedCourses/{studentID}", method = RequestMethod.GET)
	public ResponseEntity viewAppliedCourses(@PathVariable int studentID) {
		logger.info("viewAppliedCourses in StudentController");
		displayCourses(studentService.viewAppliedCourses(studentID));
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * Method to makePayment
	 * 
	 * @param studentID the ID of the student
	 * @param courseID the id of the course
	 * @return ResponseEntity the ResponseEntity if the login is successful or not
	 */
	@RequestMapping(value = "/makePayment/{studentID}/{courseID}", method = RequestMethod.PUT)
	public ResponseEntity makePayment(@PathVariable int studentID, @PathVariable int courseID) {
		logger.info("makePayment in StudentController");
		try {
			studentService.makePayment(studentID, courseID);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * Method to checkGrades
	 * 
	 * @param studentID the ID of the student
	 * @return ResponseEntity the ResponseEntity if the login is successful or not
	 */
	@RequestMapping(value = "/checkGrades/{studentID}", method = RequestMethod.GET)
	public Map<Course, Double> checkGrades(@PathVariable int studentID) {
		logger.info("makePayment in StudentController");
		logger.debug("Map students to grade " + studentService.checkGrades(studentID));
		return studentService.checkGrades(studentID);
		//return new ResponseEntity(HttpStatus.OK);
	}
	
	/**
	 * Method to display courses
	 * 
	 * @param courses a lit of Course
	 */
	private void displayCourses(List<Course> courses) {
		System.out.println(
				"CourseID \t Course Name \t Department \t Description \t\t Professor \t Prerequisite CourseID");
		for (Course c : courses) {
			if (c.getProf() != null)
				System.out.println(c.getCourseID() + "\t\t" + c.getName() + "\t" + c.getDepartment() + "\t\t"
						+ c.getDescription() + "\t" + c.getProf().getName() + "\t" + c.getPrereqCourseID());
			else
				System.out.println(c.getCourseID() + "\t\t" + c.getName() + "\t" + c.getDepartment() + "\t\t"
						+ c.getDescription() + "\t" + "No Professor" + "\t" + c.getPrereqCourseID());
		}
	}
}
