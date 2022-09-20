package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lti.bean.Admin;

public class AdminDAO implements AdminDAOInterface {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/crsdatabase";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "root";
	private Connection conn = null;
	private PreparedStatement stmt = null;

	private UserDAOInterface userDAO = new UserDAO();
	
	@Override
	public int createAdmin(Admin admin) {
		
		int userID = userDAO.createNewUser(admin.getUsername(), admin.getPassword(), 1);

		try {
			// Step 3 Register Driver

			Class.forName(JDBC_DRIVER);

			// Step 4 make a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Step 5 create and populate statement

			String sql = "insert into Admin values(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);

			// Step 6 execute statement

			stmt.executeUpdate();
			

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
}
