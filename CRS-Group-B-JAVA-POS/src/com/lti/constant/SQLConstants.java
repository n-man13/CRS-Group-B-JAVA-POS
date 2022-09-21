package com.lti.constant;

public class SQLConstants {
	
	public static final String USER_INSERT = "INSERT INTO User VALUES(?,?,?)";
	public static final String USER_SELECT = "SELECT userID, username , password, role FROM User";
	public static final String STUDENT_INSERT = "INSERT INTO Student VALUES(?,?)";
	public static final String STUDENT_SELECT = "SELECT studentID, name FROM Student";
	public static final String PROFESSOR_INSERT = "INSERT INTO Professor VALUES(?,?)";
	public static final String PROFESSOR_SELECT = "SELECT professorID, name FROM Professor";
	public static final String COURSE_SELECT_BY_COURSEID = "SELECT courseID, name , department, description, professorID, prereqID FROM Course WHERE courseID='?'";
	public static final String COURSE_SELECT_BY_PROFESSORID = "SELECT courseID, name , department, description, professorID, prereqID FROM Course WHERE professorID='?'";
	public static final String COURSE_SELECT_ALL_COURSES = "SELECT courseID, name , department, description, professorID, prereqID FROM Course";
	public static final String COURSE_DELETE = "DELETE FROM Course WHERE courseID='?'";
	public static final String COURSE_UPDATE = "UPDATE Course SET professorID='?' WHERE courseID='?'";
	public static final String COURSE_INSERT = "INSERT INTO Course VALUES(?,?,?,?,?,?)";
	public static final String ADMIN_INSERT = "INSERT INTO Admin VALUES(?)";
	
}
