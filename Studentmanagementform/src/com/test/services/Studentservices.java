package com.test.services;

import java.util.List;

import com.test.models.Student;

public interface Studentservices {
	
	public boolean addstudent(Student s);
	
	public boolean deletestudent(int id);
	public Student getbyid(int id);
	public boolean updateStudent(Student s);
	public List<Student> getstudents();
	

}
