package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.dto.Professor;

@Repository
public class ProfessorDAO implements ProfessorDAOInterface{

	@Override
	public int createProfessor(Professor professor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Professor findProfessorByProfessorID(int professorID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor findProfessorByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
