package com.lti.service;
//professor service interface

import java.util.ArrayList;
import com.lti.bean.*;

public interface ProfessorServiceInterface {
	
	public void applyToCourse (Course course) ;
	
	public void recordGrade (double grade, int StudentID, int classID);
	
	public ArrayList<Student> checkStudents () ;

}
