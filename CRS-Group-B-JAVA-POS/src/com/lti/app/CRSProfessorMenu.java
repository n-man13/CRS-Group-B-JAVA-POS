package com.lti.app;

import java.util.Scanner;

public class CRSProfessorMenu {
	
	public boolean professorMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*****Welcome Professor*****");
		System.out.println("Enter your choice: ");
		System.out.println("1. Apply to course");
		System.out.println("2. Record grade");
		System.out.println("3. Check students");
		System.out.println("4. Log out");
		int professorChoice = Integer.parseInt(scan.nextLine());
		switch (professorChoice) {
		case 1:
			System.out.println("Please apply to course");
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
