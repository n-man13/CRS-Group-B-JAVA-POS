package com.lti.app;

import java.util.Scanner;

public class CRSAdminMenu {
	
	public boolean adminMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*****Welcome Admin*****");
		System.out.println("Enter your choice: ");
		System.out.println("1. Create course");
		System.out.println("2. Delete course");
		System.out.println("2. Update course");
		System.out.println("4. View all courses");
		System.out.println("5. Approve registration");
		System.out.println("6. Log out");
		int adminChoice = Integer.parseInt(scan.nextLine());
		switch (adminChoice) {
		case 1:
			System.out.println("Create course");
		break;
		
		// TODO all cases with method called from service layer
		
		case 6:
			System.out.println("Please press enter to log out");
			scan.nextLine();
			return false;
		default: System.out.println("Method is not implemented or invalid input");
			
		}
		return true;
	}
	
	

}
