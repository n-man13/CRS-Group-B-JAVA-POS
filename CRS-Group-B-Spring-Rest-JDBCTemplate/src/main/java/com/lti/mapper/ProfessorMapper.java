package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.lti.dao.UserDAO;
import com.lti.dto.Professor;
import com.lti.dto.Student;

public class ProfessorMapper implements RowMapper<Professor>{

	@Autowired
	UserDAO userDAO;

	@Override
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Professor professor = new Professor();
		
		professor.setStudentID(rs.getInt("studentID"));
		student.setUsername(userDAO.findUser(rs.getInt("studentID")).getUsername());
		student.setPassword(userDAO.findUser(rs.getInt("studentID")).getPassword());
		student.setRole(userDAO.findUser(rs.getInt("studentID")).getRole());
		student.setName(rs.getString("name"));
		student.setRegistered(rs.getBoolean("registrationApproved"));
		return student;
		
	}
	
}
