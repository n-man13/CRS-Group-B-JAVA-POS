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
import com.lti.constant.SQLConstants;
import com.lti.utils.DBUtils;

/**
 * @author user101
 *
 */
public class StudentDAO implements StudentDAOInterface {

	private PreparedStatement stmt = null;

	@Override
	public int createStudent(Student student) {
		UserDAO userDAO = new UserDAO();
		int userID = userDAO.createNewUser(student.getUsername(), student.getPassword(), 3);

		try {
			Connection conn = DBUtils.getConnection();
			// Step 5 create and populate statement

			//String sql = "INSERT INTO Student VALUES(?,?)";
			stmt = conn.prepareStatement(SQLConstants.STUDENT_INSERT);
			stmt.setInt(1, userID);
			stmt.setString(2, student.getName());

			// Step 6 execute statement

			stmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userID;
	}

	public Student viewStudent(int studentID) {
		Student student = null;
		try {
			Connection conn = DBUtils.getConnection();
			// Step 5 create and populate statement

			//String sql = "SELECT studentID, name FROM Student"; // TODO add where clause
			
			stmt = conn.prepareStatement(SQLConstants.STUDENT_SELECT);
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Retrieve by column name
				int tempUserID  = rs.getInt("studentID");
				String tempName = rs.getString("name");
				if (tempUserID == studentID) {
					student = new Student(studentID);
					student.setName(tempName);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return student;
	}
	
	@Override
	public Student viewStudent(String username) {
		UserDAO userDAO = new UserDAO();
		User us = userDAO.viewUser(username);
		int studentID = us.getUserID();
		return viewStudent(studentID);
		
	}

}
