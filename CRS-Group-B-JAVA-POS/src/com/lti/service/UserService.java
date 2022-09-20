package com.lti.service;

import com.lti.bean.User;
import com.lti.dao.UserDAOInterface;

public class UserService implements UserServiceInterface {
	
	private UserDAOInterface userDAO;
	private User user;

	public boolean verifyCredetials(String username, String password, int role) {
		
		user = userDAO.viewUser(username);
		if (password == user.getPassword() && role == user.getRole()) {
			return true;
		}
		
		return false;
	}

	public void logOut() {

	}
}
