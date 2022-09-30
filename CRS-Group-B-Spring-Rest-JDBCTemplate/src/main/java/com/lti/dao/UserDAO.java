/**
 * 
 */
package com.lti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lti.configuration.JDBCConfiguration;
import com.lti.dto.User;
import com.lti.mapper.UserMapper;

/**
 * @author user101
 *
 */
public class UserDAO implements UserDAOInterface {

	@Autowired
	private JDBCConfiguration jdbcTemplateObject;
	// Queries for User table
	public static final String USER_INSERT = "INSERT INTO User(username, password, role) VALUES(%s,%s,%o)";
	public static final String USER_SELECT = "SELECT userID, username , password, role FROM User WHERE username = ?";
	public static final String USER_SELECT_ID = "SELECT userID, username , password, role FROM User WHERE userID = ?";
	public static final String USER_UPDATE_PASSWORD = "UPDATE User SET password=%s WHERE username=%s";

	@Override
	public int createUser(String username, String password, int role) {
		jdbcTemplateObject.jdbcTemplate().execute(String.format(USER_INSERT, username, password, role));
		User user = findUser(username);
		return user.getUserID();
	}

	@Override
	public User findUser(String username) {
		//String sql = "SELECT * FROM User WHERE username = ?";
		User user = jdbcTemplateObject.jdbcTemplate().queryForObject(USER_SELECT, new Object[] { username },
				new UserMapper());
		return user;
	}
	
	public User findUser(int userID) {
		User user = jdbcTemplateObject.jdbcTemplate().queryForObject(USER_SELECT_ID, new Object[] { userID },
				new UserMapper());
		return user;
	}

	@Override
	public boolean updatePassword(String username, String password) {
		jdbcTemplateObject.jdbcTemplate().execute(String.format(USER_UPDATE_PASSWORD, password, username));
		return true;
	}

}
