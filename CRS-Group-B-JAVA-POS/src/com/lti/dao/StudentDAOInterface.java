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
	 * @return if student was added successfully
	 */
	public boolean createStudent(Student student);

}
