/**
 * 
 */
package com.lti.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.lti.bean.Catalog;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.service.ProfessorService;
import com.lti.service.ProfessorServiceInterface;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceInterface;
import com.lti.service.UserService;
import com.lti.service.UserServiceInterface;

/**
 * @author Nikhil, Luca, Muhammad
 *
 */
public class CRSApplicationMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		Scanner scan = new Scanner(System.in);
		boolean homeMenu = true;
		CRSAdminMenu adminMenu = new CRSAdminMenu();
		CRSProfessorMenu professorMenu = new CRSProfessorMenu();
		CRSStudentMenu studentMenu = new CRSStudentMenu();
		UserServiceInterface userService = new UserService();
		StudentServiceInterface studentService = new StudentService();
		ProfessorServiceInterface professorService = new ProfessorService();
		
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
		    	System.out.println("1. Admin");
		    	System.out.println("2. Professor");
		    	System.out.println("3. Student");
		    	int role = Integer.parseInt(scan.nextLine());
		    	boolean logInSuccess = userService.verifyCredetials(username, password, role);
		    	if (logInSuccess) {
			    	while(userMenu) {
			    		switch(role) {
			    		case 3:
			    			Student student = studentService.getStudentByUsername(username);
			    			userMenu = studentMenu.studentMenu(student, scan);	
		    			break;
			    		case 2:
			    			Professor professor = professorService.getProfessorByUsername(username);
			    			userMenu = professorMenu.professorMenu(professor, scan);
	    				break;
			    		case 1:
			    			
			    			userMenu = adminMenu.adminMenu();
		    			break;
		    			default: System.out.println("Invalid Role");
			    		}	
		    		
		    		loginMenu = false;
			    	}
		    	}
		    	else {
		    		System.out.println("You entered the wrong credentials");
		    	}
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
