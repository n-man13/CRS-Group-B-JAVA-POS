/**
 * 
 */
package com.lti.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.dto.Course;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;
import com.lti.mapper.CourseMapper;
import com.lti.mapper.RegisteredCourseMapper;
import com.lti.mapper.StudentMapper;

/**
 * @author user101
 *
 */
@Repository
public class RegisteredCourseDAO implements RegisteredCourseDAOInterface {
	@Autowired
	JDBCConfiguration jdbcConfiguration;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private StudentDAO studentDAO;

	// Queries for RegisteredCourse table
	public static final String REGISTEREDCOURSE_SELECT_STUDENTS_BY_COURSEID = "SELECT courseID, studentID FROM RegisteredCourse WHERE courseID=%o";
	public static final String REGISTEREDCOURSE_SELECT_FEE_UNPAID = "SELECT courseID, studentID, feePaid FROM RegisteredCourse WHERE courseID=? AND studentID=? AND feePaid=0";
	public static final String REGISTEREDCOURSE_SELECT_ALL_FEE_UNPAID = "SELECT courseID, studentID, feePaid FROM RegisteredCourse WHERE studentID=%o AND feePaid=0";
	public static final String REGISTEREDCOURSE_UPDATE = "UPDATE RegisteredCourse SET feePaid=? WHERE courseID=? AND studentID=?";
	public static final String REGISTEREDCOURSE_SELECT_GRADES_BY_COURSEID = "SELECT courseID, studentID, grade FROM RegisteredCourse WHERE courseID=?";
	public static final String REGISTEREDCOURSE_SELECT_GRADES_BY_STUDENTID = "SELECT courseID, studentID, grade FROM RegisteredCourse WHERE studentID=?";
	public static final String REGISTEREDCOURSE_SELECT_GRADES_BY_STUDENTID_AND_COURSEID = "SELECT courseID, studentID, grade FROM RegisteredCourse WHERE courseID=? AND studentID=?";
	public static final String REGISTEREDCOURSE_SELECT_BY_STUDENTID_AND_COURSEID = "SELECT courseID, studentID FROM RegisteredCourse WHERE courseID=? AND studentID=?";
	public static final String REGISTEREDCOURSE_UPDATE_GRADES = "UPDATE RegisteredCourse SET grade=? WHERE courseID=? AND studentID=?";
	public static final String REGISTEREDCOURSE_SELECT_COURSES_BY_STUDENTID = "SELECT courseID FROM RegisteredCourse WHERE studentID=%o";
	public static final String REGISTEREDCOURSE_DELETE = "DELETE FROM RegisteredCourse WHERE courseID=? AND studentID=?";
	public static final String REGISTEREDCOURSE_INSERT = "INSERT INTO RegisteredCourse VALUES(?,?,0,-1)";

	@Override
	public List<Course> findCoursesByStudentID(int studentID) {
		return jdbcConfiguration.jdbcTemplate().query(String.format(REGISTEREDCOURSE_SELECT_COURSES_BY_STUDENTID, studentID), new CourseMapper());
	}

	@Override
	public List<Student> findStudentsByCourseID(int courseID) {
		return jdbcConfiguration.jdbcTemplate().query(String.format(REGISTEREDCOURSE_SELECT_STUDENTS_BY_COURSEID, courseID), new StudentMapper());
	}

	@Override
	public List<Course> findUnpaidCoursesByStudentID(int studentID) {
		return jdbcConfiguration.jdbcTemplate().query(String.format(REGISTEREDCOURSE_SELECT_ALL_FEE_UNPAID, studentID), new CourseMapper());
	} 

	@Override
	public Map<Student, Double> findStudentsAndGradesByCourseID(int courseID) {
		Map<Student, Double> studentGrades = new HashMap<Student, Double>();
		List<RegisteredCourse> registeredCourses = jdbcConfiguration.jdbcTemplate().query(REGISTEREDCOURSE_SELECT_GRADES_BY_COURSEID, new Object[] { courseID }, new RegisteredCourseMapper());
		
		for (RegisteredCourse registeredCourse: registeredCourses) {
			studentGrades.put(registeredCourse.getStudent(), registeredCourse.getGrade());
		}
		
		return studentGrades;
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
