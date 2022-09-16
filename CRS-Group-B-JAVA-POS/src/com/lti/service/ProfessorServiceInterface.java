package com.lti.service;
//professor service interface

import com.lti.bean.*;

public interface ProfessorServiceInterface {
	
	public void applyToCourse (Course course) ;
	
	public void recordGrade ();
	
	public void checkStudents () ;

}
