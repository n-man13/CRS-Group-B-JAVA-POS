package com.lti.service;

//user service interface
public interface UserServiceInterface {
	
	public boolean verifyCredetials(String username, String password, int role);

	public void logOut();
}
