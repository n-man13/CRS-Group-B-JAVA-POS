package com.lti.service;

//user service interface
public interface UserServiceInterface {
	
	public boolean verifyCredetials(String username, String password, int role);

	public boolean verifyPasswordResetCredentials(int id, String username);
	
	public void updatePassword(String username, String newPassword);
	
	public void logOut();
}
