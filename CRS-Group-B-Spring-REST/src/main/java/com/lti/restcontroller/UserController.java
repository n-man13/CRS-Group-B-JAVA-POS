package com.lti.restcontroller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping(value="/login/{username}/{password}/{role}")
	public boolean login(@PathVariable String username, @PathVariable String password, @PathVariable int role) {
		
		return false;
	}
}
