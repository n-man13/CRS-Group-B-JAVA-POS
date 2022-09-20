/**
 * 
 */
package com.lti.dao;

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
	
	public Student viewStudent(String username);
	
	public Student viewStudent(int studentID);

}
