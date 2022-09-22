package com.lti.exception;

public class AllCoursesPaidException extends Exception {
	
	private int studentID;
	
	/**
	 * 
	 * @param message the message to be written
	 * @param studentID the student id associated
	 */
	public AllCoursesPaidException(String message, int studentID) {
		super(message);
		this.studentID = studentID;
	}
	
	/**
	 * 
	 * @return returns student id
	 */
	public int getStudentID() {
		return studentID;
	}
}
