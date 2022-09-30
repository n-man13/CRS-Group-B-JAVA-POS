/**
 * 
 */
package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.configuration.JDBCConfiguration;
import com.lti.dto.Student;
import com.lti.dto.User;
import com.lti.mapper.StudentMapper;

/**
 * @author user101
 *
 */
public class StudentDAO implements StudentDAOInterface {

	@Autowired
	private JDBCConfiguration jdbcTemplateObject;
	@Autowired
	private UserDAO userDAO;
	// Queries for Student table
	public static final String STUDENT_INSERT = "INSERT INTO Student(studentID, name, registrationApproved) VALUES(%o,%s,?)";
	public static final String STUDENT_SELECT = "SELECT studentID, name, registrationApproved FROM Student WHERE studentID = ?";
	public static final String STUDENT_SELECT_UNREGISTERED = "SELECT studentID, name, registrationApproved FROM Student WHERE registrationApproved=?";
	public static final String STUDENT_UPDATE = "UPDATE Student SET name=%s, registrationApproved=%b WHERE studentID=%o";

	@Override
	public int createStudent(Student student) {
		int userID = userDAO.createUser(student.getUsername(), student.getPassword(), 3);
		jdbcTemplateObject.jdbcTemplate()
				.execute(String.format(STUDENT_INSERT, userID, student.getName(), student.isRegistered()));
		return userID;
	}

	@Override
	public Student findStudent(String username) {
		User user = userDAO.findUser(username);
		return findStudent(user.getUserID());
	}

	@Override
	public Student findStudent(int studentID) {
		Student student = jdbcTemplateObject.jdbcTemplate().queryForObject(STUDENT_SELECT, new Object[] { studentID },
				new StudentMapper());
		return student;
	}

	@Override
	public boolean updateStudent(Student student) {
		jdbcTemplateObject.jdbcTemplate().execute(
				String.format(STUDENT_UPDATE, student.getName(), student.isRegistered(), student.getStudentID()));
		return true;
	}

	@Override
	public List<Student> findUnregisteredStudents() {
		return jdbcTemplateObject.jdbcTemplate().query(STUDENT_SELECT_UNREGISTERED, new Object[] { false },
				new StudentMapper());
	}

}
