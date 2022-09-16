package com.lti.service;

import com.lti.bean.Course;

public class CourseService implements CourseServiceInterface{
	
	Course course;
	
	public CourseService(int courseID) {
		course = new Course(courseID);
		
	}
	
	public void getNumberStudents() {
		//get number of students that applied on this course
		this.course.getStudents().size();
	}
	
	public void checkAvailability() {
		//check if course is not full (>10)
		if(this.course.getStudents().size() <= 10) {
			System.out.println("This course is available");
		}
		else {
			System.out.println("This course is not available");
		}
	}
	
	public void notifyStudent() {
		//notify student if course isn't available
		
	}
	

}
