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
import com.lti.dao.UserDAOInterface;
import com.lti.dao.UserDAO;
import com.lti.exception.AllStudentRegisteredException;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.UsernameUsedException;

public class AdminService implements AdminServiceInterface {
	
	private CourseDAOInterface courseDAO = new CourseDAO();
	private ProfessorDAOInterface professorDAO = new ProfessorDAO();
	private StudentDAOInterface studentDAO = new StudentDAO();
	private AdminDAOInterface adminDAO = new AdminDAO();
	private UserDAOInterface userDAO = new UserDAO();
	
	@Override
	public void createCourse(Course course) {
		
		courseDAO.createCourse(course);
		
	}
	@Override
	public void createProfessor(Professor professor) throws UsernameUsedException{
		// TODO Auto-generated method stub
		if (userDAO.viewUser(professor.getUsername()) != null) throw new UsernameUsedException("Username already taken, username: ", professor.getUsername());
		professorDAO.createProfessor(professor);
	}
	@Override
	public void updateCourse(Course course) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		if (courseDAO.viewCourse(course.getCourseID()) == null) throw new CourseNotFoundException("This course was not found, ID: " , course.getCourseID());
		courseDAO.updateCourse(course);
	}
	@Override
	public void deleteCourse(int courseId) throws CourseNotFoundException{
		// TODO Auto-generated method stub
		if (courseDAO.viewCourse(courseId) == null) throw new CourseNotFoundException("This course was not found, ID: " , courseId);
		courseDAO.deleteCourse(courseId);
	}
	@Override
	public void listAllCourse() {
		// TODO Auto-generated method stub
		courseDAO.viewAllCourses();
	}
	@Override
	public void approveStudentRegistration(Student student) throws StudentNotFoundException {
		
		if (studentDAO.viewStudent(student.getStudentID()) == null) throw new StudentNotFoundException("This student was not found, ID: " , student.getStudentID());
		student.setRegistered(true);
		studentDAO.updateStudent(student);
		// TODO Auto-generated method stub
		
	}
	@Override
	public Admin getAdminByUsername(String username) {
		return adminDAO.viewAdmin(username);
		
	}
	@Override
	public List<Student> unregisteredStudent() throws AllStudentRegisteredException{
		// TODO Auto-generated method stub
		
		List<Student> students = studentDAO.viewUnregisteredStudents();
		if (students.isEmpty()) throw new AllStudentRegisteredException("There are no students to be registered");
		return students;
	}
	@Override
	public Student getStudentById(int studentId) {
		return studentDAO.viewStudent(studentId);
	}
	
	
	
	
	
}
