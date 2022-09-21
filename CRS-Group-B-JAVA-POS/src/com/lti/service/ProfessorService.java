package com.lti.service;

import java.util.ArrayList;

import com.lti.bean.*;
import com.lti.dao.ProfessorDAO;
import com.lti.dao.ProfessorDAOInterface;

public class ProfessorService implements ProfessorServiceInterface {
	
	private ProfessorDAOInterface professorDAO = new ProfessorDAO();

	public void applyToCourse(int professorId, int courseId) {
		// apply to specific course
	}

	public ArrayList<Student> checkStudents() {
		// view students in professor's course
		return null;
	}

	public void recordGrade(double grade, int StudentID, int classID) {
		// record grade for student in class

	}

	@Override
	public Professor getProfessorByUsername(String username) {
		
		return professorDAO.viewProfessor(username);
	}

}
