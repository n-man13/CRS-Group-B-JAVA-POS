package com.lti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.dto.Admin;
import com.lti.dto.User;
import com.lti.mapper.AdminMapper;
import com.lti.mapper.StudentMapper;

@Repository
public class AdminDAO implements AdminDAOInterface{
	
	@Autowired
	JDBCConfiguration jdbcTemplateObject;
	
	@Autowired
	UserDAO userDAO;
	
	public static final String ADMIN_INSERT = "INSERT INTO Admin(adminID) VALUES(%o)";
	public static final String ADMIN_SELECT = "SELECT * FROM Admin WHERE adminID = ?";

	@Override
	public int createAdmin(Admin admin) {
		int userID = userDAO.createUser(admin.getUsername(), admin.getPassword(), 3);
		jdbcTemplateObject.jdbcTemplate()
				.execute(String.format(ADMIN_INSERT, userID));
		return userID;
	}

	@Override
	public Admin findAdminByUsername(String username) {
		User user = userDAO.findUser(username);
		return findAdminByAdminID(user.getUserID());
	}

	@Override
	public Admin findAdminByAdminID(int adminID) {
		try {
			return jdbcTemplateObject.jdbcTemplate().queryForObject(ADMIN_SELECT, new AdminMapper(), adminID);
		} catch (DataAccessException e) {
			return null;
		}
	}

}
