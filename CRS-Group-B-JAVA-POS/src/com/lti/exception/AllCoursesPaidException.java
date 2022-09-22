package com.lti.exception;

public class AllCoursesPaidException extends Exception {
	
	private int studentID;
	
	public AllCoursesPaidException(String message, int studentID) {
		super(message);
		this.studentID = studentID;
	}
	
	public int getStudentID() {
		return studentID;
	}
}
