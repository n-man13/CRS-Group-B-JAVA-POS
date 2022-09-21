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
	public Map<Student, Double> viewStudentsAndGrades(int courseID) {
		HashMap<Student, Double> map = new HashMap<Student, Double>();
		try {
			Connection conn = DBUtils.getConnection();
			
			String sql_SELECT_GRADES = "SELECT courseID, studentID, grade WHERE courseID='?'";
			stmt = conn.prepareStatement(sql_SELECT_GRADES);
			stmt.setInt(1, courseID);
			
			ResultSet rs = stmt.executeQuery();
			StudentDAO stu = new StudentDAO();
			Student student = null;
			while (rs.next()) {
				int tempCourseID = rs.getInt("courseID");
				int tempStudentID = rs.getInt("studentID");
				student = stu.viewStudent(tempCourseID);
				double tempGrade = rs.getDouble("grade");
				map.put(student, tempGrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<Course, Double> viewGrades(int studentID) {
		HashMap<Course, Double> map = new HashMap<Course, Double>();
		try {
			Connection conn = DBUtils.getConnection();
			
			String sql_SELECT_GRADES = "SELECT courseID, studentID, grade WHERE studentID='?'";
			stmt = conn.prepareStatement(sql_SELECT_GRADES);
			stmt.setInt(1, studentID);
			
			ResultSet rs = stmt.executeQuery();
			CourseDAO cou = new CourseDAO();
			Course course = null;
			while (rs.next()) {
				int tempCourseID = rs.getInt("courseID");
				course = cou.viewCourse(tempCourseID);
				int tempStudentID = rs.getInt("studentID");
				double tempGrade = rs.getDouble("grade");
				map.put(course, tempGrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public boolean addStudentRegistration(int studentID, int courseID) {
		boolean added = false;
		try {
			Connection conn = DBUtils.getConnection();
			
			String sql_INSERT = "INSERT INTO RegisteredCourse VALUES(?,?,0,-1)";
			stmt = conn.prepareStatement(sql_INSERT);
			stmt.setInt(1, studentID);
			stmt.setInt(2, courseID);
			
			stmt.executeUpdate();
			added = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean payFee(int studentID, int courseID) {
		boolean changed = false;
		try {

			Connection conn = DBUtils.getConnection();

			// Step 5 create and populate statement

			String sql = "SELECT courseID, studentID, feePaid FROM RegisteredCourse WHERE courseID='?' AND studentID='?'";
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
					sql = "UPDATE RegisteredCourse SET feePaid='?' WHERE courseID='?' AND studentID='?'";
					stmt = conn.prepareStatement(sql);
					stmt.setBoolean(1, true);
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
