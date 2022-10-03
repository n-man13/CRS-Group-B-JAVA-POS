/**
 * 
 */
package com.lti.dao;
import java.util.ArrayList;
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
	public static final String REGISTEREDCOURSE_UPDATE = "UPDATE RegisteredCourse SET feePaid=%b WHERE courseID=%o AND studentID=%o";
	public static final String REGISTEREDCOURSE_SELECT_GRADES_BY_COURSEID = "SELECT courseID, studentID, grade FROM RegisteredCourse WHERE courseID=?";
	public static final String REGISTEREDCOURSE_SELECT_GRADES_BY_STUDENTID = "SELECT courseID, studentID, grade FROM RegisteredCourse WHERE studentID=?";
	public static final String REGISTEREDCOURSE_SELECT_GRADES_BY_STUDENTID_AND_COURSEID = "SELECT courseID, studentID, grade FROM RegisteredCourse WHERE courseID=? AND studentID=?";
	public static final String REGISTEREDCOURSE_SELECT_BY_STUDENTID_AND_COURSEID = "SELECT courseID, studentID FROM RegisteredCourse WHERE courseID=? AND studentID=?";
	public static final String REGISTEREDCOURSE_UPDATE_GRADES = "UPDATE RegisteredCourse SET grade=%d WHERE courseID=%o AND studentID=%o";
	public static final String REGISTEREDCOURSE_SELECT_COURSES_BY_STUDENTID = "SELECT courseID FROM RegisteredCourse WHERE studentID=%o";
	public static final String REGISTEREDCOURSE_DELETE = "DELETE FROM RegisteredCourse WHERE courseID=%o AND studentID=%o";
	public static final String REGISTEREDCOURSE_INSERT = "INSERT INTO RegisteredCourse VALUES(%o,%o,0,-1)";

	@Override
	public List<Course> findCoursesByStudentID(int studentID) {
		List<Course> courses = new ArrayList<Course>();
		List<Integer> courseIDs = jdbcConfiguration.jdbcTemplate()
				.queryForList(String.format(REGISTEREDCOURSE_SELECT_COURSES_BY_STUDENTID, studentID), Integer.class);
		for (int courseID : courseIDs) {
			courses.add(courseDAO.findCourseByCourseID(courseID));
		}
		return courses;
		//temp comment
	}

	@Override
	public List<Student> findStudentsByCourseID(int courseID) {
		List<Student> students = new ArrayList<Student>();
		List<Integer> studentIDs = jdbcConfiguration.jdbcTemplate()
				.queryForList(String.format(REGISTEREDCOURSE_SELECT_STUDENTS_BY_COURSEID, courseID), Integer.class);
		for (int studentID : studentIDs) {
			students.add(studentDAO.findStudent(studentID));
		}
		return students;
	}

	@Override
	public List<Course> findUnpaidCoursesByStudentID(int studentID) {
		List<Course> courses = new ArrayList<Course>();
		List<Integer> courseIDs = jdbcConfiguration.jdbcTemplate()
				.queryForList(String.format(REGISTEREDCOURSE_SELECT_ALL_FEE_UNPAID, studentID), Integer.class);
		for (int courseID : courseIDs) {
			courses.add(courseDAO.findCourseByCourseID(courseID));
		}
		return courses;
	}

	@Override
	public Map<Student, Double> findStudentsAndGradesByCourseID(int courseID) {
		Map<Student, Double> studentGrades = new HashMap<Student, Double>();
		List<RegisteredCourse> registeredCourses = jdbcConfiguration.jdbcTemplate()
				.query(REGISTEREDCOURSE_SELECT_GRADES_BY_COURSEID, new RegisteredCourseMapper(), courseID);

		for (RegisteredCourse registeredCourse : registeredCourses) {
			studentGrades.put(studentDAO.findStudent(registeredCourse.getStudentID()), registeredCourse.getGrade());
		}

		return studentGrades;
	}

	@Override
	public Map<Course, Double> findGradesByStudentID(int studentID) {
		Map<Course, Double> courseGrades = new HashMap<Course, Double>();
		List<RegisteredCourse> registeredCourses = jdbcConfiguration.jdbcTemplate()
				.query(REGISTEREDCOURSE_SELECT_GRADES_BY_STUDENTID, new RegisteredCourseMapper(), studentID);

		for (RegisteredCourse registeredCourse : registeredCourses) {
			courseGrades.put(courseDAO.findCourseByCourseID(registeredCourse.getCourseID()),
					registeredCourse.getGrade());
		}

		return courseGrades;
	}

	@Override
	public boolean updateStudentRegistration(int studentID, int courseID) {
		jdbcConfiguration.jdbcTemplate().execute(String.format(REGISTEREDCOURSE_INSERT, studentID, courseID));
		return true;
	}

	@Override
	public boolean updateFeePaid(int studentID, int courseID) {
		jdbcConfiguration.jdbcTemplate().execute(String.format(REGISTEREDCOURSE_UPDATE, true, courseID, studentID));
		return true;
	}

	@Override
	public boolean updateGrade(int studentID, int courseID, double grade) {
		jdbcConfiguration.jdbcTemplate()
				.execute(String.format(REGISTEREDCOURSE_UPDATE_GRADES, grade, courseID, studentID));
		return true;
	}

	@Override
	public boolean deleteStudentRegistration(int studentID, int courseID) {
		jdbcConfiguration.jdbcTemplate().execute(String.format(REGISTEREDCOURSE_DELETE, courseID, studentID));
		return true;
	}

}
