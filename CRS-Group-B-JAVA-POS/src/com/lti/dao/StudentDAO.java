/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.lti.bean.Student;
import com.lti.bean.User;

/**
 * @author user101
 *
 */
public class StudentDAO implements StudentDAOInterface {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/crsdatabase";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "root";
	private Connection conn = null;
	private PreparedStatement stmt = null;

	private UserDAOInterface userDAO = new UserDAO();

	@Override
	public int createStudent(Student student) {
		int userID = userDAO.createNewUser(student.getUsername(), student.getPassword(), 3);

		try {
			// Step 3 Register Driver

			Class.forName(JDBC_DRIVER);

			// Step 4 make a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Step 5 create and populate statement

			String sql = "insert into Student values(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
			stmt.setString(2, student.getName());

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

	@Override
	public Student viewStudent(String username) {
		User us = userDAO.viewUser(username);
		Student student = null;
		int id = us.getUserID();
		
		try {
			// Step 3 Register Driver

			Class.forName(JDBC_DRIVER);

			// Step 4 make a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Step 5 create and populate statement

			String sql = "SELECT studentID, name FROM Student";
			
			stmt = conn.prepareStatement(sql);
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				int tempUserID  = rs.getInt("studentID");
				String tempName = rs.getString("name");
				if (tempUserID == id) {
					student = new Student(id);
					student.setName(tempName);
					student.setUsername(us.getUsername());
					student.setPassword(us.getPassword());
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
		return student;
	}

}
