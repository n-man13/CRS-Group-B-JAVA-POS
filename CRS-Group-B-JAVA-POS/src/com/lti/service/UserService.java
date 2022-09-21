package com.lti.service;

import com.lti.bean.User;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOInterface;

public class UserService implements UserServiceInterface {
	
	private UserDAOInterface userDAO = new UserDAO();
	private User user;

	public boolean verifyCredetials(String username, String password, int role) {
		
		user = userDAO.viewUser(username);
		if (user == null) return false;
		if (password.equals(user.getPassword()) && role == user.getRole()) {
			return true;
		}
		
		return false;
	}
	

	public void logOut() {

	}


	@Override
	public boolean verifyPasswordResetCredentials(int id, String username) {
		
		user = userDAO.viewUser(username);
		if (user == null) return false;
		if (username.equals(user.getPassword()) && id == user.getUserID()) {
			return true;
		}
		
		return false;
		
	}


	@Override
	public void updatePassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		userDAO.updatePassword(username, newPassword);
	}
}
