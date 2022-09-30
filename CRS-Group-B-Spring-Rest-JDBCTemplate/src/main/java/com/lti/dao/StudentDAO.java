/**
 * 
 */
package com.lti.dao;

import java.util.List;

import com.lti.dto.Student;

/**
 * @author user101
 *
 */
public class StudentDAO implements StudentDAOInterface {

	@Override
	public int createStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findStudent(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudent(int studentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> findUnregisteredStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
