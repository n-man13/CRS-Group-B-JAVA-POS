package com.lti.bean;

/**
 * 
 * @author Nikhil, Luca
 *
 */
public class User {
	private String username;
	private String hashedPassword;
	private String role;
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
