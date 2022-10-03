package com.lti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.dto.Professor;
import com.lti.mapper.ProfessorMapper;
import com.lti.mapper.StudentMapper;

@Repository
public class ProfessorDAO implements ProfessorDAOInterface{
	
	@Autowired
	private JDBCConfiguration jdbcTemplateObject;
	
	@Autowired
	private UserDAO userDAO;
	
	public static final String PROFESSOR_INSERT = "INSERT INTO Professor(professorID, name) VALUES(%o,%s)";
	public static final String PROFESSOR_SELECT = "SELECT * FROM Professor WHERE professorID = ?";
	public static final String PROFESSOR_SELECT_USERNAME = "SELECT * FROM Professor WHERE username = ?";
	
	@Override
	public int createProfessor(Professor professor) {
		int userID = userDAO.createUser(professor.getUsername(), professor.getPassword(), 2);
		jdbcTemplateObject.jdbcTemplate()
				.execute(String.format(PROFESSOR_INSERT, userID, professor.getName()));
		return userID;
	}

	@Override
	public Professor findProfessorByProfessorID(int professorID) {
		try {
			return jdbcTemplateObject.jdbcTemplate().queryForObject(PROFESSOR_SELECT, new ProfessorMapper(), professorID);
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public Professor findProfessorByUsername(String username) {
		try {
			return jdbcTemplateObject.jdbcTemplate().queryForObject(PROFESSOR_SELECT_USERNAME, new ProfessorMapper(), username);
		} catch (DataAccessException e) {
			return null;
		}
	}

}
