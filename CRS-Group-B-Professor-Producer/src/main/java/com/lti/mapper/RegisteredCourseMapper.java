package com.lti.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.lti.dao.CourseDAO;
import com.lti.dao.StudentDAO;
import com.lti.dao.UserDAO;
import com.lti.dto.Course;
import com.lti.dto.Professor;
import com.lti.dto.RegisteredCourse;
import com.lti.dto.Student;

public class RegisteredCourseMapper implements RowMapper<RegisteredCourse>{
	
	@Autowired
	CourseDAO courseDAO;
	
	@Autowired
	StudentDAO studentDAO;

	@Override
	public RegisteredCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RegisteredCourse registeredCourse = new RegisteredCourse();
		
		registeredCourse.setStudent(new Student(rs.getInt("studentID")));
		registeredCourse.setCourse(new Course(rs.getInt("courseID")));
		registeredCourse.setFeePaid(rs.getBoolean("feePaid"));
		registeredCourse.setGrade(rs.getDouble("grade"));
		
		return registeredCourse;
		
	}

}
