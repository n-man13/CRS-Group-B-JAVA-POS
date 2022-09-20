/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.utils.DBUtils;

/**
 * @author user101
 *
 */
public class ProfessorDAO implements ProfessorDAOInterface {

	
	private PreparedStatement stmt = null;

	private UserDAOInterface userDAO = new UserDAO();

	@Override
	public int createProfessor(Professor prof) {

		int userID = userDAO.createNewUser(prof.getUsername(), prof.getPassword(), 2);

		try {
			Connection conn = DBUtils.getConnection();
			// Step 5 create and populate statement

			String sql = "insert into Professor values(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
			stmt.setString(2, prof.getName());

			// Step 6 execute statement

			stmt.executeUpdate();
			return userID;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userID;
	}

	@Override
	public Professor viewProfessor(int profID) {
		Professor prof = null;
		try {
			Connection conn = DBUtils.getConnection();
			// Step 5 create and populate statement

			String sql = "SELECT profID, name FROM Professor";
			
			stmt = conn.prepareStatement(sql);
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				int tempUserID  = rs.getInt("profID");
				String tempName = rs.getString("name");
				if (tempUserID == profID) {
					prof = new Professor(tempUserID, tempName);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
