package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lti.bean.Admin;
import com.lti.utils.DBUtils;

public class AdminDAO implements AdminDAOInterface {

	
	private PreparedStatement stmt = null;

	private UserDAOInterface userDAO = new UserDAO();
	
	@Override
	public int createAdmin(Admin admin) {
		
		int userID = userDAO.createNewUser(admin.getUsername(), admin.getPassword(), 1);

		try {
			Connection conn = DBUtils.getConnection();
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
		}
		return userID;
	}
}
