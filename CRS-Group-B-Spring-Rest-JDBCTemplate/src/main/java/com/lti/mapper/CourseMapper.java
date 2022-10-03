package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.lti.dao.ProfessorDAO;
import com.lti.dao.ProfessorDAOInterface;
import com.lti.dto.Course;
import com.lti.dto.Student;

public class CourseMapper implements RowMapper<Course>{
	
	@Autowired
	ProfessorDAO professorDAO;
	
	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Course course = new Course();
		course.setCourseID(rs.getInt("courseID"));
		course.setName(rs.getString("name"));
		course.setDepartment(rs.getString("department"));
		course.setDescription(rs.getString("description"));
		course.setPrereqCourseID(rs.getInt("prereqID"));
		course.setProf(professorDAO.findProfessorByProfessorID(rs.getInt("professorID")));
		return course;
		
	}

}
