package com.lti.exception;

public class NoStudentsEnrolledException extends Exception{
	
	private int courseID;
	
	public NoStudentsEnrolledException(String message, int courseID) {
		super(message);
		this.courseID = courseID;
	}
	
	public int getCourseID() {
		return this.courseID;
	}

}
