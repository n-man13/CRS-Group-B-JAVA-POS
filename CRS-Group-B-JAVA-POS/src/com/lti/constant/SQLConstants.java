package com.lti.constant;

public class SQLConstants {
	
	public static final String USER_INSERT = "insert into User values(?,?,?)";
	public static final String USER_SELECT = "SELECT userID, username , password, role FROM User";
	public static final String STUDENT_INSERT = "INSERT INTO Student VALUES(?,?)";
	public static final String STUDENT_SELECT = "SELECT studentID, name FROM Student";
	public static final String PROFESSOR_INSERT = "insert into Professor values(?,?)";
	public static final String PROFESSOR_SELECT = "SELECT professorID, name FROM Professor";
	public static final String COURSE_SELECT_BY_COURSEID = "SELECT courseID, name , department, description, professorID, prereqID FROM Course WHERE courseID='?'";
	public static final String COURSE_SELECT_ALL_COURSES = "SELECT courseID, name , department, description, professorID, prereqID FROM Course";
	public static final String COURSE_DELETE = "DELETE FROM Course WHERE courseID='?'";
	public static final String COURSE_UPDATE = "UPDATE Course SET professorID='?' WHERE courseID='?'";
	public static final String COURSE_INSERT = "insert into Course values(?,?,?,?,?,?)";
	public static final String ADMIN_INSERT = "insert into Admin values(?)";
	
}
