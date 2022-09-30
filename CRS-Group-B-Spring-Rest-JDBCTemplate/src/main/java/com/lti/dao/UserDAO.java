/**
 * 
 */
package com.lti.dao;

import com.lti.dto.User;

/**
 * @author user101
 *
 */
public class UserDAO implements UserDAOInterface {

	@Override
	public int createUser(String username, String password, int role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
