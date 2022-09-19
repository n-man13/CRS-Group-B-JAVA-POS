/**
 * 
 */
package com.lti.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.lti.bean.Catalog;
import com.lti.bean.Course;
import com.lti.bean.Student;

/**
 * @author Nikhil, Luca, Muhammad
 *
 */
public class CRSApplicationMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// need to take input
		// 
		
		Catalog courseCatalog = new Catalog();
		Course course1 = new Course(1, "math", 0);
		Course course2 = new Course(2, "physics", 0);
		Course course3 = new Course(3, "chemistry", 0);
		ArrayList <Course> courses = new ArrayList <Course> ();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		Student student1 = new Student(1);
		Student student2 = new Student(2);
		Student student3 = new Student(3);
		ArrayList <Student> students = new ArrayList <Student> ();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		Scanner scan = new Scanner(System.in);
		boolean homeMenu = true;
		CRSAdminMenu adminMenu = new CRSAdminMenu();
		CRSProfessorMenu professorMenu = new CRSProfessorMenu();
		CRSStudentMenu studentMenu = new CRSStudentMenu();
		
		while (homeMenu) {
			boolean loginMenu = true;
			System.out.println("*****Welcome to CRS Application*****");
			System.out.println("Enter your choice: ");
			System.out.println("1. Login");
			System.out.println("2. Student registration");
			System.out.println("3. Update password");
			System.out.println("4. Exit");
			int choice = Integer.parseInt(scan.nextLine());
			switch(choice){  
		    //Case statements  
		    case 1: 
		    while (loginMenu) {
		    	boolean userMenu = true;
		    	System.out.println("Enter Username: ");
		    	String username = scan.nextLine();
		    
		    	
		    	System.out.println("Enter Password: ");
		    	String password = scan.nextLine();
		    	System.out.println("Enter Role: ");
		    	System.out.println("1. Student");
		    	System.out.println("2. Professor");
		    	System.out.println("3. Admin");
		    	int role = Integer.parseInt(scan.nextLine());
		    	while(userMenu) {
		    		switch(role) {
		    		case 1:
		    			//TODO it should take a student as a parameter
		    			for (Student s: students) {
				    		if (s.getStudentID() == Integer.parseInt(username)) {
				    			userMenu = studentMenu.studentMenu(s, courses );
				    		}
				    		
				    	}
		    			
	    			break;
		    		case 2:
		    			//TODO it should take a professor as a parameter
		    			userMenu = professorMenu.professorMenu();
    				break;
		    		case 3:
		    			//TODO it should take a admin as a parameter
		    			userMenu = adminMenu.adminMenu();
	    			break;
	    			default: System.out.println("Invalid Role");
		    		}
		    	}
		    	System.out.println("Press enter to return to main page");
	    		scan.nextLine();
	    		loginMenu = false;
		    }
		    break;  
		    case 2: 
		    	System.out.println("*****Welcome to student registration*****");
		    	System.out.println("Enter Username: ");
		    	String username = scan.nextLine();
		    	System.out.println("Enter email");
		    	String email = scan.nextLine();
		    	System.out.println("Enter Password: ");
		    	String password = scan.nextLine();
		    	System.out.println("Repeat Password: ");
		    	String passwordCheck = scan.nextLine();
		    	System.out.println("Thank you for your registration, an email is sent to the admin for approval");
		    break;  
		    case 3: 
		    	System.out.println("*****Welcome to password reset*****");
		    	System.out.println("Please enter your email");
		    	String emailCheck = scan.nextLine();
		    	System.out.println("Please enter your username");
		    	String usernameCheck = scan.nextLine();
		    	System.out.println("An email has sent to your address to reset password");
		    break;
		    case 4:
		    	System.out.println("Press enter to exit");
	    		scan.nextLine();
	    		homeMenu = false;
		    //Default case statement 
    		break;
		    default:System.out.println("Invalid Operation");  
		    }
			
		}
		System.out.println("Thank you for using CRS, have a great day!");	
		scan.close();
	}

}
