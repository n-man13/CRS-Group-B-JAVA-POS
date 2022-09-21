package com.lti.app;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;
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
		int professorId = professor.getProfID();
		
		System.out.println("*****Welcome Professor*****");
		System.out.println("Enter your choice: ");
		System.out.println("1. Apply to course");
		System.out.println("2. Record grade");
		System.out.println("3. View students");
		System.out.println("4. Log out");
		int professorChoice = Integer.parseInt(scan.nextLine());
		switch (professorChoice) {
		case 1:
			System.out.println("You have selected Apply to course");
			this.displayCourses(courseService.viewAllCourses());
			System.out.println("Please select the course ID");
			int courseId = scan.nextInt();
			professorService.applyToCourse(professorChoice, courseId);
		break;
		case 2:
			System.out.println("You have selected Record grade");
			this.displayCourses(professorService.viewProfessorCourses(professorId));
			System.out.println("Please select the course ID to view students");
			courseId = scan.nextInt();
			this.displayStudents(professorService.viewStudents(courseId));
			System.out.println("Please select the student ID to add grade");
			int studentId = scan.nextInt();
			System.out.println("Please enter the grade");
			double grade = scan.nextDouble();
			professorService.recordGrade(grade, studentId, courseId);
		break;
		// TODO all cases with method called from service layer
		case 3:
			System.out.println("You have selected View students");
			this.displayCourses(professorService.viewProfessorCourses(professorId));
			System.out.println("Please select the course ID to view students");
			courseId = scan.nextInt();
			Map<Student, Double> viewStudentGrades = professorService.viewStudentsGrades(courseId);
			for (Student s : viewStudentGrades.keySet()) {
				System.out.println("Id: " + s.getStudentID() +
						"\nName: " + s.getName() + 
						"\nGrade" + viewStudentGrades.get(s));
			}
		break;
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
	private void displayStudents(List <Student> students) {
		for (Student s : students) {
			System.out.println("Id: " + s.getUserID() +
			"\nName: " + s.getName());
		}
	}

}
