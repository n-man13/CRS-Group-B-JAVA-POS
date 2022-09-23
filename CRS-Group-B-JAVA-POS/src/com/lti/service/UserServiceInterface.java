package com.lti.service;

import com.lti.exception.StudentNotFoundException;

//user service interface
public interface UserServiceInterface {
	
	/**
	 * verify log in credentials
	 * @param username, password, int role
	 * @return true if credentials are correct, false if not
	 * @throws StudentNotFoundException if the student needs to be approved
	 */	
	public boolean verifyCredetials(String username, String password, int role) throws StudentNotFoundException;

	/**
	 * verify password reset credentials
	 * @param username, password, int role
	 * @return true if credentials are correct, false if not
	 */	
	public boolean verifyPasswordResetCredentials(int id, String username);
	
	/**
	 * update password of user
	 * @param username, password
	 */	
	public void updatePassword(String username, String newPassword);
	
}
