package com.lti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.dto.Admin;
import com.lti.dto.Course;
import com.lti.dto.Professor;
import com.lti.mapper.CourseMapper;
import com.lti.mapper.StudentMapper;

@Repository
public class CourseDAO implements CourseDAOInterface {

	@Autowired
	JDBCConfiguration jdbcTemplateObject;

	@Autowired
	ProfessorDAO professorDAO;

	public static final String COURSE_SELECT_BY_COURSEID = "SELECT courseID, name , department, description, professorID, prereqID FROM Course WHERE courseID=?";
	public static final String COURSE_SELECT_BY_PROFESSORID = "SELECT courseID, name , department, description, professorID, prereqID FROM Course WHERE professorID=?";
	public static final String COURSE_SELECT_ALL_COURSES = "SELECT courseID, name , department, description, professorID, prereqID FROM Course";
	public static final String COURSE_DELETE = "DELETE FROM Course WHERE courseID=?";
	public static final String COURSE_UPDATE = "UPDATE Course SET name=?, department=?, description=?, prereqID=? WHERE courseID=?";
	public static final String COURSE_UPDATE_PROFESSORID = "UPDATE Course SET professorID=? WHERE courseID=?";
	public static final String COURSE_INSERT = "INSERT INTO Course(name,department,description,professorID,prereqID) VALUES(?,?,?,NULL,?)";

	@Override
	public List<Course> findAllCourses() {
		try {
			return jdbcTemplateObject.jdbcTemplate().query(COURSE_SELECT_ALL_COURSES, new CourseMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean createCourse(Course course) {
		jdbcTemplateObject.jdbcTemplate().update(COURSE_INSERT, course.getName(), course.getDepartment(),
				course.getDescription(), course.getPrereqCourseID());
		return true;
	}

	@Override
	public boolean updateProfessorToCourse(int courseID, int professorID) {
		jdbcTemplateObject.jdbcTemplate().update(COURSE_UPDATE_PROFESSORID, professorID, courseID);
		return true;
	}

	@Override
	public List<Course> findCourseByProfessorID(int professorID) {
		try {
			List<Course> courses = jdbcTemplateObject.jdbcTemplate().query(COURSE_SELECT_BY_PROFESSORID,
					new CourseMapper(), professorID);
			for (int i = 0; i < courses.size(); i++) {
				Course c = saveProfessorIntoCourse(courses.get(i), professorID);
				courses.set(i, c);
			}
			return courses;
		} catch (DataAccessException e) {
			return null;
		}
	}

	private Course saveProfessorIntoCourse(Course course, int professorID) {
		Professor professor = professorDAO.findProfessorByProfessorID(professorID);
		course.setProf(professor);
		return course;
	}

	@Override
	public Course deleteCourse(int courseID) {
		Course course = findCourseByCourseID(courseID);
		jdbcTemplateObject.jdbcTemplate().update(COURSE_DELETE, courseID);
		return course;
	}

	@Override
	public Course findCourseByCourseID(int courseID) {
		try {
			Course course = jdbcTemplateObject.jdbcTemplate().queryForObject(COURSE_SELECT_BY_COURSEID,
					new CourseMapper(), courseID);
			course = saveProfessorIntoCourse(course, course.getProf().getProfessorID());
			return course;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean updateCourse(Course course) {
		jdbcTemplateObject.jdbcTemplate().update(COURSE_UPDATE, course.getName(), course.getDepartment(),
				course.getDescription(), course.getPrereqCourseID());
		return true;
	}

}
