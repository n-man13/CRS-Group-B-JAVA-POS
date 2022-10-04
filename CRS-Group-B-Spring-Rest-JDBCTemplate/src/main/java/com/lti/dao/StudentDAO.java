/**
 * 
 */
package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constants.SQLConstants;
import com.lti.dto.Student;
import com.lti.dto.User;
import com.lti.mapper.StudentMapper;

/**
 * @author user101
 *
 */
@Repository
public class StudentDAO implements StudentDAOInterface {

	@Autowired
	private JDBCConfiguration jdbcTemplateObject;
	@Autowired
	private UserDAO userDAO;
	// Queries for Student table
	

	@Override
	public int createStudent(Student student) {
		int userID = userDAO.createUser(student.getUsername(), student.getPassword(), 3);
		jdbcTemplateObject.jdbcTemplate().update(SQLConstants.STUDENT_INSERT, userID, student.getName(), student.isRegistered());
		return userID;
	}

	@Override
	public Student findStudent(String username) {
		User user = userDAO.findUser(username);
		return findStudent(user.getUserID());
	}

	@Override
	public Student findStudent(int studentID) {
		try {
			return jdbcTemplateObject.jdbcTemplate().queryForObject(SQLConstants.STUDENT_SELECT, new StudentMapper(), studentID);
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean updateStudent(Student student) {
		jdbcTemplateObject.jdbcTemplate().update(SQLConstants.STUDENT_UPDATE, student.getName(), student.isRegistered(),
				student.getStudentID());
		return true;
	}

	@Override
	public List<Student> findUnregisteredStudents() {
		return jdbcTemplateObject.jdbcTemplate().query(SQLConstants.STUDENT_SELECT_UNREGISTERED, new StudentMapper(), false);
	}

}
