package com.lti.bean;

/**
 * 
 * @author Nikhil, Luca, Muhammad
 *
 */
public class Admin extends User {
	private int adminID;

	
	/**
	 * 
	 * @param adminID
	 */
	public Admin(int adminID) {
		this.adminID = adminID;
	}
	
	public Admin() {
		super();
	}
	
	/**
	 * @return the adminID
	 */
	public int getAdminID() {
		return adminID;
	}
	
	
}
