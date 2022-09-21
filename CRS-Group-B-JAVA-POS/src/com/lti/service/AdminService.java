package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.dao.AdminDAO;
import com.lti.dao.AdminDAOInterface;
import com.lti.dao.CourseDAO;
import com.lti.dao.CourseDAOInterface;
import com.lti.dao.ProfessorDAO;
import com.lti.dao.ProfessorDAOInterface;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOInterface;

public class AdminService implements AdminServiceInterface{
	
	private CourseDAOInterface courseDAO = new CourseDAO();
	private ProfessorDAOInterface professorDAO = new ProfessorDAO();
	private StudentDAOInterface studentDAO = new StudentDAO();
	private AdminDAOInterface adminDAO = new AdminDAO();
	
	@Override
	public void createCourse(Course course) {
		
		courseDAO.createCourse(course);
		
	}
	@Override
	public void createProfessor(Professor professor) {
		// TODO Auto-generated method stub
		professorDAO.createProfessor(professor);
	}
	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDAO.updateCourse(course);
	}
	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		courseDAO.deleteCourse(courseId);
	}
	@Override
	public void listAllCourse() {
		// TODO Auto-generated method stub
		courseDAO.viewAllCourses();
	}
	@Override
	public void approveStudentRegistration(Student student) {
		
		student.setRegistered(true);
		studentDAO.updateStudent(student);
		// TODO Auto-generated method stub
		
	}
	@Override
	public Admin getAdminByUsername(String username) {
		return null;
		
	}
	@Override
	public List<Student> unregisteredStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Student getStudentById(int stuedentId) {
		return studentDAO.viewStudent(stuedentId);
	}
	
	
	
	
	
}
