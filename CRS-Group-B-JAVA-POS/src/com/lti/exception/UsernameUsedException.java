package com.lti.exception;

public class UsernameUsedException extends Exception{
	private String username;
	
	public UsernameUsedException(String message, String username) {
		super(message);
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
}
