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




@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/createCourse")
	public ResponseEntity createCourse(@RequestBody Course course) {
		
		adminService.createCourse(course);
		
		return new ResponseEntity(course, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateCourse/{id}")
	public ResponseEntity updateCourse(@RequestBody Course course, @PathVariable int courseID) {
		
		Course oldCourse = courseService.viewCourseByID(courseID);
		if(oldCourse != null) {
			oldCourse.setDescription(course.getDescription());
			oldCourse.setDepartment(course.getDepartment());
			oldCourse.setName(course.getName());
			oldCourse.setPrereqCourseID(course.getPrereqCourseID());
		}
		adminService.updateCourse(oldCourse);
		
		return new ResponseEntity(course, HttpStatus.OK);
	}
}
