package com.lti.exception;

public class CourseFullException extends Exception {

	private int courseID;

	public CourseFullException(String message, int courseID) {
		super(message);
		this.courseID = courseID;
	}
	
	public int getCourseID() {
		return courseID;
	}
	
	
	
}
