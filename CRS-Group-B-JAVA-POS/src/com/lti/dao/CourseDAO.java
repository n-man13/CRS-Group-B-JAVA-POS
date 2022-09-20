package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lti.bean.Course;
import com.lti.bean.User;

public class CourseDAO implements CourseDAOInterface {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/crsdatabase";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "root";
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	/**
	 * returns all courses in an ArrayList
	 * @return all courses
	 */
	@Override
	public ArrayList<Course> viewAllCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			// Step 3 Register Driver

			Class.forName(JDBC_DRIVER);

			// Step 4 make a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Step 5 create and populate statement

			String sql = "SELECT courseID, name , department, description, professorID, prereqID FROM Course";
			
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				
				int tempCourseID  = rs.getInt("courseID");
				Course tempCourse = new Course(tempCourseID);
				String tempUsername = rs.getString("name");
				String tempDepartment = rs.getString("department");
				String tempDescription = rs.getString("description");
				int tempProfID= rs.getInt("professorID");
				int tempPrereqID= rs.getInt("prereqID");
				
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
		return null;
	}

	/**
	 * 
	 * @param course course to create
	 * @return if course was created
	 */
	@Override
	public boolean createCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * @param courseID the course to modify
	 * @param profID the professor to teach
	 * @return if course was updated
	 */
	@Override
	public boolean addProfessorToCourse(int courseID, int profID) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * @param courseID the course to delete
	 * @return the course that was deleted, else null
	 */
	@Override
	public Course deleteCourse(int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

}
