package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.dto.Admin;
import com.lti.dto.Course;

@Repository
public class CourseDAO implements CourseDAOInterface{

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return null;
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
