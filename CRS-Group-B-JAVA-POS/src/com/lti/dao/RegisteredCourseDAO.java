package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.utils.DBUtils;

public class RegisteredCourseDAO implements RegisteredCourseDAOInterface {

	private PreparedStatement stmt = null;
	
	@Override
	public ArrayList<Course> viewStudentCourses(int studentID) {
		
		return null;
	}

	@Override
	public ArrayList<Student> viewAllStudents(int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> viewAllPaidCourses(int studentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Course, Double> viewGrades(int studentID) {
		HashMap<Course, Double> map = new HashMap<Course, Double>();
		return null;
	}

	@Override
	public boolean addStudentRegistration(int studentID, int courseID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean payFee(int studentID, int courseID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setGrade(int studentID, int courseID, double grade) {
		boolean changed = false;
		try {

			Connection conn = DBUtils.getConnection();

			// Step 5 create and populate statement

			String sql = "SELECT courseID, studentID, grade FROM RegisteredCourse WHERE courseID='?' AND studentID='?'";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, courseID);
			stmt.setInt(2, studentID);
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				
				int tempCourseID  = rs.getInt("courseID");
				int tempStudentID= rs.getInt("studentID");
				
				if (courseID == tempCourseID && studentID == tempStudentID) {
					sql = "UPDATE RegisteredCourse SET grade='?' WHERE courseID='?' AND studentID='?'";
					stmt = conn.prepareStatement(sql);
					stmt.setDouble(1, grade);
					stmt.setInt(2, courseID);
					stmt.setInt(3, studentID);
					
					stmt.executeUpdate();
					changed = true;
				}
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return changed;
	}

	@Override
	public boolean removeStudentRegistration(int studentID, int courseID) {
		boolean removed = false;
		try {

			Connection conn = DBUtils.getConnection();

			// Step 5 create and populate statement

			String sql = "SELECT courseID, studentID FROM RegisteredCourse WHERE courseID='?' AND studentID='?'";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, courseID);
			stmt.setInt(2, studentID);
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				
				int tempCourseID  = rs.getInt("courseID");
				int tempStudentID= rs.getInt("studentID");
				
				if (courseID == tempCourseID && studentID == tempStudentID) {
					sql = "DELETE FROM RegisteredCourse WHERE courseID='?' AND studentID='?'";
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, courseID);
					stmt.setInt(2, studentID);
					
					stmt.executeUpdate();
					removed = true;
				}
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return removed;
	}

}
