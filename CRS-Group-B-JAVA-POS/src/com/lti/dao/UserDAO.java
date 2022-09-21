package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.bean.User;
import com.lti.constant.SQLConstants;
import com.lti.utils.DBUtils;

public class UserDAO implements UserDAOInterface {

	
	private PreparedStatement stmt = null;

	/**
	 * Creates a new user and returns the userID
	 * 
	 * @param username the users username
	 * @param password the users password
	 * @param role     the role number
	 * @return userID generated or -1 if already exists
	 */
	@Override
	public int createNewUser(String username, String password, int role) {
		int userID = -1;
		try {
			Connection conn = DBUtils.getConnection();

			// Step 5 create and populate statement

			//String sql = "insert into User values(?,?,?)";
			
			stmt = conn.prepareStatement(SQLConstants.USER_INSERT);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, role);

			// Step 6 execute statement

			stmt.executeUpdate();

			sql = "SELECT userID, username , password, role FROM User";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				int tempUserID  = rs.getInt("id");
				String tempUsername = rs.getString("username");
				String tempPassword = rs.getString("password");
				int tempRole = rs.getInt("role");
				if (username.equals(tempUsername)) {
					userID = tempUserID;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userID;
	}

	/**
	 * returns the user with the associated username
	 * 
	 * @param username the users username
	 * @return the user or null if no user exists
	 */
	@Override
	public User viewUser(String username) {
		User thisUser = null;
		try {
			Connection conn = DBUtils.getConnection();

			// Step 5 create and populate statement

			String sql = "SELECT userID, username , password, role FROM User";
			
			stmt = conn.prepareStatement(sql);
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);
			

			while (rs.next()) {
				// Retrieve by column name
				int tempUserID  = rs.getInt("userID");
				String tempUsername = rs.getString("username");
				String tempPassword = rs.getString("password");
				int tempRole = rs.getInt("role");
				if (username.equals(tempUsername)) {
					thisUser = new User(tempUserID);
					thisUser.setPassword(tempPassword);
					thisUser.setUsername(tempUsername);
					thisUser.setRole(tempRole);
					System.out.println(tempUsername + "/" + tempUserID + "/" + tempPassword + "/" + tempRole);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return thisUser;
	}

}
