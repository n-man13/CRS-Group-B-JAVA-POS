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
	 * @return if professor was created and saved
	 */
	public boolean createProfessor(Professor prof);
	
}
