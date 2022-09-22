package com.lti.exception;

public class CourseNotFoundException extends Exception {
	private int courseID;

	public CourseNotFoundException(int courseID) {
		this.courseID = courseID;
	}

	public double getCourseID() {
		return courseID;
	}
}
