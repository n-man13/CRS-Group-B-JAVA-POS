package com.lti.app;

import java.util.Scanner;

public class CRSStudentMenu {
	
	public boolean studentMenu() {
		
		
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
			System.out.println("Please apply to course");
		break;
		
		// TODO all cases with method implemented from service layer
		
		case 8:
			
			System.out.println("Please press enter to log out");
			scan.nextLine();
			return false;
			
		default: System.out.println("Method is not implemented or invalid input");
		}
		return true;
	}

}
