package com.lti.exception;

public class CourseAlreadyRegisteredException extends Exception {

	private int courseID;
	
	/**
	 * 
	 * @param message the message to be written
	 * @param courseID the course id that is registered for
	 */
	public CourseAlreadyRegisteredException(String message, int courseID) {
		super(message);
		this.courseID = courseID;
	}
	
	/**
	 * 
	 * @return the course id
	 */
	public int getCourseID() {
		return courseID;
	}
}
