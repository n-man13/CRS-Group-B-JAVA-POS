package com.lti.exception;

public class CourseAlreadyRegisteredException extends Exception {

	private int courseID;
	
	public CourseAlreadyRegisteredException(String message, int courseID) {
		super(message);
		this.courseID = courseID;
	}
}
