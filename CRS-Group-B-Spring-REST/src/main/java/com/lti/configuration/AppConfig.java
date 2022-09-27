package com.lti.configuration;

import org.springframework.context.annotation.Bean;

import com.lti.service.*;


public class AppConfig {
	
	@Bean(name="AdminService")
	public AdminServiceInterface adminService() {
		return new AdminService();
	}
	
	@Bean(name="ProfessorService")
	public ProfessorServiceInterface professorService() {
		return new ProfessorService();
	}
	
	@Bean(name="StudentService")
	public StudentServiceInterface studentService() {
		return new StudentService();
	}
	
	@Bean(name="UserService")
	public UserServiceInterface userService() {
		return new UserService();
	}
	
	
	
}
