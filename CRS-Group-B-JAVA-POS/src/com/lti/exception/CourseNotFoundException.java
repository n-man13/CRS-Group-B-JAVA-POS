package com.lti.exception;

public class CourseNotFoundException extends Exception {
	private int courseID;

	public CourseNotFoundException(String message, int courseID) {
		super(message);
		this.courseID = courseID;
	}

	public int getCourseID() {
		return courseID;
	}
}
