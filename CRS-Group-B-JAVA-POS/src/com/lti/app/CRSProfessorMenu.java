package com.lti.app;

import java.util.Scanner;

import com.lti.bean.Professor;
import com.lti.service.CourseService;
import com.lti.service.CourseServiceInterface;
import com.lti.service.StudentService;

public class CRSProfessorMenu {
	
	public boolean professorMenu(Professor professor, Scanner scan) {
		
		StudentService studentService = new StudentService();
		CourseServiceInterface courseService = new CourseService();
		
		System.out.println("*****Welcome Professor*****");
		System.out.println("Enter your choice: ");
		System.out.println("1. Apply to course");
		System.out.println("2. Record grade");
		System.out.println("3. Check students");
		System.out.println("4. Log out");
		int professorChoice = Integer.parseInt(scan.nextLine());
		switch (professorChoice) {
		case 1:
			System.out.println("You have selected Apply to course");
			
		break;
		
		// TODO all cases with method called from service layer
		
		case 4:
			
			System.out.println("Please press enter to log out");
			scan.nextLine();
			return false;
		default: System.out.println("Method is not implemented or invalid input");
			
		}
		return true;
	}

}
