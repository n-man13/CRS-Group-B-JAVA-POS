package com.lti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.UsernameUsedException;
import com.lti.service.StudentService;
import com.lti.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method = RequestMethod.POST, value="/login")
	public ResponseEntity login(@RequestBody User user) {
		if (user == null)
			return new ResponseEntity("User information not provided", HttpStatus.NOT_FOUND);
		try {
			userService.verifyCredetials(user.getUsername(), user.getPassword(), user.getRole());
		} catch (StudentNotFoundException e) {
			return new ResponseEntity(e.getMessage() + e.getStudentID(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/studentRegistration", method = RequestMethod.POST)
	public ResponseEntity studentRegistration(@RequestBody Student student) {
		if (student == null)
			return new ResponseEntity("New Student information not provided", HttpStatus.NOT_FOUND);
		try {
			studentService.createStudent(student);
		} catch (UsernameUsedException e) {
			return new ResponseEntity(e.getMessage() + e.getUsername(), HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ResponseEntity updatePassword(@RequestBody User user) {
		if (user == null)
			return new ResponseEntity("User information not provided", HttpStatus.NOT_FOUND);
		userService.updatePassword(user.getUsername(), user.getPassword());
		return new ResponseEntity(HttpStatus.OK);
	}
}
