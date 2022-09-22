/**
 * 
 */
package com.lti.dao;

import java.util.List;

import com.lti.bean.*;

/**
 * @author user101
 *
 */
public interface StudentDAOInterface {
	/**
	 * 
	 * @param student  the student to add
	 * @return new ID if created successfully, else -1
	 */
	public int createStudent(Student student);
	
	/**
	 * 
	 * @param username the username of the User bean
	 * @return the Student associated with the username
	 */
	public Student viewStudent(String username);
	
	/**
	 * 
	 * @param studentID the id of the student to find
	 * @return the student associated with the id
	 */
	public Student viewStudent(int studentID);

	/**
	 * 
	 * @param student student with updated information associated with studentID
	 * @return if update occurred
	 */
	public boolean updateStudent(Student student);
	
	/**
	 * 
	 * @return list of all unregistered students
	 */
	public List<Student> viewUnregisteredStudents();
}
