package com.lti.exception;

public class UsernameUsedException extends Exception{
	private String username;
	
	/**
	 * 
	 * @param message the message to be written
	 * @param username the username that is in use
	 */
	public UsernameUsedException(String message, String username) {
		super(message);
		this.username = username;
	}
	
	/**
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
}
