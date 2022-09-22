package com.lti.service;

import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOInterface;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOInterface;

public class UserService implements UserServiceInterface {
	
	private UserDAOInterface userDAO = new UserDAO();
	private StudentDAOInterface studentDAO = new StudentDAO();
	private User user;
	private Student student;
	
	/**
	 * verify log in credentials
	 * @param username, password, int role
	 * @return true if credentials are correct, false if not
	 */	
	public boolean verifyCredetials(String username, String password, int role) {
		
		user = userDAO.viewUser(username);
		
		if (user == null) return false;
		if (role == 3) {
			student = studentDAO.viewStudent(user.getUserID());
			System.out.println(student.isRegistered());
			if (password.equals(user.getPassword()) && role == user.getRole() && student.isRegistered()) {
				return true;
			}
		}
		else {
			if (password.equals(user.getPassword()) && role == user.getRole()) {
				return true;
			}
		}

		
		return false;
	}
	

	public void logOut() {

	}

	/**
	 * verify password reset credentials
	 * @param username, password, int role
	 * @return true if credentials are correct, false if not
	 */	
	@Override
	public boolean verifyPasswordResetCredentials(int id, String username) {
		
		user = userDAO.viewUser(username);
		if (user == null) return false;
		if (username.equals(user.getUsername()) && id == user.getUserID()) {
			return true;
		}
		
		return false;
		
	}

	/**
	 * update password of user
	 * @param username, password
	 */	
	@Override
	public void updatePassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		userDAO.updatePassword(username, newPassword);
	}
}
