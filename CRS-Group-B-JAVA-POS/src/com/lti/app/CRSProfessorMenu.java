package com.lti.app;

import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.service.CourseService;
import com.lti.service.CourseServiceInterface;
import com.lti.service.ProfessorService;
import com.lti.service.ProfessorServiceInterface;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceInterface;

public class CRSProfessorMenu {
	
	public boolean professorMenu(Professor professor, Scanner scan) {
		
		StudentServiceInterface studentService = new StudentService();
		CourseServiceInterface courseService = new CourseService();
		ProfessorServiceInterface professorService = new ProfessorService();
		
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
			this.displayCourses(courseService.viewAllCourses());
			System.out.println("Please select the course ID");
			int courseId = scan.nextInt();
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
	
	private void displayCourses(List <Course> courses) {
		for (Course c : courses) {
			System.out.println("Id: " + c.getCourseID() +
			"\nName: " + c.getName() + 
			"\nDepartment: " + c.getDepartment() +
			"\nPrerequisite" + c.getPrereqCourseID());
		}
	}

}
