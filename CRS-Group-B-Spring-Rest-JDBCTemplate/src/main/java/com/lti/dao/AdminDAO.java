package com.lti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.dto.Admin;

@Repository
public class AdminDAO implements AdminDAOInterface{
	
	@Autowired
	JDBCConfiguration jdbcTemplateObject;

	@Override
	public int createAdmin(Admin admin) {
		int userID = userDAO.createUser(admin.getUsername(), admin.getPassword(), 3);
		jdbcTemplateObject.jdbcTemplate()
				.execute(String.format(PROFESSOR_INSERT, userID, admin.getName()));
		return userID;
	}

	@Override
	public Admin findAdminByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findAdminByAdminID(int adminID) {
		// TODO Auto-generated method stub
		return null;
	}

}
