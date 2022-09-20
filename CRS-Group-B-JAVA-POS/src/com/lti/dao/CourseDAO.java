package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.User;
import com.lti.utils.DBUtils;

public class CourseDAO implements CourseDAOInterface {

	
	private PreparedStatement stmt = null;
	
	private ProfessorDAOInterface profDAO = new ProfessorDAO();
	
	/**
	 * returns all courses in an ArrayList
	 * @return all courses
	 */
	@Override
	public ArrayList<Course> viewAllCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();
		try {

			Connection conn = DBUtils.getConnection();

			// Step 5 create and populate statement

			String sql = "SELECT courseID, name , department, description, professorID, prereqID FROM Course";
			stmt = conn.prepareStatement(sql);
			
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				
				int tempCourseID  = rs.getInt("courseID");
				Course tempCourse = new Course(tempCourseID);
				String tempName = rs.getString("name");
				tempCourse.setName(tempName);
				String tempDepartment = rs.getString("department");
				tempCourse.setDepartment(tempDepartment);
				String tempDescription = rs.getString("description");
				tempCourse.setDescription(tempDescription);
				int tempProfID= rs.getInt("professorID");
				Professor pro = profDAO.viewProfessor(tempProfID);
				tempCourse.setProf(pro);
				int tempPrereqID= rs.getInt("prereqID");
				tempCourse.setPrereqCourseID(tempPrereqID);
				courses.add(tempCourse);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * 
	 * @param course course to create
	 * @return if course was created
	 */
	@Override
	public boolean createCourse(Course course) {
		boolean created = false;
		try {
			Connection conn = DBUtils.getConnection();

			// Step 5 create and populate statement

			String sql = "insert into Course values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, course.getCourseID());
			stmt.setString(2, course.getName());
			stmt.setString(3, course.getDepartment());
			stmt.setString(4, course.getDescription());
			stmt.setInt(5, course.getProf().getProfID());
			stmt.setInt(6, course.getPrereqCourseID());

			// Step 6 execute statement

			stmt.executeUpdate();
			created = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

	/**
	 * 
	 * @param courseID the course to modify
	 * @param profID the professor to teach
	 * @return if course was updated
	 */
	@Override
	public boolean addProfessorToCourse(int courseID, int profID) {
		
		return false;
	}

	/**
	 * 
	 * @param courseID the course to delete
	 * @return the course that was deleted, else null
	 */
	@Override
	public Course deleteCourse(int courseID) {
		Course course = null;
		try {
			Connection conn = DBUtils.getConnection();

			// Step 5 create and populate statement

			String sql = "SELECT courseID, name , department, description, professorID, prereqID FROM Course WHERE courseID='?'";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, courseID);
			
			// Step 6 execute statement
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				
				int tempCourseID  = rs.getInt("courseID");
				course = new Course(tempCourseID);
				String tempName = rs.getString("name");
				course.setName(tempName);
				String tempDepartment = rs.getString("department");
				course.setDepartment(tempDepartment);
				String tempDescription = rs.getString("description");
				course.setDescription(tempDescription);
				int tempProfID= rs.getInt("professorID");
				Professor pro = profDAO.viewProfessor(tempProfID);
				course.setProf(pro);
				int tempPrereqID= rs.getInt("prereqID");
				course.setPrereqCourseID(tempPrereqID);
				
			}
			sql = "DELETE FROM Course WHERE courseID='?'";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, courseID);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return course;
	}

}
