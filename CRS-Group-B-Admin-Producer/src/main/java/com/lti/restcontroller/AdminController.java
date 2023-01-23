package com.lti.restcontroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lti.service.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.document.BasicDataDocument;
import com.lti.dto.*;
import com.lti.exception.*;
import com.lti.repo.BasicDataDocumentRepo;

/**
 * createCourse, updateCourse, deleteCourse, createProfessor,
 * approveRegistration
 * 
 * @author Nikhil, Luca
 *
 */
@RestController
@CrossOrigin
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	AdminService adminService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	BasicDataDocumentRepo repo;

	// @Autowired
	// MongoTemplate mongoTemplate;

	/**
	 * creates a new course
	 * 
	 * @param course the course to create
	 * @return an HTTP response
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createCourse")
	public ResponseEntity<?> createCourse(@RequestBody Course course) {

		adminService.createCourse(course);
		logger.info("createCourse in AdminController");
		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/viewAllCourses")
	public ResponseEntity<?> viewAllCourses() {
		return new ResponseEntity<>(adminService.listAllCourse(), HttpStatus.OK);
	}

	/**
	 * updates a course with specific id
	 * 
	 * @param course   the updated information
	 * @param courseID the course to update
	 * @return an HTTP response
	 * @throws CourseNotFoundException if course was not found
	 */
	@ExceptionHandler(CourseNotFoundException.class)
	@RequestMapping(method = RequestMethod.PUT, value = "/updateCourse/{courseID}")
	public ResponseEntity<?> updateCourse(@RequestBody Course course, @PathVariable int courseID)
			throws CourseNotFoundException {
		logger.info("updateCourse in AdminController");

		Course oldCourse = adminService.getCourseByID(courseID);
		if (oldCourse != null) {
			oldCourse.setDescription(course.getDescription());
			oldCourse.setDepartment(course.getDepartment());
			oldCourse.setName(course.getName());
			oldCourse.setPrereqCourseID(course.getPrereqCourseID());

			adminService.updateCourse(oldCourse);
			return new ResponseEntity<>(oldCourse, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(courseID, HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * deletes a course
	 * 
	 * @param courseID the course
	 * @return an HTTP response whether deleted
	 * @throws CourseNotFoundException if course is not found
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteCourse/{courseID}")
	public ResponseEntity<?> deleteCourse(@PathVariable int courseID) throws CourseNotFoundException {
		logger.info("deleteCourse in AdminController");

		adminService.deleteCourse(courseID);
		return new ResponseEntity<>(courseID, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/viewProfessors")
	public ResponseEntity<?> viewProfessors() {
		return new ResponseEntity<>(adminService.viewProfessors(), HttpStatus.OK);
	}

	/**
	 * creates a professor and sets the username and password
	 * 
	 * @param professor the professor to create
	 * @return an HTTP response
	 * @throws UsernameUsedException if the username is already in use
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createProfessor")
	public ResponseEntity<?> createProfessor(@RequestBody Professor professor) throws UsernameUsedException {
		logger.info("createProfessor in AdminController");

		adminService.createProfessor(professor);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/viewUnapprovedStudents")
	public ResponseEntity<?> viewUnapprovedStudents() throws AllStudentRegisteredException {
		return new ResponseEntity<>(adminService.unregisteredStudent(), HttpStatus.OK);
	}

	/**
	 * Approves a student's registration
	 * 
	 * @param studentID the student to registered
	 * @return an HTTP response
	 * @throws StudentNotFoundException if the student is not found
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/approveRegistration/{studentID}")
	public ResponseEntity<?> approveRegistration(@PathVariable int studentID) throws StudentNotFoundException {
		logger.info("approveRegistration in AdminController");

		Student student = adminService.getStudentById(studentID);

		adminService.approveStudentRegistration(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/rejectRegistration/{studentID}")
	public ResponseEntity<?> rejectRegistration(@PathVariable int studentID) {
		adminService.deleteStudent(studentID);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getClientData/{clientID}")
	public ResponseEntity<?> getClientData(@PathVariable String clientID) throws FileNotFoundException {
		List<ClientDetail> clientDetails = new ArrayList<>();

		InputStream stream = getClass().getClassLoader().getResourceAsStream("ClientDetails.config.json");
		ObjectMapper map = new ObjectMapper();

		try {
			clientDetails = map.readValue(stream, new TypeReference<List<ClientDetail>>() {

			});
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		for (ClientDetail c : clientDetails){
			if(c.getClientID().equalsIgnoreCase(clientID)){
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				HttpEntity<ClientDetail> entity = new HttpEntity<>(c, headers);
				restTemplate.exchange("http://localhost:8094/logClientData", HttpMethod.POST, entity, String.class);
				return new ResponseEntity<>(c, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(clientID, HttpStatus.NOT_FOUND);
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/submitInfo")
	public ResponseEntity<?> submitInfo(@RequestBody BasicDataDocument data){
		System.out.println(data);
		//TODO once I figure out how to save to Mongo
		repo.save(data);
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/searchInfo")
	public ResponseEntity<?> searchInfo(@RequestBody BasicData data){
		// todo once I figure out how to query Mongo
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
