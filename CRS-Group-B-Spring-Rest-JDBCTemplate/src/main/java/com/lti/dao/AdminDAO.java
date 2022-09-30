package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.dto.Admin;

@Repository
public class AdminDAO implements AdminDAOInterface{

	@Override
	public int createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Admin findAdminByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findAdminByAdminID(int adminID) {
		// TODO Auto-generated method stub
		return null;
	}

}
