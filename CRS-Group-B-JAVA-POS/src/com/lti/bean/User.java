package com.lti.bean;

/**
 * 
 * @author Nikhil, Luca
 *
 */
public class User {
	private int userID;
	private String username;
	private String password;
	private int role;
<<<<<<< HEAD
=======
	
	public User() {
		userID = -1;
	}
	public User(int userID) {
		this.userID = userID;
	}
>>>>>>> branch 'main' of https://github.com/n-man13/CRS-Group-B-JAVA-POS.git
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
