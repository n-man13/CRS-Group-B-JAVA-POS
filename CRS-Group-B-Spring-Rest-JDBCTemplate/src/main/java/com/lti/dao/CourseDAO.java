package com.lti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.constants.SQLConstants;
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

	

	@Override
	public List<Course> findAllCourses() {
		try {
			return jdbcTemplateObject.jdbcTemplate().query(SQLConstants.COURSE_SELECT_ALL_COURSES, new CourseMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean createCourse(Course course) {
		if (course.getPrereqCourseID() == -1) {
			jdbcTemplateObject.jdbcTemplate().update(SQLConstants.COURSE_INSERT, course.getName(), course.getDepartment(),
					course.getDescription(), null);
		}
		else {
		jdbcTemplateObject.jdbcTemplate().update(SQLConstants.COURSE_INSERT, course.getName(), course.getDepartment(),
				course.getDescription(), course.getPrereqCourseID());
		}
		return true;
	}

	@Override
	public boolean updateProfessorToCourse(int courseID, int professorID) {
		jdbcTemplateObject.jdbcTemplate().update(SQLConstants.COURSE_UPDATE_PROFESSORID, professorID, courseID);
		return true;
	}

	@Override
	public List<Course> findCourseByProfessorID(int professorID) {
		try {
			List<Course> courses = jdbcTemplateObject.jdbcTemplate().query(SQLConstants.COURSE_SELECT_BY_PROFESSORID,
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
		jdbcTemplateObject.jdbcTemplate().update(SQLConstants.COURSE_DELETE, courseID);
		return course;
	}

	@Override
	public Course findCourseByCourseID(int courseID) {
		try {
			Course course = jdbcTemplateObject.jdbcTemplate().queryForObject(SQLConstants.COURSE_SELECT_BY_COURSEID,
					new CourseMapper(), courseID);
			course = saveProfessorIntoCourse(course, course.getProf().getProfessorID());
			return course;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean updateCourse(Course course) {
		if (course.getPrereqCourseID() == -1) {
			jdbcTemplateObject.jdbcTemplate().update(SQLConstants.COURSE_UPDATE, course.getName(), course.getDepartment(),
					course.getDescription(), null, course.getCourseID());
		}
		else {
		jdbcTemplateObject.jdbcTemplate().update(SQLConstants.COURSE_UPDATE, course.getName(), course.getDepartment(),
				course.getDescription(), course.getPrereqCourseID(), course.getCourseID());
		}
		return true;

	}

}
