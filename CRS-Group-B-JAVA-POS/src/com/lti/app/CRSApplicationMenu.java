/**
 * 
 */
package com.lti.app;

import java.util.Scanner;

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
		    			userMenu = studentMenu.studentMenu();
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
			
	}

}
