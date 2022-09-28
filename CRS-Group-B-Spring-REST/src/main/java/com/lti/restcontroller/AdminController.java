package com.lti.restcontroller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.*;
import com.lti.bean.*;
import com.lti.exception.*;

/**
 * createCourse, updateCourse, deleteCourse, createProfessor,
 * approveRegistration
 * 
 * @author Nikhil, Luca
 *
 */
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	CourseService courseService;

	/**
	 * creates a new course
	 * 
	 * @param course the course to create
	 * @return an HTTP response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createCourse")
	public ResponseEntity createCourse(@RequestBody Course course) {

		adminService.createCourse(course);

		return new ResponseEntity(course, HttpStatus.CREATED);
	}

	/**
	 * updates a course with specific id
	 * 
	 * @param course   the updated information
	 * @param courseID the course to update
	 * @return an HTTP response
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/updateCourse/{courseID}")
	public ResponseEntity updateCourse(@RequestBody Course course, @PathVariable int courseID) {

		Course oldCourse = courseService.viewCourseByID(courseID);
		if (oldCourse != null) {
			oldCourse.setDescription(course.getDescription());
			oldCourse.setDepartment(course.getDepartment());
			oldCourse.setName(course.getName());
			oldCourse.setPrereqCourseID(course.getPrereqCourseID());
			try {
				adminService.updateCourse(oldCourse);
				return new ResponseEntity(oldCourse, HttpStatus.OK);
			} catch (CourseNotFoundException e) {
				return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity(courseID, HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * deletes a course
	 * 
	 * @param courseID the course
	 * @return an HTTP response whether deleted
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteCourse/{courseID}")
	public ResponseEntity deleteCourse(@PathVariable int courseID) {

		try {
			adminService.deleteCourse(courseID);
			return new ResponseEntity(courseID, HttpStatus.OK);
		} catch (CourseNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getCourseID(), HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * creates a professor and sets the username and password
	 * 
	 * @param professor the professor to create
	 * @return an HTTP response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createProfessor")
	public ResponseEntity createProfessor(@RequestBody Professor professor) {

		try {
			adminService.createProfessor(professor);
			return new ResponseEntity(professor, HttpStatus.CREATED);
		} catch (UsernameUsedException e) {
			return new ResponseEntity(e.getMessage() + e.getUsername(), HttpStatus.I_AM_A_TEAPOT);
		}

	}

	/**
	 * Approves a student's registration
	 * 
	 * @param studentID the student to registered
	 * @return an HTTP response
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/approveRegistration/{studentID}")
	public ResponseEntity approveRegistration(@PathVariable int studentID) {
		try {
			Student student = adminService.getStudentById(studentID);
			try {
				adminService.approveStudentRegistration(student);
				return new ResponseEntity(student, HttpStatus.CREATED);
			} catch (StudentNotFoundException e) {
				return new ResponseEntity(e.getMessage() + e.getStudentID(), HttpStatus.NOT_FOUND);
			}
		} catch (StudentNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getStudentID(), HttpStatus.NOT_FOUND);
		}

	}
}
