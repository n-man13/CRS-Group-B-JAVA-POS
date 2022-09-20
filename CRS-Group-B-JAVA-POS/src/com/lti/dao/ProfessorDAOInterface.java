/**
 * 
 */
package com.lti.dao;

import com.lti.bean.Professor;

/**
 * @author user101
 *
 */
public interface ProfessorDAOInterface {

	/**
	 * 
	 * @param prof new professor to add
	 * @return new ID if created successfully, else -1
	 */
	public int createProfessor(Professor prof);
	
	public Professor viewProfessor(int profID);
}
