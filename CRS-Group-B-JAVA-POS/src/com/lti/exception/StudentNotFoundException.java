package com.lti.exception;

public class StudentNotFoundException extends Exception {

	private int studentID;

	public StudentNotFoundException(int studentID) {
		this.studentID = studentID;
	}

	public int getStudentID() {
		return studentID;
	}

}
