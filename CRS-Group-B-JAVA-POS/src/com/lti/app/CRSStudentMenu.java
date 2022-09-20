package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lti.bean.*;
import com.lti.service.CourseService;
import com.lti.service.CourseServiceInterface;
import com.lti.service.StudentService;

public class CRSStudentMenu {
	
	public boolean studentMenu(Student student, Scanner scan) {
		
		StudentService studentService = new StudentService();
		CourseServiceInterface courseService = new CourseService();
		int studentId = student.getStudentID();
		
		System.out.println("*****Welcome Student "+ student.getUsername() +"*****");
		System.out.println("Enter your choice: ");
		System.out.println("1. Apply to course");
		System.out.println("2. Drop course");
		System.out.println("3. View applied courses");
		System.out.println("4. Make payment");
		System.out.println("5. Check grades");
		System.out.println("6. View all courses");
		System.out.println("7. Log out");
		int studentChoice = Integer.parseInt(scan.nextLine());
		switch (studentChoice) {
		case 1:
			
			System.out.println("You have selected apply to course");
			this.displayCourses(courseService.viewAllCourses());
			System.out.println("Please select the course ID");
			int courseId = scan.nextInt();
			//Parameters (studentId, courseId)
			studentService.applyToCourse(studentId, courseId);			
		break;
		
		case 2:
			System.out.println("You have selected Drop Course");
			this.displayCourses(studentService.viewAppliedCourses(studentId));
			System.out.println("Please select the course ID");
			courseId = scan.nextInt();
			//Parameters (studentId, courseId)
			studentService.dropCourse(studentId, courseId);
			break;
			
		case 3:
			System.out.println("You have selected Display applied Courses");
			this.displayCourses(studentService.viewAppliedCourses(studentId));
			break;
			
		case 4:
			System.out.println("You have selected Make Payment");
			System.out.println("List of unpayed courses");
			this.displayCourses(studentService.viewUnpayedCourses(studentId));
			System.out.println("Please select what course to pay");
			courseId = scan.nextInt();
			studentService.makePayment(studentId, courseId);
			break;
		
		case 5:
			System.out.println("You selected Check Grades");
			Map<Course, Double> courseAndGrades = studentService.checkGrades(studentId);
			for (Course c : courseAndGrades.keySet()) {
				System.out.println("Id: " + c.getCourseID() +
						"\nName: " + c.getName() + 
						"\nDepartment: " + c.getDepartment() +
						"\nGrade" + courseAndGrades.get(c));
			}
		break;	
		case 6:
			System.out.println("You selected Display all Courses");
			courseService.viewAllCourses();
		break;
		
		case 7:	
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
