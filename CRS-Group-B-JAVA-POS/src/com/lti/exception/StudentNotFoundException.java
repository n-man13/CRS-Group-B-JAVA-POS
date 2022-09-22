package com.lti.exception;

public class StudentNotFoundException extends Exception {

	private int studentID;

	public StudentNotFoundException(String message, int studentID) {
		super(message);
		this.studentID = studentID;
	}

	public int getStudentID() {
		return studentID;
	}

}
