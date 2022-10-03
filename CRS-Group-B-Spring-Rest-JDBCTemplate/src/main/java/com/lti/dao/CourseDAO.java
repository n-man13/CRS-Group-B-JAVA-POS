package com.lti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.configuration.JDBCConfiguration;
import com.lti.dto.Admin;
import com.lti.dto.Course;
import com.lti.mapper.CourseMapper;
import com.lti.mapper.StudentMapper;

@Repository
public class CourseDAO implements CourseDAOInterface{
	
	@Autowired
	JDBCConfiguration jdbcTemplateObject;
	
	public static final String COURSE_SELECT = "SELECT * FROM Course";
	public static final String COURSE_INSERT = "INSERT INTO Course(name,department,description,professorID,prereqID) VALUES(?,?,?,NULL,?)";


	@Override
	public List<Course> findAllCourses() {
		try {
			return jdbcTemplateObject.jdbcTemplate().query(COURSE_SELECT, new CourseMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean createCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfessorToCourse(int courseID, int professorID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> findCourseByProfessorID(int professorID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course deleteCourse(int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCourseByCourseID(int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
