package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.bean.User;

public class UserDAO implements UserDAOInterface {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/crsdatabase";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "root";
	private Connection conn = null;
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
			// Step 3 Register Driver

			Class.forName(JDBC_DRIVER);

			// Step 4 make a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Step 5 create and populate statement

			String sql = "insert into User values(?,?,?)";
			stmt = conn.prepareStatement(sql);
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
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

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
			// Step 3 Register Driver

			Class.forName(JDBC_DRIVER);

			// Step 4 make a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Step 5 create and populate statement

			String sql = "SELECT userID, username , password, role FROM User";
			
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				int tempUserID  = rs.getInt("id");
				String tempUsername = rs.getString("username");
				String tempPassword = rs.getString("password");
				int tempRole = rs.getInt("role");
				if (username.equals(tempUsername)) {
					thisUser = new User(tempUserID);
					thisUser.setPassword(tempPassword);
					thisUser.setUsername(tempUsername);
					thisUser.setRole(tempRole);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return thisUser;
	}

}
