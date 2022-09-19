package com.lti.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.lti.bean.*;
import com.lti.service.StudentService;

public class CRSStudentMenu {
	
	public boolean studentMenu(Student student, ArrayList<Course> courses) {
		
//		//temporary data for testing
//		Catalog courseCatalog = new Catalog();
//		Course course1 = new Course(1, "math", 0);
//		Course course2 = new Course(2, "physics", 0);
//		Course course3 = new Course(3, "chemistry", 0);
//		ArrayList <Course> courses = new ArrayList <Course> ();
//		courses.add(course1);
//		courses.add(course2);
//		courses.add(course3);
		
//		
//		courseCatalog.setAllCourses(courses);
		StudentService studentService = new StudentService();
		Course currentCourse;
		
		
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*****Welcome Student*****");
		System.out.println("Enter your choice: ");
		System.out.println("1. Apply to course");
		System.out.println("2. Drop course");
		System.out.println("3. View applied courses");
		System.out.println("4. Make payment");
		System.out.println("5. Check grades");
		System.out.println("6. Apply to course");
		System.out.println("7. View all courses");
		System.out.println("8. Log out");
		int studentChoice = Integer.parseInt(scan.nextLine());
		switch (studentChoice) {
		case 1:
			System.out.println("You selected apply to course");
			int courseID ;
			System.out.println("Please tell me the course ID");
			courseID = scan.nextInt();
			
			for(Course c : courses) {
				if(c.getCourseID() == courseID) {
					studentService.applyToCourse(student, c);
				}
			}
		break;
		
		case 2:
			System.out.println("You selected Drop Course");
			System.out.println("Your Courses");
			for (Course c : student.getRegisteredCourses()) {
				System.out.println(c);
			}
			System.out.println("Please select the course ID");
			courseID = scan.nextInt();
			studentService.dropCourse(Student student, int id);
			break;
			
		case 3:
			System.out.println("You selected Display applied courses");
			for (Course c : student.getRegisteredCourses()) {
				System.out.println(c);
			}
			break;
		case 4:
			System.out.println("You selected Make Payment");
			break;
		
		case 5:
			System.out.println("You ");
		
		// TODO all cases with method implemented from service layer
		
		case 8:
			
			System.out.println("Please press enter to log out");
			scan.nextLine();
			scan.close();
			return false;
			
		default: System.out.println("Method is not implemented or invalid input");
		}
		scan.close();	
		return true;
	}

}
