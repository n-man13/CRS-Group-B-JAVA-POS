/**
 * 
 */
package com.lti.dao;

import java.util.List;
import java.util.Map;

import com.lti.dto.Course;
import com.lti.dto.Student;

/**
 * @author user101
 *
 */
public class RegisteredCourseDAO implements RegisteredCourseDAOInterface {

	@Override
	public List<Course> findCoursesByStudentID(int studentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentsByCourseID(int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findUnpaidCoursesByStudentID(int studentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Student, Double> findStudentsAndGradesByCourseID(int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Course, Double> findGradesByStudentID(int studentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStudentRegistration(int studentID, int courseID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFeePaid(int studentID, int courseID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGrade(int studentID, int courseID, double grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudentRegistration(int studentID, int courseID) {
		// TODO Auto-generated method stub
		return false;
	}

}
