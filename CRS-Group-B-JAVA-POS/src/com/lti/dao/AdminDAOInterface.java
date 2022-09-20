package com.lti.dao;

import com.lti.bean.Admin;

public interface AdminDAOInterface {
	/**
	 * 
	 * @param admin the admin to create
	 * @return new ID if created successfully, else -1
	 */
	public int createAdmin(Admin admin);
}
