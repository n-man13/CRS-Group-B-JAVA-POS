package com.lti.exception;

public class StudentNotFoundException extends Exception {

	private int studentID;

	/**
	 * 
	 * @param message the message to be written
	 * @param studentID the student id
	 */
	public StudentNotFoundException(String message, int studentID) {
		super(message);
		this.studentID = studentID;
	}

	/**
	 * 
	 * @return the student id
	 */
	public int getStudentID() {
		return studentID;
	}

}
